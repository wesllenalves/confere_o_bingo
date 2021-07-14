package com.wesllen.confereobingo

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import com.wesllen.confereobingo.view.AddDialogFragment

class GradeNumericaActivity : AppCompatActivity() {
    private val btn = arrayOfNulls<Button>(GradeNumericaActivity.idArray.size)
    var i = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_grade_numerica)
        i = 0
        while (i < GradeNumericaActivity.idArray.size) {
            btn[i] = findViewById<View>(GradeNumericaActivity.idArray[i]) as Button


            btn[i]!!.setOnClickListener { v ->
                when (v.id) {
                    R.id.btn1 -> {
                        Toast.makeText(applicationContext, "Botão  0", Toast.LENGTH_SHORT)
                        .show()
                        btn[0]!!.isSelected = !btn[0]!!.isSelected
                    }
                    R.id.btn2 -> {
                        Toast.makeText(applicationContext, "Botão  1", Toast.LENGTH_SHORT)
                        .show()
                        btn[1]!!.isSelected = !btn[1]!!.isSelected
                    }
                    R.id.btn3 -> {
                        Toast.makeText(applicationContext, "Botão  2", Toast.LENGTH_SHORT)
                        .show()
                        btn[2]!!.isSelected = !btn[2]!!.isSelected
                    }
                    R.id.btn4 -> {
                        Toast.makeText(applicationContext, "Botão  3", Toast.LENGTH_SHORT)
                        .show()
                        btn[3]!!.isSelected = !btn[3]!!.isSelected
                    }
                    R.id.btn5 -> {
                        Toast.makeText(applicationContext, "Botão  4", Toast.LENGTH_SHORT)
                        .show()
                        btn[4]!!.isSelected = !btn[4]!!.isSelected
                    }
                    R.id.btn6 -> {
                        Toast.makeText(applicationContext, "Botão  5", Toast.LENGTH_SHORT)
                        .show()
                        btn[5]!!.isSelected = !btn[5]!!.isSelected
                    }
                    R.id.btn7 -> {
                        Toast.makeText(applicationContext, "Botão  6", Toast.LENGTH_SHORT)
                            .show()
                        btn[6]!!.isSelected = !btn[6]!!.isSelected
                    }
                    R.id.btn8 -> {
                        Toast.makeText(applicationContext, "Botão  7", Toast.LENGTH_SHORT)
                        .show()
                        btn[7]!!.isSelected = !btn[7]!!.isSelected
                    }
                    R.id.btn9 -> {
                        Toast.makeText(applicationContext, "Botão  8", Toast.LENGTH_SHORT)
                        .show()
                        btn[8]!!.isSelected = !btn[8]!!.isSelected
                    }
                    R.id.btn10 -> {
                        Toast.makeText(applicationContext, "Botão  9", Toast.LENGTH_SHORT)
                        .show()
                        btn[9]!!.isSelected = !btn[9]!!.isSelected
                    }
                    R.id.btn11 -> {
                        Toast.makeText(applicationContext, "Botão  10", Toast.LENGTH_SHORT)
                        .show()
                        btn[10]!!.isSelected = !btn[10]!!.isSelected
                    }
                    R.id.btn12 -> {
                        Toast.makeText(applicationContext, "Botão  11", Toast.LENGTH_SHORT)
                        .show()
                        btn[11]!!.isSelected = !btn[11]!!.isSelected
                    }
                    R.id.btn13 -> {
                        Toast.makeText(applicationContext, "Botão  12", Toast.LENGTH_SHORT)
                        .show()
                        btn[12]!!.isSelected = !btn[12]!!.isSelected
                    }
                    R.id.btn14 -> {
                        Toast.makeText(applicationContext, "Botão  13", Toast.LENGTH_SHORT)
                        .show()
                        btn[13]!!.isSelected = !btn[13]!!.isSelected
                    }
                    R.id.btn15 -> {
                        Toast.makeText(applicationContext, "Botão  15", Toast.LENGTH_SHORT)
                        .show()
                        btn[14]!!.isSelected = !btn[14]!!.isSelected
                    }
                    R.id.btn16 -> {
                        Toast.makeText(applicationContext, "Botão  16", Toast.LENGTH_SHORT)
                        .show()
                        btn[15]!!.isSelected = !btn[15]!!.isSelected
                    }
                    R.id.btn17 -> {
                        Toast.makeText(applicationContext, "Botão  17", Toast.LENGTH_SHORT)
                        .show()
                        btn[16]!!.isSelected = !btn[16]!!.isSelected
                    }
                    R.id.btn18 -> {
                        Toast.makeText(applicationContext, "Botão  18", Toast.LENGTH_SHORT)
                        .show()
                        btn[17]!!.isSelected = !btn[17]!!.isSelected
                    }
                    R.id.btn19 -> {
                        Toast.makeText(applicationContext, "Botão  19", Toast.LENGTH_SHORT)
                        .show()
                        btn[18]!!.isSelected = !btn[18]!!.isSelected
                    }
                    R.id.btn20 -> {
                        Toast.makeText(applicationContext, "Botão  20", Toast.LENGTH_SHORT)
                        .show()
                        btn[19]!!.isSelected = !btn[19]!!.isSelected
                    }
                    R.id.btn21 -> {
                        Toast.makeText(applicationContext, "Botão  21", Toast.LENGTH_SHORT)
                        .show()
                        btn[20]!!.isSelected = !btn[20]!!.isSelected
                    }
                    R.id.btn22 -> {
                        Toast.makeText(applicationContext, "Botão  22", Toast.LENGTH_SHORT)
                        .show()
                        btn[21]!!.isSelected = !btn[21]!!.isSelected
                    }
                    R.id.btn23 -> {
                        Toast.makeText(applicationContext, "Botão  23", Toast.LENGTH_SHORT)
                        .show()
                        btn[22]!!.isSelected = !btn[22]!!.isSelected
                    }
                    R.id.btn24 -> {
                        Toast.makeText(applicationContext, "Botão  24", Toast.LENGTH_SHORT)
                        .show()
                        btn[23]!!.isSelected = !btn[23]!!.isSelected
                    }
                    R.id.btn25 -> {
                        Toast.makeText(applicationContext, "Botão  25", Toast.LENGTH_SHORT)
                        .show()
                        btn[24]!!.isSelected = !btn[24]!!.isSelected
                    }
                }
            }

            btn[i]!!.setOnLongClickListener { v ->
                when (v.id) {
                    R.id.btn1 -> {
                        editNumber()
                        Toast.makeText(applicationContext, "Botão Longo 0 ", Toast.LENGTH_SHORT)
                        .show()
                    }
                    R.id.btn2 -> Toast.makeText(applicationContext, "Botão Longo 1", Toast.LENGTH_SHORT)
                        .show()
                    R.id.btn3 -> Toast.makeText(applicationContext, "Botão Longo 2", Toast.LENGTH_SHORT)
                        .show()
                    R.id.btn4 -> Toast.makeText(applicationContext, "Botão Longo 3", Toast.LENGTH_SHORT)
                        .show()
                    R.id.btn5 -> Toast.makeText(applicationContext, "Botão Longo 4", Toast.LENGTH_SHORT)
                        .show()
                    R.id.btn6 -> Toast.makeText(applicationContext, "Botão Longo 5", Toast.LENGTH_SHORT)
                        .show()
                    R.id.btn7 -> Toast.makeText(applicationContext, "Botão Longo 6", Toast.LENGTH_SHORT)
                        .show()
                    R.id.btn8 -> Toast.makeText(applicationContext, "Botão Longo 7", Toast.LENGTH_SHORT)
                        .show()
                    R.id.btn9 -> Toast.makeText(applicationContext, "Botão Longo 8", Toast.LENGTH_SHORT)
                        .show()
                    R.id.btn10 -> Toast.makeText(applicationContext, "Botão Longo 9", Toast.LENGTH_SHORT)
                        .show()
                    R.id.btn11 -> Toast.makeText(applicationContext, "Botão Longo 10", Toast.LENGTH_SHORT)
                        .show()
                    R.id.btn12 -> Toast.makeText(applicationContext, "Botão Longo 11", Toast.LENGTH_SHORT)
                        .show()
                    R.id.btn13 -> Toast.makeText(applicationContext, "Botão Longo 12", Toast.LENGTH_SHORT)
                        .show()
                    R.id.btn14 -> Toast.makeText(applicationContext, "Botão Longo 13", Toast.LENGTH_SHORT)
                        .show()
                    R.id.btn15 -> Toast.makeText(applicationContext, "Botão Longo 15", Toast.LENGTH_SHORT)
                        .show()
                    R.id.btn16 -> Toast.makeText(applicationContext, "Botão Longo 16", Toast.LENGTH_SHORT)
                        .show()
                    R.id.btn17 -> Toast.makeText(applicationContext, "Botão Longo 17", Toast.LENGTH_SHORT)
                        .show()
                    R.id.btn18 -> Toast.makeText(applicationContext, "Botão Longo 18", Toast.LENGTH_SHORT)
                        .show()
                    R.id.btn19 -> Toast.makeText(applicationContext, "Botão Longo 19", Toast.LENGTH_SHORT)
                        .show()
                    R.id.btn20 -> Toast.makeText(applicationContext, "Botão Longo 20", Toast.LENGTH_SHORT)
                        .show()
                    R.id.btn21 -> Toast.makeText(applicationContext, "Botão Longo 21", Toast.LENGTH_SHORT)
                        .show()
                    R.id.btn22 -> Toast.makeText(applicationContext, "Botão Longo 22", Toast.LENGTH_SHORT)
                        .show()
                    R.id.btn23 -> Toast.makeText(applicationContext, "Botão Longo 23", Toast.LENGTH_SHORT)
                        .show()
                    R.id.btn24 -> Toast.makeText(applicationContext, "Botão Longo 24", Toast.LENGTH_SHORT)
                        .show()
                    R.id.btn25 -> Toast.makeText(applicationContext, "Botão Longo 25", Toast.LENGTH_SHORT)
                        .show()
                }
                true
            }

            i++
        }
    }

    private fun editNumber() {
        val dialog  = AddDialogFragment()
        dialog.show(supportFragmentManager, dialog.tag)
    }

    companion object {
        private val idArray = intArrayOf(
            R.id.btn1,
            R.id.btn2,
            R.id.btn3,
            R.id.btn4,
            R.id.btn5,
            R.id.btn6,
            R.id.btn7,
            R.id.btn8,
            R.id.btn9,
            R.id.btn10,
            R.id.btn11,
            R.id.btn12,
            R.id.btn13,
            R.id.btn14,
            R.id.btn15,
            R.id.btn16,
            R.id.btn17,
            R.id.btn18,
            R.id.btn19,
            R.id.btn20,
            R.id.btn21,
            R.id.btn22,
            R.id.btn23,
            R.id.btn24,
            R.id.btn25
        )
    }
}