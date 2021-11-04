package com.example.myapplication.lab_5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myapplication.R;

public class Cookies extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cookies);

        ImageView hungryMood = findViewById(R.id.hungryMood);
        TextView hungryText = findViewById(R.id.hungryText);
        Button eatMe = findViewById(R.id.eatMe);

        eatMe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hungryMood.setImageResource(R.drawable.full);
                hungryText.setText("I'm so full");
                eatMe.setText("Done");

            }
        });




    }
}