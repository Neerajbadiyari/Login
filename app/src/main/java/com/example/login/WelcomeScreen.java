package com.example.login;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.facebook.login.Login;

public class WelcomeScreen extends AppCompatActivity {
Button start;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome);

        start = findViewById(R.id.start);

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(WelcomeScreen.this, LoginScreen.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onBackPressed() {


    }
}
