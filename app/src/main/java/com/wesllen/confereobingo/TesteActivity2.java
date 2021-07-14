package com.wesllen.confereobingo;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class TesteActivity2 extends AppCompatActivity {
    private static final int[] idArray = { R.id.btn1, R.id.btn2, R.id.btn3, R.id.btn4, R.id.btn5, R.id.btn6, R.id.btn7, R.id.btn8,
            R.id.btn9, R.id.btn10, R.id.btn11, R.id.btn12, R.id.btn13, R.id.btn14, R.id.btn15, R.id.btn16, R.id.btn17, R.id.btn18,
            R.id.btn19, R.id.btn20, R.id.btn21, R.id.btn22, R.id.btn23, R.id.btn24, R.id.btn25};

    private Button[] btn = new Button[idArray.length];
    int i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teste2);


        for (i = 0; i<idArray.length; i++) {
            btn[i] = (Button) findViewById(idArray[i]);

            btn[i].setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    switch (v.getId()){
                        case R.id.btn1:
                            Toast.makeText(getApplicationContext(), "Botão 1", Toast.LENGTH_SHORT).show();
                            btn[i].setBackgroundColor(Color.parseColor("#FFFFFF"));
                            String colorCode = (String)btn[i].getTag();


                            break;
                        case R.id.btn2:
                            Toast.makeText(getApplicationContext(), "Botão 2", Toast.LENGTH_SHORT).show();
                            break;

                    }
                    return false;
                }
            });

            btn[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    switch (v.getId()){
                        case R.id.btn1:
                            Toast.makeText(getApplicationContext(), "Botão 1", Toast.LENGTH_SHORT).show();
                            break;
                        case R.id.btn2:
                            Toast.makeText(getApplicationContext(), "Botão 2", Toast.LENGTH_SHORT).show();
                            break;

                    }
                }
            });
        }

    }
}