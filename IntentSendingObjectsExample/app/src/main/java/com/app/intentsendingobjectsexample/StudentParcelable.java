package com.app.intentsendingobjectsexample;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by iSaleem on 11/26/17.
 */

public class StudentParcelable implements Parcelable {


    private String name;
    private String id;
    private String department;
    private String college;
    private float gpa;
    private String dateOfBirth;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public float getGpa() {
        return gpa;
    }

    public void setGpa(float gpa) {
        this.gpa = gpa;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public StudentParcelable() {
    }

    protected StudentParcelable(Parcel in) {
        id = in.readString();
        name = in.readString();
        gpa = in.readFloat();
        college = in.readString();
        department = in.readString();
        dateOfBirth = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeString(name);
        dest.writeFloat(gpa);
        dest.writeString(college);
        dest.writeString(department);
        dest.writeString(dateOfBirth);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<StudentParcelable> CREATOR = new Creator<StudentParcelable>() {
        @Override
        public StudentParcelable createFromParcel(Parcel in) {
            return new StudentParcelable(in);
        }

        @Override
        public StudentParcelable[] newArray(int size) {
            return new StudentParcelable[size];
        }
    };
}
