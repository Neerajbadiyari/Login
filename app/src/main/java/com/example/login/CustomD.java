package com.example.login;

import static android.content.Context.MODE_PRIVATE;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class CustomD extends Dialog {

    EditText firstEdit,secEdit,thirdEdit,fourEdit;
    public Context c;
    Button ok;
    public CustomD(Context a) {
        super(a);
        // TODO Auto-generated constructor stub
        this.c = a;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.dialog_box);

        ok = findViewById(R.id.ok);
        firstEdit = findViewById(R.id.ed1);
        secEdit = findViewById(R.id.ed2);
        thirdEdit = findViewById(R.id.ed3);
        fourEdit = findViewById(R.id.ed4);
        SharedPreferences shared5 = c.getSharedPreferences("digit", MODE_PRIVATE);
        int first = shared5.getInt("1",0);
        int sec = shared5.getInt("2",0);
        int third = shared5.getInt("9",0);
        int four = shared5.getInt("10",0);
        firstEdit.setText(String.valueOf(first));
        secEdit.setText(String.valueOf(sec));
        thirdEdit.setText(String.valueOf(third));
        fourEdit.setText(String.valueOf(four));

        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(c, OtpScreen.class);
                c.startActivity(intent);
            }
        });
    }
}