package com.app.databaseexample;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by iSaleem on 11/28/17.
 */

public class DB {
    MySqliteDatabaseHelper mySqliteDatabaseHelper;
    SQLiteDatabase sqLiteDatabase;
    DB(Context context){
        mySqliteDatabaseHelper = new MySqliteDatabaseHelper
                (context,"mydb",null,1);
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

        long id = sqLiteDatabase.insert(MySqliteDatabaseHelper.STUDENT_TABLE,null,contentValues);
        return id;
    }

}
