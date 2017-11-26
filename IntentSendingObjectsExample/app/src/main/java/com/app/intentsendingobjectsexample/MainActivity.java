package com.app.intentsendingobjectsexample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn = findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*
                Student student = new Student();
                student.setName("ahmed");
                student.setCollege("IT");
                student.setDateOfBirth("02-10-1999");
                student.setDepartment("Software Development");
                student.setGpa(90.0f);
                student.setId("12331312");


                Intent intent = new Intent(MainActivity.this,StudentActivity.class);
                intent.putExtra(AppConstants.INTENT_KEY_STUDENT,student);
                startActivity(intent);
                */
                ArrayList<StudentParcelable> studentList = new ArrayList();
                StudentParcelable student = new StudentParcelable();
                student.setName("ahmed");
                student.setCollege("IT");
                student.setDateOfBirth("02-10-1999");
                student.setDepartment("Software Development");
                student.setGpa(90.0f);
                student.setId("12331312");
                studentList.add(student);

                Intent intent = new Intent(MainActivity.this
                        ,StudentActivity.class);
                //intent.putExtra(AppConstants.INTENT_KEY_STUDENT,student);
                intent.putParcelableArrayListExtra(AppConstants.INTENT_KEY_STUDENT,studentList);

                startActivity(intent);
            }
        });

    }
}
