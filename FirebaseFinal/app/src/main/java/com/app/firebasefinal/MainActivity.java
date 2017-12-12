package com.app.firebasefinal;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    private DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
        reference = firebaseDatabase.getReference("info");
        reference.setValue("hello android");

        /*
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String name= dataSnapshot.getValue(String.class);
                Toast.makeText(MainActivity.this, name, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        */

        addUser("12q321132","423432","523532");
        /*
        HashMap<String,User> map = new HashMap<>();
        User user = new User();
        user.setEmail("aa");
        user.setUsername("aa@aa.com");
        map.put("1",user);
        reference.child("1");
        */

    }

    public void addUser(String userId,String username,String email){
        User user = new User();
        user.setEmail(email);
        user.setUsername(username);

        reference.child("users").child(userId).push().setValue(user);
    }
}
