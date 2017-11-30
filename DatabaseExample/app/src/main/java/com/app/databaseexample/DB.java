package com.app.databaseexample;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;

/**
 * Created by iSaleem on 11/28/17.
 */

public class DB {


    MySqliteDatabaseHelper mySqliteDatabaseHelper;
    SQLiteDatabase sqLiteDatabase;
    DB(Context context){
        mySqliteDatabaseHelper = new MySqliteDatabaseHelper
                (context,"mydb",null,5);
    }

    public DB open(){
        sqLiteDatabase = mySqliteDatabaseHelper.getWritableDatabase();
        return this;
    }

    public void close(){
        sqLiteDatabase.close();
    }

    public long addStudent(String name){
        sqLiteDatabase.beginTransaction();
        ContentValues contentValues = new ContentValues();
        contentValues.put(MySqliteDatabaseHelper.STUDENT_NAME_COLUMN,name);

        long id = sqLiteDatabase.insert(MySqliteDatabaseHelper.STUDENT_TABLE
                ,null,contentValues);
        sqLiteDatabase.endTransaction();
        return id;
    }

    public Cursor getStudents(){
        Cursor cursor = sqLiteDatabase.rawQuery("select * from " +
                MySqliteDatabaseHelper.STUDENT_TABLE ,null);

        //Cursor cursor = sqLiteDatabase.query(MySqliteDatabaseHelper.STUDENT_TABLE,new String[]{MySqliteDatabaseHelper.STUDENT_NAME_COLUMN},null,null,null,null,null,null);

        return cursor;
    }

    public Cursor getStudents(int id){
        Cursor cursor = sqLiteDatabase.rawQuery("select * from " +
                MySqliteDatabaseHelper.STUDENT_TABLE +
                " WHERE id=? ",new String[]{id+""});
        return cursor;
    }

    public int updateStudent(int id,String name){
        ContentValues contentValues = new ContentValues();
        contentValues.put(MySqliteDatabaseHelper.STUDENT_NAME_COLUMN,name);
        int affectedRows = sqLiteDatabase.update(MySqliteDatabaseHelper.STUDENT_TABLE,
                contentValues,
                MySqliteDatabaseHelper.STUDENT_ID_COLUMN+"=?"
                ,new String[]{id+""});

        return affectedRows;
    }
    public long deleteStudent(int id){
        int deletedRows = sqLiteDatabase.delete(MySqliteDatabaseHelper.STUDENT_TABLE
                ,""
                ,new String[]{id+""});
        return deletedRows;
    }

    public long insertWithHighPerformance(String name){
        SQLiteStatement sqLiteStatement = sqLiteDatabase.compileStatement("insert into " + MySqliteDatabaseHelper.STUDENT_TABLE + "("+MySqliteDatabaseHelper.STUDENT_NAME_COLUMN + " values(?)" );
        sqLiteStatement.bindString(1,name);
        long id = sqLiteStatement.executeInsert();
        return id;

    }

}
