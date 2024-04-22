package com.example.login;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;


import androidx.appcompat.app.AppCompatActivity;



public class OtpScreen extends AppCompatActivity {
    EditText firstEdit,secEdit,thirdEdit,fourEdit;
    TextView numberText;
    Button submit;
    ImageView back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.otp);
        numberText = findViewById(R.id.number);
        back = findViewById(R.id.back);
        submit = findViewById(R.id.submit);
        firstEdit = findViewById(R.id.ed1);
        secEdit = findViewById(R.id.ed2);
        thirdEdit = findViewById(R.id.ed3);
        fourEdit = findViewById(R.id.ed4);
        SharedPreferences shared5 = getSharedPreferences("digit", MODE_PRIVATE);
        int first = shared5.getInt("1",0);
        int sec = shared5.getInt("2",0);
        int third = shared5.getInt("9",0);
        int four = shared5.getInt("10",0);
        String number = shared5.getString("number","");
        numberText.setText(number);
        firstEdit.setText(String.valueOf(first));
        secEdit.setText(String.valueOf(sec));
        thirdEdit.setText(String.valueOf(third));
        fourEdit.setText(String.valueOf(four));
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(OtpScreen.this, LoginScreen.class);
                startActivity(intent);
            }
        });
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(OtpScreen.this, LoginScreen.class);
                startActivity(intent);
            }
        });

    }
    @Override
    public void onBackPressed() {


    }
}
