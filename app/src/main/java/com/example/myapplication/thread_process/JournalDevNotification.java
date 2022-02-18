package com.example.myapplication.thread_process;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.content.ContextCompat;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.Toast;

import com.example.myapplication.R;

import java.net.URI;

public class JournalDevNotification extends AppCompatActivity {

    private final static String CHANNEL_ID = "android channel";
    private final static String CHANNEL_NAME = "android notification";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.journal_dev_otification);

//      IntentFilter intentFilter = new IntentFilter();
//      NotificationReceiver notificationReceiver = new NotificationReceiver();
//      registerReceiver(notificationReceiver,intentFilter);


    }


    public void notificationAction(View view) {

        int NOTIFICATION_ID = 1;
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, CHANNEL_ID);


        builder.setSmallIcon(R.mipmap.notification_icon);
        builder.setContentTitle("Notification OK-MINI");
        builder.setContentText("Tap View to View Okmini Plan");
        builder.setAutoCancel(true);

        PendingIntent launchIntent = getLaunchIntent(NOTIFICATION_ID, getBaseContext());
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://ghulamhussainjoyo.github.io/okmini/"));
        PendingIntent pIntent = PendingIntent.getActivity(this, 0, intent, 0);

        Intent buttonIntent = new Intent(getBaseContext(), NotificationReceiver.class);
        buttonIntent.putExtra("notificationId", NOTIFICATION_ID);
        PendingIntent dismissIntent = PendingIntent.getBroadcast(getBaseContext(), 0, buttonIntent, 0);

        builder.setContentIntent(launchIntent);
        builder.addAction(android.R.drawable.ic_menu_view, "View", pIntent);
        builder.addAction(android.R.drawable.ic_menu_delete, "delete", dismissIntent);

        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        notificationManager.notify(NOTIFICATION_ID, builder.build());

    }


    public void headsUpNotification(View view) {
        int NOTIFICATION_ID = 1;

        NotificationChannel channel = null;

        long vibrationPattern[] = {100, 200, 300, 400, 300, 200, 400, 300};
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            channel = new NotificationChannel(CHANNEL_ID, CHANNEL_NAME, NotificationManager.IMPORTANCE_HIGH);
            channel.setDescription("description");
            channel.setShowBadge(true);
            channel.canShowBadge();
            channel.setShowBadge(true);
            channel.setLockscreenVisibility(Notification.VISIBILITY_PUBLIC);
            channel.setVibrationPattern(vibrationPattern);

            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, CHANNEL_ID)
                .setSmallIcon(R.drawable.notification_icon)
                .setContentTitle("Heads Up Notification")
                .setContentText("View the latest swift tutorial")
                .setAutoCancel(true)
                .setDefaults(NotificationCompat.DEFAULT_ALL)
                .setPriority(NotificationCompat.PRIORITY_HIGH);

        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://ghulamhussainjoyo.github.io/okmini/"));
        PendingIntent pIntent = PendingIntent.getActivity(this, 0, intent, 0);

        Intent buttonIntent = new Intent(getBaseContext(), NotificationReceiver.class);
        buttonIntent.putExtra("notificationId", NOTIFICATION_ID);
        PendingIntent dismissIntent = PendingIntent.getActivity(getBaseContext(), 0, buttonIntent, 0);

        builder.addAction(android.R.drawable.ic_menu_view, "VIEW", pIntent);
        builder.addAction(android.R.drawable.ic_menu_view, "DISMISS", dismissIntent);

        Notification buildNotification = builder.build();
        NotificationManager mNotifyMngr = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        mNotifyMngr.notify(NOTIFICATION_ID, buildNotification);
