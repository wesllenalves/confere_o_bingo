package com.wesllen.confereobingo.view

import android.Manifest
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.ActivityResultCallback
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import com.google.android.gms.tasks.Task
import com.google.mlkit.vision.common.InputImage
import com.google.mlkit.vision.text.Text
import com.google.mlkit.vision.text.TextRecognition
import com.google.mlkit.vision.text.TextRecognizer
import com.google.mlkit.vision.text.TextRecognizerOptions
import com.theartofdev.edmodo.cropper.CropImage
import com.theartofdev.edmodo.cropper.CropImageView
import com.wesllen.confereobingo.GradeNumericaActivity
import com.wesllen.confereobingo.R
import java.lang.Exception

class MainActivity : AppCompatActivity() {
    lateinit var tvResult: TextView
    lateinit var btnChoosePic: Button
    lateinit var btnChooseCam: Button
    lateinit var btnGradeNumerica: Button
    lateinit var image: ImageView

    var intentActivityResultLauncher:ActivityResultLauncher<Intent>?=null

    lateinit var inputImage: InputImage
    lateinit var textRecognizer: TextRecognizer

    private val STORAGE_PERMISSION_CODE=113
    private val CAMERA_PERMISSION_CODE=123
    private val GALLERY_REQUEST_CODE = 1234

    private val TAG: String = "AppDebug"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvResult=findViewById(R.id.tvResult)
        btnChoosePic=findViewById(R.id.btnChoosePic)
        btnChooseCam=findViewById(R.id.btnChooseCam)
        btnGradeNumerica=findViewById(R.id.btnGradeNumerica)
        image=findViewById(R.id.image)

        textRecognizer = TextRecognition.getClient(TextRecognizerOptions.DEFAULT_OPTIONS)

        intentActivityResultLauncher=registerForActivityResult(
            ActivityResultContracts.StartActivityForResult(),
            ActivityResultCallback {
                //here we handle result
                val data=it.data
                val imageUri=data?.data

                convertImageToText(imageUri)
            }
        )

        btnChoosePic.setOnClickListener {
            /*val chooseIntent=Intent()
            chooseIntent.type="image/*"
            chooseIntent.action=Intent.ACTION_GET_CONTENT
            intentActivityResultLauncher?.launch(chooseIntent)*/

             */
            pickFromGallery()
        }

        btnChooseCam.setOnClickListener {
            checkPermission(Manifest.permission.CAMERA,CAMERA_PERMISSION_CODE)
            var i = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivityForResult(i, CAMERA_PERMISSION_CODE)
        }

        btnGradeNumerica.setOnClickListener {
            irParaGradeNumerica()
        }
    }

    private fun irParaGradeNumerica() {
        val gradeNumerica = Intent(this, GradeNumericaActivity::class.java)
        startActivity(gradeNumerica)
    }

    private fun pickFromGallery() {
        val intent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
        intent.type = "image/*"
        val mimeTypes = arrayOf("image/jpeg", "image/png", "image/jpg")
        intent.putExtra(Intent.EXTRA_MIME_TYPES, mimeTypes)
        intent.setFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)
        startActivityForResult(intent, GALLERY_REQUEST_CODE)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when (requestCode) {
            /*GALLERY_REQUEST_CODE -> {
                if (requestCode == CAMERA_PERMISSION_CODE) {
                    var imageUri = data?.getParcelableExtra<Bitmap>("data")
                    convertImageTotextCamera(imageUri)

                }
            }*/

            GALLERY_REQUEST_CODE -> {
                if (resultCode == Activity.RESULT_OK) {
                    data?.data?.let { uri ->
                        launchImageCrop(uri)
                    }
                }
                else{
                    Log.e(TAG, "Image selection error: Couldn't select that image from memory." )
                }
            }

            CropImage.CROP_IMAGE_ACTIVITY_REQUEST_CODE -> {
                val result = CropImage.getActivityResult(data)
                if (resultCode == Activity.RESULT_OK) {
                    result.uri?.let{ uri ->
                        setImage(uri)
                        convertImageToText(uri)
                    }

                }
                else if (resultCode == CropImage.CROP_IMAGE_ACTIVITY_RESULT_ERROR_CODE) {
                    Log.e(TAG, "Crop error: ${result.getError()}" )
                }
            }

        }
    }

    private fun convertImageToText(imageUri: Uri?) {
        try {
            //prepare the input image
            inputImage= InputImage.fromFilePath(applicationContext,imageUri)

            //get Text from input image
            val result:Task<Text> = textRecognizer.process(inputImage)
                .addOnSuccessListener {
                    tvResult.text=it.text
                }.addOnFailureListener {
                    tvResult.text="Error: ${it.message}"
                }

        }catch (e:Exception) {

        }
    }

    private fun convertImageTotextCamera(image: Bitmap?) {
        try {
            //prepare the input image
            inputImage= InputImage.fromBitmap(image, 0)

            //get Text from input image
            val result:Task<Text> = textRecognizer.process(inputImage)
                .addOnSuccessListener {
                    tvResult.text=it.text
                }.addOnFailureListener {
                    tvResult.text="Error: ${it.message}"
                }

        }catch (e:Exception) {

        }
    }

    override fun onResume() {
        super.onResume()
        checkPermission(Manifest.permission.READ_EXTERNAL_STORAGE,STORAGE_PERMISSION_CODE)

    }

    private fun checkPermission(permission: String, requestCode:Int) {

        if (ContextCompat.checkSelfPermission(this@MainActivity,permission)==PackageManager.PERMISSION_DENIED){
            //Take Permission

            ActivityCompat.requestPermissions(this@MainActivity, arrayOf(permission), requestCode)
        }
        /*else{
            Toast.makeText(this@MainActivity, "Permission Granted already", Toast.LENGTH_LONG).show()
        }*/
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if(requestCode==STORAGE_PERMISSION_CODE) {
            if (grantResults.isNotEmpty() && grantResults[0]==PackageManager.PERMISSION_GRANTED){
                Toast.makeText(this@MainActivity, "Stoage Permission Granted", Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(this@MainActivity, "Stoage Permission Denied", Toast.LENGTH_SHORT).show()
            }
        } else if (requestCode==CAMERA_PERMISSION_CODE) {
            if (grantResults.isNotEmpty() && grantResults[0]==PackageManager.PERMISSION_GRANTED){
                Toast.makeText(this@MainActivity, "Camera Permission Granted", Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(this@MainActivity, "Camera Permission Denied", Toast.LENGTH_SHORT).show()
            }
        }

    }

    private fun setImage(uri: Uri){

        Glide.with(this)
            .load(uri)
            .into(image)


    }

    private fun launchImageCrop(uri: Uri){
        CropImage.activity(uri)
            .setGuidelines(CropImageView.Guidelines.ON)
            //.setAspectRatio(1920, 1080)
            .setCropShape(CropImageView.CropShape.RECTANGLE) // default is rectangle
            .start(this)
    }


}