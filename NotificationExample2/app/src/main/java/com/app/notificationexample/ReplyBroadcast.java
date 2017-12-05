package com.app.notificationexample;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.RemoteInput;
import android.widget.Toast;

/**
 * Created by iSaleem on 12/5/17.
 */

public class ReplyBroadcast extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, getMessageText(intent), Toast.LENGTH_SHORT).show();
    }

    private CharSequence getMessageText(Intent intent) {
        Bundle remoteInput = RemoteInput.getResultsFromIntent(intent);
        if (remoteInput != null) {
            return remoteInput.getCharSequence(MainActivity.KEY_TEXT_REPLY);
        }
        return null;
    }
}
