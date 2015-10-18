package com.iteso.raiteiteso.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Daniel on 18/10/2015.
 */
public class DatabaseHandler extends SQLiteOpenHelper{

    private static final String DATABASE_NAME = "RaiteITESO.db";
    private static final int DATABASE_VERSION = 1;

    //Tables
    private static final String USERS = "Users";

    //Columns
    private static final String USER_NAME = "UserName";
    private static final String PASSWORD = "Password";
    private static final String NAME = "Name";
    private static final String USER_TYPE = "";

    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
