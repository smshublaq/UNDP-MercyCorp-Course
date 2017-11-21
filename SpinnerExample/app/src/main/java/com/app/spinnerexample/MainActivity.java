package com.app.spinnerexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Spinner spinner = findViewById(R.id.mySpinner);
        //ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1);
        /*
        ArrayAdapter<String> adapter =
                new ArrayAdapter<String>
                        (this,R.layout.spinner_item
                                ,R.id.tvItem);
        */
        String[] items = {"A","b","c"};
        List<String> list = new ArrayList();
        list.add("a");
                list.add("b");
                /*
        ArrayAdapter<String> adapter =
                new ArrayAdapter<String>
                        (this,android.R.layout.simple_list_item_1,list);
        */


                /*
        ArrayAdapter<Student> adapter =
                new ArrayAdapter
                        (this,android.R.layout.simple_list_item_1);

        adapter.add(new Student("ahmed","1234"));
        adapter.add(new Student("hosam","432"));
        adapter.add(new Student("hussien","243"));
        spinner.setAdapter(adapter);


        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long viewId) {
                Student s = (Student)adapterView.getItemAtPosition(position);

                Toast.makeText(MainActivity.this, s.getId() + " " + s.getName(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        */

    }
}
