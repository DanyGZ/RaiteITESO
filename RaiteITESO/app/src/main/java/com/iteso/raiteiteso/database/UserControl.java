package com.iteso.raiteiteso.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.iteso.raiteiteso.beans.UserWCar;
import com.iteso.raiteiteso.beans.UserWOCar;

/**
 * Created by Daniel on 08/11/2015.
 */
public class UserControl {
    private Context context;

    public UserControl(Context context){
        this.context = context;
    }

    public long addUserWithCar(UserWCar userWCar, DatabaseHandler dh){
        long inserted = 0;
        SQLiteDatabase db = dh.getWritableDatabase();
        ContentValues values = new ContentValues();

        int avaliable;
        if(userWCar.isAvailable()){
            avaliable = 1;
        }else{
            avaliable = 0;
        }

        values.put(DatabaseHandler.USERS_WITH_CAR_USER_NAME, userWCar.getUserName());
        values.put(DatabaseHandler.USERS_WITH_CAR_PASSWORD, userWCar.getPassword());
        values.put(DatabaseHandler.USERS_WITH_CAR_NAME, userWCar.getName());
        values.put(DatabaseHandler.USERS_WITH_CAR_CAR, userWCar.getCar());
        values.put(DatabaseHandler.USERS_WITH_CAR_CAR_COLOR, userWCar.getCarColor());
        values.put(DatabaseHandler.USERS_WITH_CAR_CAPACITY, userWCar.getCarCapacity());
        values.put(DatabaseHandler.USERS_WITH_CAR_MONDAY_HOUR, userWCar.getMondayHour());
        values.put(DatabaseHandler.USERS_WITH_CAR_TUESDAY_HOUR, userWCar.getTuesdayHour());
        values.put(DatabaseHandler.USERS_WITH_CAR_WEDNESDAY_HOUR, userWCar.getWednesdayHour());
        values.put(DatabaseHandler.USERS_WITH_CAR_THURSDAY_HOUR, userWCar.getThursdayHour());
        values.put(DatabaseHandler.USERS_WITH_CAR_FRIDAY_HOUR, userWCar.getFridayHour());
        values.put(DatabaseHandler.USERS_WITH_CAR_AVAILABLE, avaliable);

        try{
            inserted = db.insertOrThrow(DatabaseHandler.USERS_WITH_CAR, null, values);
        }catch(Exception e){
            inserted = -1;
            Log.v("TAG", e.getLocalizedMessage());
        }
        try{
            db.close();
        }catch(Exception e){

        }
        db=null;
        values=null;

        return inserted;
    }

    public long addUserWithOutCar(UserWOCar userWOCar, DatabaseHandler dh){
        long inserted = 0;
        SQLiteDatabase db = dh.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(DatabaseHandler.USERS_WITHOUT_CAR_USER_NAME, userWOCar.getUserName());
        values.put(DatabaseHandler.USERS_WITHOUT_CAR_PASSWORD, userWOCar.getPassword());
        values.put(DatabaseHandler.USERS_WITHOUT_CAR_NAME, userWOCar.getName());
        values.put(DatabaseHandler.USERS_WITHOUT_CAR_MONDAY_HOUR, userWOCar.getMondayHour());
        values.put(DatabaseHandler.USERS_WITHOUT_CAR_TUESDAY_HOUR, userWOCar.getTuesdayHour());
        values.put(DatabaseHandler.USERS_WITHOUT_CAR_WEDNESDAY_HOUR, userWOCar.getWednesdayHour());
        values.put(DatabaseHandler.USERS_WITHOUT_CAR_THURSDAY_HOUR, userWOCar.getThursdayHour());
        values.put(DatabaseHandler.USERS_WITHOUT_CAR_FRIDAY_HOUR, userWOCar.getFridayHour());

        try{
            inserted = db.insertOrThrow(DatabaseHandler.USERS_WITHOUT_CAR, null, values);
        }catch(Exception e){
            inserted = -1;
        }
        try{
            db.close();
        }catch(Exception e){

        }
        db=null;
        values=null;

        return inserted;
    }

