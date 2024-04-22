package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new CountDownTimer(3000, 1000) {

            public void onTick(long millisUntilFinished) {

                // logic to set the EditText could go here
            }

            public void onFinish() {
                Intent intent = new Intent(MainActivity.this, WelcomeScreen.class);
                startActivity(intent);
            }

        }.start();

    }
}