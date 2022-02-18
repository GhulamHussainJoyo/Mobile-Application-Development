package com.example.myapplication.lab_10;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.media.Image;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.ImageView;

import com.example.myapplication.R;

import java.util.Locale;

public class ToggleRotate extends AppCompatActivity {

    ImageView toggleImageView;
    Button toggleButton;
    Animation rotateAnimation;

    private int seconds = 0;
    private boolean running;
    private boolean wasRunning;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.toggle_rotate);

        toggleImageView = findViewById(R.id.toggleImageView);
        toggleButton = findViewById(R.id.toggleButton);
        rotateAnimation = AnimationUtils.loadAnimation(this,R.anim.rotate);

        runTimer();
        toggleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if (running)
                {
                    running =false;
                }
                else
                {
                    running =true;
                }

//
            }
        });
    }

    private void runTimer() {
        final Handler handler = new Handler();


        handler.post(new Runnable() {
            @Override
            public void run() {


                if (running) {
                    toggleImageView.animate().rotationBy(30f).setInterpolator(new LinearInterpolator()).start();
//                    toggleImageView.setAnimation(rotateAnimation);
                }


                handler.postDelayed(this, 1000);
            }
        });


    }
}