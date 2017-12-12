package com.app.pushnotificationexample;

import android.app.Application;

import com.google.firebase.FirebaseApp;

/**
 * Created by iSaleem on 12/12/17.
 */

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        FirebaseApp.initializeApp(this);
    }
}
