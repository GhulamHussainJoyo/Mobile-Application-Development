package com.example.myapplication.thread_process;

import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class NotificationReceiver extends BroadcastReceiver
{

    @Override
    public void onReceive(Context context, Intent intent) {
        int notificationId =  intent.getIntExtra("notificationId",0);
        NotificationManager notificationManager = (NotificationManager) context.getSystemService(context.NOTIFICATION_SERVICE);
        notificationManager.cancel(notificationId);
    }
}
