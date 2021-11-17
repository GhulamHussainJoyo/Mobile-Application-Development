package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.lab_4.act2;
import com.example.myapplication.lab_5.Cookies;
import com.example.myapplication.lab_6.Login;
import com.example.myapplication.lab_7.mp3Player;

import static com.example.myapplication.R.layout.activity_splash_screen;

public class SplashScreen extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(activity_splash_screen);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(getApplicationContext(), mp3Player.class));
            }
        },3000);
    }
}