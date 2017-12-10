package com.app.boundservices;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    MyService myService;
    boolean isBound = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn = findViewById(R.id.button);
        final TextView tvSum = findViewById(R.id.tvSum);
        Intent intent = new Intent(this,MyService.class);
        bindService(intent,mServiceConnection,BIND_AUTO_CREATE);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isBound){
                    tvSum.setText(myService.getCurrentTime());
                }
            }
        });
    }

    ServiceConnection mServiceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            myService = ((MyService.MyBinder)iBinder).getService();
            isBound = true;
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {
            isBound = false;
        }
    };

    @Override
    protected void onStop() {
        super.onStop();
        unbindService(mServiceConnection);
    }
}