//        startActivity(new Intent(Settings.ACTION_MANAGE_APPLICATIONS_SETTINGS));

    }

    public void bigTextStyle(View view) {
        int NOTIFICATION_ID = 1;
        PendingIntent launchIntent = getLaunchIntent(NOTIFICATION_ID, getBaseContext());
        Intent dissmissIntent = new Intent(this, NotificationReceiver.class);
        dissmissIntent.putExtra("notificationId", NOTIFICATION_ID);
        PendingIntent dismissPendingIntent = PendingIntent.getActivity(this, 0, dissmissIntent, 0);


        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, CHANNEL_ID)
                .setSmallIcon(R.drawable.notification_icon)
                .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.drawable.notification_icon))
                .setContentTitle("Notification Big title")
                .setStyle(new NotificationCompat.BigTextStyle().bigText(getResources().getString(R.string.lorem_ispum)))
                .setAutoCancel(true)
                .setContentIntent(launchIntent)
                .addAction(android.R.drawable.ic_delete, "DISMISS", dismissPendingIntent)
                .addAction(android.R.drawable.ic_menu_send, "VIEW", launchIntent);

        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        Notification notification = builder.build();
        notificationManager.notify(NOTIFICATION_ID, builder.build());


    }

    public void bigPictureStyle(View view) {
        int NOTIFICATION_ID = 1;
        Bitmap bg = BitmapFactory.decodeResource(getResources(), R.drawable.my_pic);
        Intent dismissIntent = new Intent(this, NotificationReceiver.class);
        PendingIntent dismissPendingIntent = PendingIntent.getActivity(this,0,dismissIntent,0);
        PendingIntent launchIntent = getLaunchIntent(NOTIFICATION_ID,getBaseContext());

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this,CHANNEL_ID)
                .setSmallIcon(R.drawable.notification_icon)
                .setLargeIcon(BitmapFactory.decodeResource(getResources(),R.drawable.notification_icon))
                .setContentTitle("Big Picture Style")
                .setStyle(new NotificationCompat.BigPictureStyle().bigPicture(bg))
                .setAutoCancel(true)
                .setContentIntent(launchIntent)
                .addAction(android.R.drawable.ic_delete,"DISMISS",dismissPendingIntent)
                ;

        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        notificationManager.notify(NOTIFICATION_ID,builder.build());
    }

    public void inboxStyle(View view)
    {
        int NOTIFICATION_ID = 1;
        PendingIntent launchIntent = getLaunchIntent(NOTIFICATION_ID,this);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this,CHANNEL_ID)
                .setSmallIcon(R.drawable.notification_icon)
                .setLargeIcon(BitmapFactory.decodeResource(getResources(),R.drawable.notification_icon))
                .setStyle(new NotificationCompat.InboxStyle()
                        .addLine("Hello")
                        .addLine("Are you there?")
                        .addLine("How's your day?")
                        .setBigContentTitle("3 New mesages for you")
                        .setSummaryText("Text")
                        )
                .setAutoCancel(true)
                .setContentIntent(launchIntent)
                ;

        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        notificationManager.notify(NOTIFICATION_ID,builder.build());
    }

    public void messageStyle(View view)
    {
        int NOTIFICATION_ID = 1;
        PendingIntent launchIntent = getLaunchIntent(NOTIFICATION_ID,this);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this,CHANNEL_ID)
                .setSmallIcon(R.drawable.notification_icon)
                .setLargeIcon(BitmapFactory.decodeResource(getResources(),R.drawable.notification_icon))
                .setContentIntent(launchIntent)
                .setContentTitle("Messages")
                .setStyle(new NotificationCompat.MessagingStyle("Joyo")
                        .setConversationTitle("Q&A Group")
                        .addMessage("This type of message introduces in Android N. Right?",0,"Student 1")
                        .addMessage("yes",0,"")
                        .addMessage("This constructor is passed with the name of current user. Right?",0,"Student 2")
                        .addMessage("True",0,"")
                )
                .setAutoCancel(true)
                .setContentIntent(launchIntent)
                ;

        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        notificationManager.notify(NOTIFICATION_ID,builder.build());


    }




    public PendingIntent getLaunchIntent(int notificationId, Context context) {
        Intent intent = new Intent(this, JournalDevNotification.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        intent.putExtra("notificationId", notificationId);
        return PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_CANCEL_CURRENT);
    }

    public void clearNotification() {
        int notificationId = getIntent().getIntExtra("notificationId", 0);
        NotificationManager notiManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        notiManager.cancel(notificationId);
    }
}