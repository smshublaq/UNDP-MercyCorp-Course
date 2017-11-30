package com.app.databaseexample;

import android.database.Cursor;
import android.support.v4.widget.SimpleCursorAdapter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView lst = findViewById(R.id.lst);

        DB db = new DB(this);
        db.open();

        //long id = db.addStudent("ahmed");
        //Toast.makeText(this, id+"", Toast.LENGTH_SHORT).show();
        Cursor c = db.getStudents();

        //c.getCount()
        //c.moveToLast();
        //c.moveToPosition()
        //c.moveToPrevious()
        // c.moveToNext()

        /*
        if(c.moveToFirst()){
            int columnIndex = c.getColumnIndex
                    (MySqliteDatabaseHelper.STUDENT_NAME_COLUMN);

            String name = c.getString(columnIndex);
            Toast.makeText(this, name+"", Toast.LENGTH_SHORT).show();

        }
        */
        /*
        while(c.moveToNext()){
            int columnIndex = c.getColumnIndex
                    (MySqliteDatabaseHelper.STUDENT_NAME_COLUMN);

            String name = c.getString(columnIndex);
            Toast.makeText(this, name+"", Toast.LENGTH_SHORT).show();
        }
        */
        String[] columns = {MySqliteDatabaseHelper.STUDENT_ID_COLUMN
                , MySqliteDatabaseHelper.STUDENT_NAME_COLUMN};
        int[] ids = {R.id.tvId, R.id.tvName};
        SimpleCursorAdapter simpleCursorAdapter =
                new SimpleCursorAdapter
                        (this, R.layout.list_item,
                                c, columns,
                                ids,
                                SimpleCursorAdapter.FLAG_REGISTER_CONTENT_OBSERVER);
        //Toast.makeText(this, id+"", Toast.LENGTH_SHORT).show();
        lst.setAdapter(simpleCursorAdapter);

        //simpleCursorAdapter.swapCursor();
        db.close();

    }
}
