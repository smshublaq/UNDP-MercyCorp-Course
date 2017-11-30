package com.app.databaseexample;

import android.database.Cursor;
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
        //long id = db.addStudent("ahmed");
        //Toast.makeText(this, id+"", Toast.LENGTH_SHORT).show();
        Cursor c = db.getStudents();
        /*
        if(c.moveToFirst()){
            int columnIndex = c.getColumnIndex
                    (MySqliteDatabaseHelper.STUDENT_NAME_COLUMN);

            String name = c.getString(columnIndex);
            Toast.makeText(this, name+"", Toast.LENGTH_SHORT).show();

        }
        */
        while(c.moveToNext()){
            int columnIndex = c.getColumnIndex
                    (MySqliteDatabaseHelper.STUDENT_NAME_COLUMN);

            String name = c.getString(columnIndex);
            Toast.makeText(this, name+"", Toast.LENGTH_SHORT).show();
        }
        //Toast.makeText(this, id+"", Toast.LENGTH_SHORT).show();
        db.close();
    }
}
