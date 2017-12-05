package com.app.firebaseexample;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class AuthActivity extends AppCompatActivity {
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth);

        mAuth = FirebaseAuth.getInstance();

        /*
        mAuth.createUserWithEmailAndPassword("bb@cc.com","1234!@#$%^&").addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful()) {
                        String uid = task.getResult().getUser().getUid();
                        Toast.makeText(AuthActivity.this, uid, Toast.LENGTH_SHORT).show();
                    }
                    else {
                        Toast.makeText(AuthActivity.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    }
            }
        });
        */

        mAuth.signInWithEmailAndPassword("bb@cc.com","1234!@#$%^&").addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Toast.makeText(AuthActivity.this, "Valid Username & Password", Toast.LENGTH_SHORT).show();
                }
                else {

                }
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser !=null)
            Toast.makeText(this, currentUser.getEmail(), Toast.LENGTH_SHORT).show();
    }
}
