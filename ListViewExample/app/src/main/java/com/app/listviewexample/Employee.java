package com.app.listviewexample;

/**
 * Created by iSaleem on 11/21/17.
 */

class Employee {
    private String title;
    private String subTitle;
    private int imageResource;

    public Employee(String title, String subTitle, int imageResource) {
        this.title = title;
        this.subTitle = subTitle;
        this.imageResource = imageResource;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    public int getImageResource() {
        return imageResource;
    }

    public void setImageResource(int imageResource) {
        this.imageResource = imageResource;
    }
}
