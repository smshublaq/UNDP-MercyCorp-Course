package com.app.servicesexample;

import android.app.IntentService;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by iSaleem on 12/9/17.
 */

public class MyIntentService extends IntentService {


    public MyIntentService() {
        super("myService");
    }



    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        String name = intent.getStringExtra("name");
        Log.d("NAME",name);

    }
}
