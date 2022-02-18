package com.example.myapplication.thread_process;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.myapplication.R;

public class NotificationClass extends AppCompatActivity {

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

//      Step2 :-

        Intent startActivityLater = new Intent(this,Notification.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this,0,startActivityLater,0);
//      Step2.1

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this,CHANNEL_ID)
                .setContentTitle("Text Notification")
                .setContentText("this is test notification has no other purpose")
                .setSmallIcon(R.drawable.lab_icon)
                .setContentIntent(pendingIntent);
//       step3:-
        Notification notification = builder.build();

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            NotificationChannel notificationChannel = new NotificationChannel(CHANNEL_ID,CHANNEL_NAME,NotificationManager.IMPORTANCE_DEFAULT);
            notificationManager.createNotificationChannel(notificationChannel);
        }

//      step4 :-
        notificationManager.notify(1234,notification);




    }
}