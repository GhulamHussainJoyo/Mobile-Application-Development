package com.example.myapplication.lab_10;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.myapplication.R;

public class ForegroundService_vity extends AppCompatActivity {

    Button start_Btn, stop_Btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.foreground_service_vity);
        start_Btn = findViewById(R.id.start_Btn);
        stop_Btn = findViewById(R.id.stop_Btn);


        start_Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                startService();
            }
        });

        stop_Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                stopService();
                Toast.makeText(getApplicationContext(),"Foreground service stopped",Toast.LENGTH_LONG).show();
            }
        });

    }

    public void startService() {
        Intent serviceIntent = new Intent(this, ForegroundService.class);
        serviceIntent.putExtra("inputExtra", "Foreground Service in android");
        ContextCompat.startForegroundService(this, serviceIntent);
    }

    public void stopService() {
        Intent intent = new Intent(this, ForegroundService.class);
        stopService(intent);
    }
}