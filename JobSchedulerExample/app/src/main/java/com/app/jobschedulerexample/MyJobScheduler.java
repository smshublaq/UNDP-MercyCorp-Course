package com.app.jobschedulerexample;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.util.Log;
import android.widget.Toast;

import com.firebase.jobdispatcher.JobParameters;
import com.firebase.jobdispatcher.JobService;

/**
 * Created by iSaleem on 12/14/17.
 */

public class MyJobScheduler extends JobService {
    @Override
    public boolean onStartJob(JobParameters jobParameters) {
        Log.d("tag","onStartJob");
        Bundle bundle = jobParameters.getExtras();
        Toast.makeText(this, bundle.getString("name"), Toast.LENGTH_SHORT).show();

        return true;
    }

    @Override
    public boolean onStopJob(JobParameters jobParameters) {
        return true;
    }
}
