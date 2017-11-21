package com.app.listviewexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView lst = findViewById(R.id.list);

        LayoutInflater inflater = LayoutInflater.from(this);
        View header = inflater.inflate(R.layout.header_layout,null);
        ImageButton btnHeader = header.findViewById(R.id.btn);
        btnHeader.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Header Button",
                        Toast.LENGTH_SHORT).show();
            }
        });
        lst.addHeaderView(header);

        /*
        ArrayAdapter<String> adapter = new ArrayAdapter
                (this,android.R.layout.simple_list_item_1);
        adapter.add("ahmed");
        adapter.add("mohammad");
        adapter.add("hosam");

        lst.setAdapter(adapter);

        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                String name = (String)adapterView.getItemAtPosition(position);
                Toast.makeText(MainActivity.this,
                        name, Toast.LENGTH_SHORT).show();
            }
        });
        */

        List<Employee> items = new ArrayList();
        items.add(new Employee("Ahmed","Manager",R.mipmap.ic_launcher_round));
        items.add(new Employee("Hosam","Clerk",R.mipmap.ic_launcher));
        items.add(new Employee("Hamza","Secretary",R.mipmap.ic_launcher_round));

        MyAdapter adapter = new MyAdapter(this,items);
        lst.setAdapter(adapter);

        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Employee employee = (Employee)adapterView.getItemAtPosition(position);
                Toast.makeText(MainActivity.this, employee.getTitle() + " " + employee.getSubTitle(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
