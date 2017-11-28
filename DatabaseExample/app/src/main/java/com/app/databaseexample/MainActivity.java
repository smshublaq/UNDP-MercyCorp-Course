package com.app.databaseexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DB db = new DB(this);
        db.open();
        long id = db.addStudent("hossam");
        Toast.makeText(this, id+"", Toast.LENGTH_SHORT).show();
        db.close();
    }
}
