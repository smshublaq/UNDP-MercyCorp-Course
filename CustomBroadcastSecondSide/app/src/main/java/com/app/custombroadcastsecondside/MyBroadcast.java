package com.app.custombroadcastsecondside;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by iSaleem on 12/5/17.
 */

public class MyBroadcast extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        String name = intent.getStringExtra("name");
        Toast.makeText(context, name, Toast.LENGTH_SHORT).show();
    }
}
