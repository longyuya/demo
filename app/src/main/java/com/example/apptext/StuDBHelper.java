package com.example.apptext;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;


public class StuDBHelper extends SQLiteOpenHelper {
    private static final String TAG = "TestSQLite";
    private static final int VERSION = 1;


    public StuDBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "create table stu_table(id int,sname varchar(20),sage int"+"t,ssex varchar(10))";
        Log.i(TAG, "Create Database---------------- ");
        db.execSQL(sql);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.i(TAG, "Upgrade Database---------------- ");

    }
}
