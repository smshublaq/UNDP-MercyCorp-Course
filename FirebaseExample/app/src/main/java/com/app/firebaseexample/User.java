package com.app.firebaseexample;

import com.google.firebase.database.IgnoreExtraProperties;

import java.io.Serializable;

/**
 * Created by iSaleem on 11/26/17.
 */

@IgnoreExtraProperties
public class User {

    private String username;
    private String email;

    User(){

    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
