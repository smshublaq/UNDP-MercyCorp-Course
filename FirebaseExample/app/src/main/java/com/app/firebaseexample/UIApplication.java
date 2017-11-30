package com.app.firebaseexample;

import android.app.Application;

import com.google.firebase.FirebaseApp;

/**
 * Created by iSaleem on 11/26/17.
 */

public class UIApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        FirebaseApp.initializeApp(this);

    }
}
