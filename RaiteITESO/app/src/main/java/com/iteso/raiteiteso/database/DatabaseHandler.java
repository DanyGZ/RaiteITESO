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
    public static final String USERS_WITH_CAR = "UsersWC";
    public static final String USERS_WITHOUT_CAR = "UsersWOC";

    //Columns
    public static final String USERS_WITH_CAR_USER_NAME = "WCusername";
    public static final String USERS_WITH_CAR_PASSWORD = "WCpassword";
    public static final String USERS_WITH_CAR_NAME = "WCname";
    public static final String USERS_WITH_CAR_CAR = "Car";
    public static final String USERS_WITH_CAR_CAR_COLOR = "Carcolor";
    public static final String USERS_WITH_CAR_CAPACITY = "Carcapacity";
    public static final String USERS_WITH_CAR_MONDAY_HOUR = "WCmondayhour";
    public static final String USERS_WITH_CAR_TUESDAY_HOUR = "WCtuesdayhour";
    public static final String USERS_WITH_CAR_WEDNESDAY_HOUR = "WCwednesdayhour";
    public static final String USERS_WITH_CAR_THURSDAY_HOUR = "WCthursdayhour";
    public static final String USERS_WITH_CAR_FRIDAY_HOUR = "WCfridayhour";
    public static final String USERS_WITH_CAR_AVAILABLE = "Available";

    public static final String USERS_WITHOUT_CAR_USER_NAME = "WOCusername";
    public static final String USERS_WITHOUT_CAR_PASSWORD = "WOCpassword";
    public static final String USERS_WITHOUT_CAR_NAME = "WOCname";
    public static final String USERS_WITHOUT_CAR_MONDAY_HOUR = "WOCmondayhour";
    public static final String USERS_WITHOUT_CAR_TUESDAY_HOUR = "WOCtuesdayhour";
    public static final String USERS_WITHOUT_CAR_WEDNESDAY_HOUR = "WOCwednesdayhour";
    public static final String USERS_WITHOUT_CAR_THURSDAY_HOUR = "WOCthursdayhour";
    public static final String USERS_WITHOUT_CAR_FRIDAY_HOUR = "WOCfridayhour";


    private static DatabaseHandler databaseHandler;

    private DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public static DatabaseHandler getInstance(Context context){
        if(databaseHandler == null){
            databaseHandler = new DatabaseHandler(context);
        }
        return databaseHandler;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE " + USERS_WITH_CAR + " (" + USERS_WITH_CAR_USER_NAME + " TEXT PRIMARY KEY, "+
                USERS_WITH_CAR_PASSWORD + " TEXT, " + USERS_WITH_CAR_NAME + " TEXT, " +
                USERS_WITH_CAR_CAR + " TEXT, " + USERS_WITH_CAR_CAR_COLOR + " TEXT, " +
                USERS_WITH_CAR_CAPACITY + " INTEGER, " + USERS_WITH_CAR_MONDAY_HOUR + " TEXT, " +
                USERS_WITH_CAR_TUESDAY_HOUR + " TEXT, " + USERS_WITH_CAR_WEDNESDAY_HOUR + " TEXT, " +
                USERS_WITH_CAR_THURSDAY_HOUR + " TEXT, " + USERS_WITH_CAR_FRIDAY_HOUR + " TEXT, " +
                USERS_WITH_CAR_AVAILABLE + " INTEGER);";
        db.execSQL(sql);

        sql = "CREATE TABLE " + USERS_WITHOUT_CAR + " (" + USERS_WITHOUT_CAR_USER_NAME + " TEXT PRIMARY KEY, " +
                USERS_WITHOUT_CAR_PASSWORD + " TEXT, " + USERS_WITHOUT_CAR_NAME + " TEXT, " +
                USERS_WITHOUT_CAR_MONDAY_HOUR + " TEXT, " + USERS_WITHOUT_CAR_TUESDAY_HOUR + " TEXT, " +
                USERS_WITHOUT_CAR_WEDNESDAY_HOUR + " TEXT, " + USERS_WITHOUT_CAR_THURSDAY_HOUR + " TEXT, " +
                USERS_WITHOUT_CAR_FRIDAY_HOUR + " ,TEXT);";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {}
}
