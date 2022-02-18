package com.example.myapplication.lab_10;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;

import java.util.Locale;

public class StopWatch extends AppCompatActivity {

    TextView timerTextView;
    Button startBtn, stopBtn, resetBtn;

    private int seconds = 0;
    private boolean running;
    private boolean wasRunning;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.stop_watch);

//        seconds = savedInstanceState.getInt("seconds");
//        running = savedInstanceState.getBoolean("running");
//        wasRunning = savedInstanceState.getBoolean("wasRunning");

        startBtn = findViewById(R.id.startBtn);
        stopBtn = findViewById(R.id.stopBtn);
        resetBtn = findViewById(R.id.resetBtn);
        timerTextView = findViewById(R.id.timerTextView);

        runTimer();

        startBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                running = true;
            }
        });

        stopBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                running = false;
            }
        });

        resetBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                running = false;
                seconds = 0;
            }
        });


    }

    private void runTimer() {
        final Handler handler = new Handler();


        handler.post(new Runnable() {
            @Override
            public void run() {

                int hours = seconds / 3600;
                int minutes = (seconds % 3600) / 60;
                int sec = seconds % 60;

                String time = String.format(Locale.getDefault(), "%d:%02d:%02d", hours, minutes, sec);
                timerTextView.setText(time);

                if (running) {
                    seconds++;
                }


                handler.postDelayed(this, 1000);
            }
        });


    }

    @Override
    public void onSaveInstanceState(Bundle onSaveInstanceState) {
        onSaveInstanceState.putInt("seconds", seconds);
        onSaveInstanceState.putBoolean("running", running);
        onSaveInstanceState.putBoolean("wasRunning", wasRunning);
        super.onSaveInstanceState(onSaveInstanceState);

    }

    @Override
    protected void onPause() {
        super.onPause();
        if (wasRunning) {
            running = true;
        }
    }


}