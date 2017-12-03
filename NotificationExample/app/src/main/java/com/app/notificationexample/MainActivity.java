package com.app.notificationexample;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


       NotificationCompat.Builder builder = new NotificationCompat.Builder(this)

               .setContentText("Hello My Fovourite Course")
               .setContentTitle("IT For ever")
               .setAutoCancel(false)
               .setOngoing(true)
               .setSmallIcon(R.mipmap.ic_launcher)


               ;

       Notification notification = builder.build();
       NotificationManagerCompat notificationManagerCompat = NotificationManagerCompat.from(this);
       notificationManagerCompat.notify(0,notification);

    }
}
