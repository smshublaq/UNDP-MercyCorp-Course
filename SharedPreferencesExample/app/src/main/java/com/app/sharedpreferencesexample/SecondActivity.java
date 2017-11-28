package com.app.sharedpreferencesexample;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ActionMode;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        /*
        SharedPreferences sharedPreferences = getPreferences(MODE_PRIVATE);
        String name = sharedPreferences.getString("name","");
        Toast.makeText(this, name, Toast.LENGTH_SHORT).show();
        */

        /*
        // app level but with separated file
        SharedPreferences sharedPreferences = getSharedPreferences(AppConstants.MY_INFO_SHARED_PREF,MODE_PRIVATE);
        String name = sharedPreferences.getString("name","");
        Toast.makeText(this, name, Toast.LENGTH_SHORT).show();
        */

        // app level but with one shared file
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        String name = sharedPreferences.getString("name","");
        Toast.makeText(this, name, Toast.LENGTH_SHORT).show();
    }
}
