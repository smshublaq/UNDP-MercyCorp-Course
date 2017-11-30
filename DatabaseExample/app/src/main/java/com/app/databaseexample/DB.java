package com.app.databaseexample;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by iSaleem on 11/28/17.
 */

public class DB {


    MySqliteDatabaseHelper mySqliteDatabaseHelper;
    SQLiteDatabase sqLiteDatabase;
    DB(Context context){
        mySqliteDatabaseHelper = new MySqliteDatabaseHelper
                (context,"mydb",null,4);
    }

    public DB open(){
        sqLiteDatabase = mySqliteDatabaseHelper.getWritableDatabase();
        return this;
    }

    public void close(){
        sqLiteDatabase.close();
    }

    public long addStudent(String name){
        ContentValues contentValues = new ContentValues();
        contentValues.put(MySqliteDatabaseHelper.STUDENT_NAME_COLUMN,name);

        long id = sqLiteDatabase.insert(MySqliteDatabaseHelper.STUDENT_TABLE
                ,null,contentValues);
        return id;
    }

    public Cursor getStudents(){
        Cursor cursor = sqLiteDatabase.rawQuery("select * from " +
                MySqliteDatabaseHelper.STUDENT_TABLE ,null);
        return cursor;
    }

    public Cursor getStudents(int id){
        Cursor cursor = sqLiteDatabase.rawQuery("select * from " +
                MySqliteDatabaseHelper.STUDENT_TABLE +
                " WHERE id = ?  ",new String[]{id+""});
        return cursor;
    }

}
