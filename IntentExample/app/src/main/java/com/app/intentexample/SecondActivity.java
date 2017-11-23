package com.app.intentexample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Button btn = findViewById(R.id.button);

        Intent intent = getIntent();
        if(intent !=null){
            if(intent.hasExtra(AppConstants.NAME_INTENT_KEY)
                    && intent.hasExtra(AppConstants.PRICE_INTENT_KEY)){

                String name = intent.getStringExtra(AppConstants.NAME_INTENT_KEY);

                int price = intent.getIntExtra(AppConstants.PRICE_INTENT_KEY
                        ,-1);

                Toast.makeText(this, name + " " + price, Toast.LENGTH_SHORT).show();
            }
        }

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent returnToMain = new Intent();
                returnToMain.putExtra(AppConstants.RESULT_KEY,"Mac Received");
                setResult(300,returnToMain);
                finish();
            }
        });
    }
}