    public UserWCar getUserWithCarByUserName(String userName, DatabaseHandler dh){
        UserWCar userWCar = null;
        String selectQuery = "Select " + DatabaseHandler.USERS_WITH_CAR_USER_NAME + ", " +
                DatabaseHandler.USERS_WITH_CAR_PASSWORD + ", " + DatabaseHandler.USERS_WITH_CAR_NAME +
                ", " + DatabaseHandler.USERS_WITH_CAR_CAR + ", " + DatabaseHandler.USERS_WITH_CAR_CAR_COLOR +
                ", " + DatabaseHandler.USERS_WITH_CAR_CAPACITY + ", " + DatabaseHandler.USERS_WITH_CAR_MONDAY_HOUR +
                ", " + DatabaseHandler.USERS_WITH_CAR_TUESDAY_HOUR + ", " + DatabaseHandler.USERS_WITH_CAR_WEDNESDAY_HOUR +
                ", " + DatabaseHandler.USERS_WITH_CAR_THURSDAY_HOUR + ", " + DatabaseHandler.USERS_WITH_CAR_FRIDAY_HOUR +
                ", " + DatabaseHandler.USERS_WITH_CAR_AVAILABLE + " FROM " + DatabaseHandler.USERS_WITH_CAR +
                " WHERE " + DatabaseHandler.USERS_WITH_CAR_USER_NAME + " = " + " '" + userName + "'";

        SQLiteDatabase db = dh.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if(cursor.moveToFirst()){
            userWCar = new UserWCar();
            userWCar.setUserName(cursor.getString(0));
            userWCar.setPassword(cursor.getString(1));
            userWCar.setName(cursor.getString(2));
            userWCar.setCar(cursor.getString(3));
            userWCar.setCarColor(cursor.getString(4));
            userWCar.setCarCapacity(cursor.getInt(5));
            userWCar.setMondayHour(cursor.getString(6));
            userWCar.setTuesdayHour(cursor.getString(7));
            userWCar.setWednesdayHour(cursor.getString(8));
            userWCar.setThursdayHour(cursor.getString(9));
            userWCar.setFridayHour(cursor.getString(10));

            boolean avaliable;
            if(cursor.getInt(11) == 0){
                avaliable = false;
            }else{
                avaliable = true;
            }
            userWCar.setAvailable(avaliable);
        }

        try{
            cursor.close();
            db.close();
        }catch(Exception e){
        }
        db = null;
        cursor = null;

        return userWCar;
    }

    public UserWOCar getUserWithOuthCarByUserName(String userName, DatabaseHandler dh){
        UserWOCar userWOCar = null;
        String selectQuery = "Select " + DatabaseHandler.USERS_WITHOUT_CAR_USER_NAME + ", " +
                DatabaseHandler.USERS_WITHOUT_CAR_PASSWORD + ", " + DatabaseHandler.USERS_WITHOUT_CAR_NAME +
                ", " + DatabaseHandler.USERS_WITHOUT_CAR_MONDAY_HOUR + ", " + DatabaseHandler.USERS_WITHOUT_CAR_TUESDAY_HOUR +
                ", " + DatabaseHandler.USERS_WITHOUT_CAR_WEDNESDAY_HOUR + ", " +
                DatabaseHandler.USERS_WITHOUT_CAR_THURSDAY_HOUR + ", " + DatabaseHandler.USERS_WITHOUT_CAR_FRIDAY_HOUR +
                " FROM " + DatabaseHandler.USERS_WITHOUT_CAR + " WHERE " + DatabaseHandler.USERS_WITHOUT_CAR_USER_NAME +
                " = " + " '" + userName + "'";

        SQLiteDatabase db = dh.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if(cursor.moveToFirst()){
            userWOCar = new UserWCar();
            userWOCar.setUserName(cursor.getString(0));
            userWOCar.setPassword(cursor.getString(1));
            userWOCar.setName(cursor.getString(2));
            userWOCar.setMondayHour(cursor.getString(3));
            userWOCar.setTuesdayHour(cursor.getString(4));
            userWOCar.setWednesdayHour(cursor.getString(5));
            userWOCar.setThursdayHour(cursor.getString(6));
            userWOCar.setFridayHour(cursor.getString(7));
        }

        try{
            cursor.close();
            db.close();
        }catch(Exception e){
        }
        db = null;
        cursor = null;

        return userWOCar;
    }
}
