package com.app.firebaseexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference("message");
        databaseReference.setValue("ahmed");


        firebaseDatabase.getReference("calls").setValue("ibrahim");

        // Read from the database


        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String value = dataSnapshot.getValue(String.class);
                Toast.makeText(MainActivity.this, value, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
            }
        });


        writeNewUser("120140934","hamada","hamada@yahoo.com");

        Map<String,User> map = new HashMap<>();
        User user = new User();
        user.setEmail("aa@aa.com");
        user.setUsername("ahmed");
        map.put("213312",user);
        databaseReference.child("users").push().setValue(map);

    }

    private void writeNewUser(String userId, String name, String email) {
        User user = new User();
        user.setEmail(email);
        user.setUsername(name);
        databaseReference.child("users").child(userId).push().setValue(user);
    }
}
