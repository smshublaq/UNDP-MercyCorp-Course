package com.app.databaseexample;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by iSaleem on 11/28/17.
 */

public class MySqliteDatabaseHelper extends SQLiteOpenHelper {
    public static final String STUDENT_TABLE = "STUDENT_TABLE";
    public static final String STUDENT_NAME_COLUMN = "STUDENT_NAME";
    public static final String STUDENT_ID_COLUMN = "_id";

    public MySqliteDatabaseHelper(Context context,
                                  String name,
                                  SQLiteDatabase.CursorFactory factory
            , int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE " + STUDENT_TABLE
                + "(" + STUDENT_ID_COLUMN + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                " "+STUDENT_NAME_COLUMN+ " TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase,
                          int oldVersion, int newVersion) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+STUDENT_TABLE);
        this.onCreate(sqLiteDatabase);
    }
}
