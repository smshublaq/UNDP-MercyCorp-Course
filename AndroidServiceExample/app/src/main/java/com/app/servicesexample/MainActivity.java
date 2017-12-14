package com.app.servicesexample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnStart = findViewById(R.id.btnStart);
        Button btnStop = findViewById(R.id.btnStop);
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*
                Intent intent = new Intent(MainActivity.this,MyService.class);
                intent.putExtra("name","alaa'");
                startService(intent);
                */
                Intent intent = new Intent(MainActivity.this,MyIntentService.class);
                intent.putExtra("name","alaa'");
                startService(intent);
            }
        });

        btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*
                Intent intent = new Intent(MainActivity.this,MyService.class);
                stopService(intent);
                */
                Intent intent = new Intent(MainActivity.this,MyIntentService.class);
                stopService(intent);
            }
        });
    }
}
