package com.app.firebaseexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

public class StorageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_storage);
        FirebaseStorage storage =
                FirebaseStorage.getInstance("gs://elss-1d330.appspot.com/");
        StorageReference storageRef = storage.getReference();


    }
}
