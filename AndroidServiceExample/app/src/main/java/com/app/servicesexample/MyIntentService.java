package com.app.servicesexample;

import android.app.IntentService;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by iSaleem on 12/14/17.
 */

public class MyIntentService extends IntentService {


    public MyIntentService() {
        super("myService");
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        while(true){
            Log.d("i","1");
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("destroy","onDestroy");
    }
}
