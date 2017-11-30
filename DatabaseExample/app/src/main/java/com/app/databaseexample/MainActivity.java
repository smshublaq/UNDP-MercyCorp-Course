package com.app.databaseexample;

import android.database.Cursor;
import android.os.Environment;
import android.support.v4.widget.SimpleCursorAdapter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView lst = findViewById(R.id.lst);
        final EditText editText = findViewById(R.id.etName);
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


        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                DB db = new DB(MainActivity.this);
                db.open();
                Cursor c = db.getStudents();
                c.moveToPosition(position);
                String name = c.getString(c.getColumnIndex(MySqliteDatabaseHelper.STUDENT_NAME_COLUMN));
                int id = c.getInt(c.getColumnIndex(MySqliteDatabaseHelper.STUDENT_ID_COLUMN));
                editText.setText(name + " : " + id);
                db.close();
            }
        });

        String directory = Environment.getExternalStorageDirectory().getPath();
        Toast.makeText(this, directory, Toast.LENGTH_SHORT).show();

    }


}
