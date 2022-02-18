package com.example.myapplication.broadCast;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;

import com.example.myapplication.R;

public class _BroadcastReceiver extends AppCompatActivity {

    Intent myReceiverIntent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.broadcast_receiver);

        myReceiverIntent = new Intent(this,myReceiver.class);



        IntentFilter intentFilter =  new IntentFilter();
        intentFilter.addAction("com.alarmManager");
        registerReceiver(new myReceiver(),intentFilter);
        

    }



}