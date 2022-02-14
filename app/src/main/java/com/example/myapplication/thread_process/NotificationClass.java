package com.example.myapplication.thread_process;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Bundle;
import android.view.View;

import com.example.myapplication.R;

public class Notification extends AppCompatActivity {

    private  static final String CHANNEL_ID = "android channel";
    private  static final String CHANNEL_NAME = "android channel";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.notification_activity);
    }

    public void notifyMe(View view)
    {
//      Step1 :-
        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

//      Step 2
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this,CHANNEL_ID)
                .setContentTitle("Text Notification")
                .setContentText("this is test notification has no other purpose")
                .setSmallIcon(R.drawable.lab_icon);
//       step 3
        Notification notification = builder.build();

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            NotificationChannel notificationChannel = new NotificationChannel(CHANNEL_ID,CHANNEL_NAME,NotificationManager.IMPORTANCE_DEFAULT);
            notificationManager.createNotificationChannel(notificationChannel);
        }

        notificationManager.notify(1234,notification);




    }
}