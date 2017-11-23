package com.app.intentexample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn = findViewById(R.id.btn);




        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goToSecondActivity =
                        new Intent(MainActivity.this
                        ,SecondActivity.class);
                goToSecondActivity.putExtra(AppConstants.NAME_INTENT_KEY,"Alaa'");
                goToSecondActivity.putExtra(AppConstants.PRICE_INTENT_KEY,2000);
                //startActivity(goToSecondActivity);
                startActivityForResult(goToSecondActivity,200);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == 200 && resultCode == 300){
            String result = data.getStringExtra(AppConstants.RESULT_KEY);
            Toast.makeText(this,result, Toast.LENGTH_SHORT).show();
        }
    }
}
