package com.app.broadcastreceiverexample;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.BatteryManager;
import android.widget.Toast;

/**
 * Created by iSaleem on 12/5/17.
 */

public class MyBroadcastReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        switch (intent.getAction()){
            case Intent.ACTION_BATTERY_LOW:
                Toast.makeText(context, "Battery Low", Toast.LENGTH_SHORT).show();
                break;

            case Intent.ACTION_POWER_CONNECTED:
                Toast.makeText(context, "Power Connected", Toast.LENGTH_SHORT).show();
                break;

        }
    }

}
