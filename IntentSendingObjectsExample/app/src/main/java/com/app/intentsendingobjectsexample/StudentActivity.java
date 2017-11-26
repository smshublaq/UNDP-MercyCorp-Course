package com.app.intentsendingobjectsexample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class StudentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student);

        TextView tvStudent = findViewById(R.id.tvStudentData);

        Intent intent = getIntent();
        if(intent !=null){
            if (intent.hasExtra(AppConstants.INTENT_KEY_STUDENT)){
                /*
                Student student = (Student)intent.getSerializableExtra(AppConstants.INTENT_KEY_STUDENT);
                tvStudent.setText(student.getId() + "\n");
                tvStudent.append(student.getName() + "\n");
                tvStudent.append(student.getCollege() + "\n");
                tvStudent.append(student.getDepartment() + "\n");
                tvStudent.append(student.getDateOfBirth() + "\n");
                tvStudent.append(student.getGpa()+"");
                */

                /*StudentParcelable student = intent.getParcelableExtra(AppConstants.INTENT_KEY_STUDENT);
                tvStudent.append(p.getId() + "\n");
                tvStudent.append(p.getName() + "\n");
                tvStudent.append(p.getCollege() + "\n");
                tvStudent.append(p.getDepartment() + "\n");
                tvStudent.append(p.getDateOfBirth() + "\n");
                tvStudent.append(p.getGpa() + "");
                */
                ArrayList<StudentParcelable> student = intent.getParcelableArrayListExtra(AppConstants.INTENT_KEY_STUDENT);

                for (StudentParcelable p : student) {
                    tvStudent.append(p.getId() + "\n");
                    tvStudent.append(p.getName() + "\n");
                    tvStudent.append(p.getCollege() + "\n");
                    tvStudent.append(p.getDepartment() + "\n");
                    tvStudent.append(p.getDateOfBirth() + "\n");
                    tvStudent.append(p.getGpa() + "");
                }
            }
        }
    }
}
