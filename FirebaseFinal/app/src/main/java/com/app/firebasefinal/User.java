package com.app.firebasefinal;

/**
 * Created by iSaleem on 12/10/17.
 */

public class User {

    private String username;
    private String email;

    User(){

    }

    User(String username,String email){
        this.username = username;
        this.email = email;
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
