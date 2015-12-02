package com.iteso.raiteiteso.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.iteso.raiteiteso.database.DBContract.USERS_WITH_CAR;
import com.iteso.raiteiteso.database.DBContract.USERS_WITHOUT_CAR;
/**
 * Created by Daniel on 18/10/2015.
 */
public class DatabaseHandler extends SQLiteOpenHelper{

    private static final String DATABASE_NAME = "RaiteITESO.db";
    private static final int DATABASE_VERSION = 1;


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
        final String SQL_FOR_USERS_WITH_CAR_TABLE = "CEATE TABLE " + USERS_WITH_CAR.table_name + "(" +
                USERS_WITH_CAR.column_users_with_car_user_name + " TEXT PRIMARY KEY NOT NULL," +
                USERS_WITH_CAR.column_users_with_car_password + " TEXT NOT NULL," +
                USERS_WITH_CAR.column_users_with_car_name + " TEXT NOT NULL," +
                USERS_WITH_CAR.column_users_with_car_car + " TEXT NOT NULL," +
                USERS_WITH_CAR.column_users_with_car_car_color + " TEXT NOT NULL," +
                USERS_WITH_CAR.column_users_with_car_capacity + " INTEGER NOT NULL," +
                USERS_WITH_CAR.column_users_with_car_monday_hour + " TEXT NOT NULL," +
                USERS_WITH_CAR.column_users_with_car_tuesday_hour + " TEXT NOT NULL," +
                USERS_WITH_CAR.column_users_with_car_wednesday_hour + " TEXT NOT NULL," +
                USERS_WITH_CAR.column_users_with_car_thursday_hour + " TEXT NOT NULL," +
                USERS_WITH_CAR.column_users_with_car_friday_hour + " TEXT NOT NULL," +
                USERS_WITH_CAR.column_users_with_car_aviable + " INTEGER NOT NULL." +
                USERS_WITH_CAR.column_users_with_car_interest_point + " TEXT NOT NULL," +
                USERS_WITH_CAR.column_users_with_car_ride_request + " TEXT NOT NULL);";

        db.execSQL(SQL_FOR_USERS_WITH_CAR_TABLE);

        final String SQL_FOR_USERS_WITHOUT_CAR_TABLE = "CEATE TABLE " + USERS_WITHOUT_CAR.table_name + "(" +
                USERS_WITHOUT_CAR.column_users_without_car_user_name + " TEXT PRIMARY KEY NOT NULL," +
                USERS_WITHOUT_CAR.column_users_without_car_password + " TEXT NOT NULL," +
                USERS_WITHOUT_CAR.column_users_without_car_name + " TEXT NOT NULL," +
                USERS_WITHOUT_CAR.column_users_without_car_monday_hour + " TEXT NOT NULL," +
                USERS_WITHOUT_CAR.column_users_without_car_tuesday_hour + " TEXT NOT NULL," +
                USERS_WITHOUT_CAR.column_users_without_car_wednesday_hour + " TEXT NOT NULL," +
                USERS_WITHOUT_CAR.column_users_without_car_thursday_hour + " TEXT NOT NULL," +
                USERS_WITHOUT_CAR.column_users_without_car_friday_hour + " TEXT NOT NULL," +
                USERS_WITHOUT_CAR.column_users_without_car_interest_point + " TEXT NOT NULL," +
                USERS_WITHOUT_CAR.column_users_without_car_ride_user + " TEXT NOT NULL," +
                USERS_WITHOUT_CAR.column_users_without_car_meeting_point + " TEXT NOT NULL);";

        db.execSQL(SQL_FOR_USERS_WITHOUT_CAR_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {}
}
