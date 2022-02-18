package com.example.myapplication.lab_10.AlarmManager;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.media.MediaPlayer;
import android.widget.Toast;

import androidx.core.app.NotificationCompat;

import com.example.myapplication.R;

import static android.content.Context.NOTIFICATION_SERVICE;

public class AlaramManagerBroadcast extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {

        Toast.makeText(context,"run ho gaya",Toast.LENGTH_LONG).show();

        Notification notification = new NotificationCompat.Builder(context,"channel_id")
                .setSmallIcon(R.mipmap.notification_icon)
//                .setLargeIcon(BitmapFactory.decodeResource(Resources.getSystem(),R.mipmap.notification_icon))
                .setContentTitle("Time ho gaya")
                .setContentText("lala lalal")
                .build()
                ;
        MediaPlayer mediaPlayer = MediaPlayer.create(context,R.raw.number_eight);
        mediaPlayer.start();

        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                mediaPlayer.release();
            }
        });
        

        NotificationManager manager = (NotificationManager) context.getSystemService(NOTIFICATION_SERVICE);

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel("channel_id","channel_name",NotificationManager.IMPORTANCE_DEFAULT);
            manager.createNotificationChannel(channel)  ;
        }

        manager.notify(1,notification);


    }


}
