package com.app.broadcastreceiverexample;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.BatteryManager;
import android.widget.ProgressBar;

/**
 * Created by iSaleem on 12/5/17.
 */

public class MyBatteryLevelBroadcast extends BroadcastReceiver{

    @Override
    public void onReceive(Context context, Intent intent) {
        ProgressBar progressBar = ((Activity)context).findViewById(R.id.progress);
        progressBar.setProgress(intent.getIntExtra(BatteryManager.EXTRA_LEVEL,-1));
    }
}
