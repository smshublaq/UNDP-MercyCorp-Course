package com.app.volleyexample;

/**
 * Created by iSaleem on 12/7/17.
 */

public class Post {
    private String body;
    private String title;
    private int userId;
    private int id;

    public Post(String body, String title, int userId, int id) {
        this.body = body;
        this.title = title;
        this.userId = userId;
        this.id = id;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
