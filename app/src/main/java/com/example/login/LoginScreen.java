package com.example.login;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.facebook.FacebookSdk;
import com.hbb20.CountryCodePicker;


public class LoginScreen extends AppCompatActivity {
    ImageView back;
    EditText value;
    Button otp;
    String phoneNumber = "";
    CountryCodePicker ccp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //FacebookSdk.sdkInitialize(getApplicationContext());
        setContentView(R.layout.login);
        back = findViewById(R.id.back);
        otp = findViewById(R.id.otp);
        value = findViewById(R.id.edit_text);
        ccp = findViewById(R.id.ccp);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginScreen.this, WelcomeScreen.class);
                startActivity(intent);
            }
        });
        otp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (validation()){

                    int first = Integer.valueOf(phoneNumber.substring(0,1));
                    int second = Integer.valueOf(phoneNumber.substring(1,2));
                    int third = Integer.valueOf(phoneNumber.substring(8,9));
                    int four = Integer.valueOf(phoneNumber.substring(9,10));
                    SharedPreferences sharedPreferences;
                    sharedPreferences = getSharedPreferences("digit", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putInt("1",first);
                    editor.apply();
                    editor.putInt("2",second);
                    editor.apply();
                    editor.putInt("9",third);
                    editor.apply();
                    editor.putInt("10",four);
                    editor.apply();
                    editor.putString("numb",ccp.getSelectedCountryCodeWithPlus() + phoneNumber);
                    editor.apply();



                    CustomD cdd = new CustomD(LoginScreen.this);
                    cdd.show();
                    cdd.setCancelable(false);
                    Window window = cdd.getWindow();
                    window.setLayout(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);

                }
            }
        });


    }
    private boolean validation() {
        String number = value.getText().toString().trim();
        if (number.isEmpty()) {
            value.setError("please enter 10 digit mobile number.");
            value.requestFocus();
            return false;
        } else if (number.length() == 10) {
            phoneNumber = number;
        } else if (number.length() < 10) {
            value.setError("please enter 10 digit mobile number.");
            value.requestFocus();
            return false;
        }
        return true;
    }

    @Override
    public void onBackPressed() {


    }
}
