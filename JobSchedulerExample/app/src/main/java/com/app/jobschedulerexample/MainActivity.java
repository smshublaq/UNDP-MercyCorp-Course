package com.app.jobschedulerexample;

import android.app.job.JobInfo;
import android.content.ComponentName;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.firebase.jobdispatcher.Constraint;
import com.firebase.jobdispatcher.FirebaseJobDispatcher;
import com.firebase.jobdispatcher.GooglePlayDriver;
import com.firebase.jobdispatcher.Job;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn = findViewById(R.id.btnStart);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                /*
                ComponentName componentName =
                        new ComponentName
                                (MainActivity.this
                                        ,MyJobScheduler.class);
                JobInfo.Builder info = null;
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
                    Log.d("JOB","1123");
                    info = new JobInfo.Builder(1,componentName);
                    JobInfo jobInfo;
                    jobInfo = info

                            .setMinimumLatency(1000)
                            //setRequiresDeviceIdle(true)

                            //.setRequiredNetworkType(JobInfo.NETWORK_TYPE_ANY)
                            .setRequiresCharging(true)
                            //.setRequiresBatteryNotLow(true)
                            //.setRequiresStorageNotLow(true)
                            .build();

                    JobScheduler jobScheduler = (JobScheduler) getSystemService(JOB_SCHEDULER_SERVICE);
                    jobScheduler.schedule(jobInfo);

                }

                */

                Bundle bundle = new Bundle();
                bundle.putString("name","anas");
                FirebaseJobDispatcher dispatcher = new FirebaseJobDispatcher
                        (new GooglePlayDriver(MainActivity.this));
                Job myJob = dispatcher.newJobBuilder()
                        .setService(MyJobScheduler.class)
                        .setTag("my-job-tag")
                        .setExtras(bundle)
                        .setConstraints(Constraint.DEVICE_CHARGING,Constraint.ON_ANY_NETWORK)
                        .build();
                dispatcher.schedule(myJob);

            }
        });

    }
}
