package com.example.myapplication.lab_10.AlarmManager;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TimePicker;
import android.widget.Toast;

import com.example.myapplication.R;

import java.util.Calendar;

public class AlarmManagerLocal extends AppCompatActivity {

    TimePicker timePicker;
    Button setAlaram;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm_manager);

        IntentFilter filter = new IntentFilter();

        AlaramManagerBroadcast alarmManager = new AlaramManagerBroadcast();
        registerReceiver(alarmManager, filter);

        timePicker = findViewById(R.id.timePicker);
        setAlaram = findViewById(R.id.setAlarm_Btn);


        setAlaram.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Calendar calendar = Calendar.getInstance();
                calendar.setTimeInMillis(System.currentTimeMillis());
                calendar.add(Calendar.SECOND,30);

                Toast.makeText(getApplicationContext(),calendar.getTime().toString(),Toast.LENGTH_LONG).show();
                setAlarm(calendar.getTimeInMillis());


            }
        });
        
    }

   public void setAlarm(long timemillis)
    {
        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
        Intent intentBroadCast = new Intent(getApplicationContext(),AlaramManagerBroadcast.class);
        PendingIntent pendingIntentBroadCast = PendingIntent.getBroadcast(this,0,intentBroadCast,0);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            alarmManager.setExact(AlarmManager.RTC_WAKEUP,timemillis,pendingIntentBroadCast);
            System.out.println("time in millis => "+timemillis);
        }
        else
        {
            Toast.makeText(getApplicationContext(),"else of version",Toast.LENGTH_LONG).show();
        }
    }
}