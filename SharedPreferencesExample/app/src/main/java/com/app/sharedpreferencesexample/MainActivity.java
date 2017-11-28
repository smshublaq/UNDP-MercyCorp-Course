package com.app.sharedpreferencesexample;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn = findViewById(R.id.btn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,SecondActivity.class);
                startActivity(intent);
            }
        });
        /*
        // getPreferences() is just for activity level
        SharedPreferences sharedPreferences = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("name","ahmed");
        //boolean isDone = editor.commit();
        //editor.apply();
        editor.commit();
        */

        /*
        // shared pref app level
        SharedPreferences sharedPreferences = getSharedPreferences(AppConstants.MY_INFO_SHARED_PREF,MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("name","ahmed");
        //boolean isDone = editor.commit();
        //editor.apply();
        editor.commit();
        */


        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("name","ahmed");
        
        //boolean isDone = editor.commit();
        //editor.apply();
        editor.commit();

    }
}
