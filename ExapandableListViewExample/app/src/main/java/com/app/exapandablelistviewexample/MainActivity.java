package com.app.exapandablelistviewexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.SimpleExpandableListAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final ExpandableListView expandableListView = findViewById(R.id.expListView);

        /*
        List<HashMap<String,String>> groups = new ArrayList<>();
        HashMap<String,String> group1 = new HashMap<>();
        group1.put("A","A");
        group1.put("B","B");
        groups.add(group1);


        SimpleExpandableListAdapter adapter =
                new SimpleExpandableListAdapter(this,groups,android.R.layout.simple_list_item_1,)
                */


        List<Student> students = new ArrayList<>();

        List<String> studentsChild1 = new ArrayList<>();
        studentsChild1.add("JAVA");
        studentsChild1.add("DS");

        Student s1 = new Student("Ahmed",studentsChild1);
        students.add(s1);


        List<String> studentsChild2 = new ArrayList<>();
        studentsChild2.add("WS");
        studentsChild2.add("Sw End");

        Student s2 = new Student("Hossam",studentsChild2);
        students.add(s2);


        MyExpandableListViewAdapter myExpandableListViewAdapter = new MyExpandableListViewAdapter(this,students);
        expandableListView.setAdapter(myExpandableListViewAdapter);

        expandableListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
            @Override
            public void onGroupExpand(int groupPosition) {
                //Student student = (Student)expandableListView.getAdapter().getItem(groupPosition);
            }
        });




    }
}
