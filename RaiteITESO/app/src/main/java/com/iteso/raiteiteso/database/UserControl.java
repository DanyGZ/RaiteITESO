package com.iteso.raiteiteso.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.iteso.raiteiteso.beans.UserWCar;
import com.iteso.raiteiteso.beans.UserWOCar;
import com.iteso.raiteiteso.utils.Constants;

import java.util.ArrayList;

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

        String interestPoints = "";

        for(int i=0; i<userWCar.getInterestPoints().size(); i++){
            if(i>0){
                interestPoints += ", ";
            }
            interestPoints += userWCar.getInterestPoints().get(i);
        }

        String rideRequest = "";
        for(int i=0; i<userWCar.getUserWOCars().size(); i++){
            if(i>0){
                rideRequest += ", ";
            }
            rideRequest += userWCar.getUserWOCars().get(i).getUserName();
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
        values.put(DatabaseHandler.USERS_WITH_CAR_INTEREST_POINTS, interestPoints);
        values.put(DatabaseHandler.USERS_WITH_CAR_RIDE_REQUEST, rideRequest);

        try{
            inserted = db.insertOrThrow(DatabaseHandler.USERS_WITH_CAR, null, values);
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

    public long addUserWithOutCar(UserWOCar userWOCar, DatabaseHandler dh){
        long inserted = 0;
        SQLiteDatabase db = dh.getWritableDatabase();
        ContentValues values = new ContentValues();

        String interestPoints = "";
        for(int i=0; i<userWOCar.getInterestPoints().size(); i++){
            if(i>0){
                interestPoints += ", ";
            }
            interestPoints += userWOCar.getInterestPoints().get(i);
        }
        interestPoints += "";

        values.put(DatabaseHandler.USERS_WITHOUT_CAR_USER_NAME, userWOCar.getUserName());
        values.put(DatabaseHandler.USERS_WITHOUT_CAR_PASSWORD, userWOCar.getPassword());
        values.put(DatabaseHandler.USERS_WITHOUT_CAR_NAME, userWOCar.getName());
        values.put(DatabaseHandler.USERS_WITHOUT_CAR_MONDAY_HOUR, userWOCar.getMondayHour());
        values.put(DatabaseHandler.USERS_WITHOUT_CAR_TUESDAY_HOUR, userWOCar.getTuesdayHour());
        values.put(DatabaseHandler.USERS_WITHOUT_CAR_WEDNESDAY_HOUR, userWOCar.getWednesdayHour());
        values.put(DatabaseHandler.USERS_WITHOUT_CAR_THURSDAY_HOUR, userWOCar.getThursdayHour());
        values.put(DatabaseHandler.USERS_WITHOUT_CAR_FRIDAY_HOUR, userWOCar.getFridayHour());
        values.put(DatabaseHandler.USERS_WITHOUT_CAR_INTEREST_POINTS, interestPoints);
        values.put(DatabaseHandler.USERS_WITHOUT_CAR_RIDE_USER, userWOCar.getRide());
        values.put(DatabaseHandler.USERS_WITHOUT_CAR_MEETING_POINT, userWOCar.getMeetingPoint());

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
                ", " + DatabaseHandler.USERS_WITH_CAR_AVAILABLE + ", " + DatabaseHandler.USERS_WITH_CAR_INTEREST_POINTS +
                ", " + DatabaseHandler.USERS_WITH_CAR_RIDE_REQUEST + " FROM " + DatabaseHandler.USERS_WITH_CAR +
                " WHERE " + DatabaseHandler.USERS_WITH_CAR_USER_NAME + " = " + " '" + userName + "'";



        SQLiteDatabase db = dh.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if(cursor.moveToFirst()){
            UserWOCar userWOCar = new UserWOCar();
            userWOCar.setUserName(cursor.getString(0));
            userWOCar.setPassword(cursor.getString(1));
            userWOCar.setName(cursor.getString(2));
            userWOCar.setMondayHour(cursor.getString(6));
            userWOCar.setTuesdayHour(cursor.getString(7));
            userWOCar.setWednesdayHour(cursor.getString(8));
            userWOCar.setThursdayHour(cursor.getString(9));
            userWOCar.setFridayHour(cursor.getString(10));

            userWCar = new UserWCar(userWOCar);
            userWCar.setCar(cursor.getString(3));
            userWCar.setCarColor(cursor.getString(4));
            userWCar.setCarCapacity(cursor.getInt(5));

            boolean avaliable;
            if(cursor.getInt(11) == 0){
                avaliable = false;
            }else{
                avaliable = true;
            }
            userWCar.setAvailable(avaliable);

            ArrayList<String> interestPointsArray = new ArrayList<>();
            String interesPoints = cursor.getString(12);
            String point = "";
            for(int i=0; i<interesPoints.length(); i++){
                if(interesPoints.charAt(i) != ','){
                    point += interesPoints.charAt(i);
                }else{
                    interestPointsArray.add(point);
                    point = "";
                }
            }
            interestPointsArray.add(point);
            userWCar.setInterestPoints(interestPointsArray);

            ArrayList<UserWOCar> userWOCars = new ArrayList<>();
            String user = "";
            String usersString = cursor.getString(13);
            for(int i=0; i<usersString.length(); i++){
                if(usersString.charAt(i) != ','){
                    user += usersString.charAt(i);
                }else{
                    userWOCars.add(getUserWithOuthCarByUserName(user, dh));
                    user = "";
                }
            }
            if(user.length() > 0) {
                userWOCars.add(getUserWithOuthCarByUserName(user, dh));
            }
            userWCar.setUserWOCars(userWOCars);
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
                ", " + DatabaseHandler.USERS_WITHOUT_CAR_INTEREST_POINTS + ", " + DatabaseHandler.USERS_WITHOUT_CAR_RIDE_USER +
                ", " + DatabaseHandler.USERS_WITHOUT_CAR_MEETING_POINT +
                " FROM " + DatabaseHandler.USERS_WITHOUT_CAR + " WHERE " + DatabaseHandler.USERS_WITHOUT_CAR_USER_NAME +
                " = " + " '" + userName + "'";

        SQLiteDatabase db = dh.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if(cursor.moveToFirst()){
            userWOCar = new UserWOCar();
            userWOCar.setUserName(cursor.getString(0));
            userWOCar.setPassword(cursor.getString(1));
            userWOCar.setName(cursor.getString(2));
            userWOCar.setMondayHour(cursor.getString(3));
            userWOCar.setTuesdayHour(cursor.getString(4));
            userWOCar.setWednesdayHour(cursor.getString(5));
            userWOCar.setThursdayHour(cursor.getString(6));
            userWOCar.setFridayHour(cursor.getString(7));


            ArrayList<String> interestPointsArray = new ArrayList<>();
            String interesPoints = cursor.getString(8);
            String point = "";
            for(int i=0; i<interesPoints.length(); i++){
                if(interesPoints.charAt(i) != ','){
                    point += interesPoints.charAt(i);
                }else{
                    interestPointsArray.add(point);
                    point = "";
                }
            }
            interestPointsArray.add(point);
            userWOCar.setInterestPoints(interestPointsArray);

            userWOCar.setRide(cursor.getString(9));
            userWOCar.setMeetingPoint(cursor.getString(10));
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

    public ArrayList<UserWCar> getRides(DatabaseHandler dh, int day, String hour){
        ArrayList<UserWCar> usersWCars = new ArrayList<>();
        String selectQuery = "Select " + DatabaseHandler.USERS_WITH_CAR_USER_NAME + ", " + DatabaseHandler.USERS_WITH_CAR_NAME +
                ", " + DatabaseHandler.USERS_WITH_CAR_CAR + ", " + DatabaseHandler.USERS_WITH_CAR_CAR_COLOR +
                ", " + DatabaseHandler.USERS_WITH_CAR_CAPACITY + ", " + DatabaseHandler.USERS_WITH_CAR_MONDAY_HOUR +
                ", " + DatabaseHandler.USERS_WITH_CAR_TUESDAY_HOUR + ", " + DatabaseHandler.USERS_WITH_CAR_WEDNESDAY_HOUR +
                ", " + DatabaseHandler.USERS_WITH_CAR_THURSDAY_HOUR + ", " + DatabaseHandler.USERS_WITH_CAR_FRIDAY_HOUR +
                ", " + DatabaseHandler.USERS_WITH_CAR_INTEREST_POINTS +
                ", " + DatabaseHandler.USERS_WITH_CAR_RIDE_REQUEST + ", " + DatabaseHandler.USERS_WITH_CAR_PASSWORD +
                " FROM " + DatabaseHandler.USERS_WITH_CAR +
                " WHERE ";

        switch (day){
            case Constants.MONDAY:
                selectQuery += DatabaseHandler.USERS_WITH_CAR_MONDAY_HOUR;
                break;
            case Constants.TUESDAY:
                selectQuery += DatabaseHandler.USERS_WITH_CAR_TUESDAY_HOUR;
                break;
            case Constants.WEDNESDAY:
                selectQuery += DatabaseHandler.USERS_WITH_CAR_WEDNESDAY_HOUR;
                break;
            case Constants.THURSDAY:
                selectQuery += DatabaseHandler.USERS_WITH_CAR_THURSDAY_HOUR;
                break;
            case Constants.FRIDAY:
                selectQuery += DatabaseHandler.USERS_WITH_CAR_FRIDAY_HOUR;
                break;
        }

        selectQuery += " = '" + hour + "' AND " + DatabaseHandler.USERS_WITH_CAR_AVAILABLE + " = 1";

        SQLiteDatabase db = dh.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if(cursor.moveToFirst()){
            do{
                UserWOCar userWOCar = new UserWOCar();
                userWOCar.setUserName(cursor.getString(0));
                userWOCar.setName(cursor.getString(1));
                userWOCar.setMondayHour(cursor.getString(5));
                userWOCar.setTuesdayHour(cursor.getString(6));
                userWOCar.setWednesdayHour(cursor.getString(7));
                userWOCar.setThursdayHour(cursor.getString(8));
                userWOCar.setFridayHour(cursor.getString(9));

                UserWCar userWCar = new UserWCar(userWOCar);
                userWCar.setCar(cursor.getString(2));
                userWCar.setCarColor(cursor.getString(3));
                userWCar.setCarCapacity(cursor.getInt(4));
                userWCar.setAvailable(true);

                ArrayList<String> interestPointsArray = new ArrayList<>();
                String interesPoints = cursor.getString(10);
                String point = "";
                for(int i=0; i<interesPoints.length(); i++){
                    if(interesPoints.charAt(i) != ','){
                        point += interesPoints.charAt(i);
                    }else{
                        interestPointsArray.add(point);
                        point = "";
                    }
                }
                interestPointsArray.add(point);
                userWCar.setInterestPoints(interestPointsArray);

                ArrayList<UserWOCar> userWOCars = new ArrayList<>();
                String user = "";
                String usersString = cursor.getString(11);
                for(int i=0; i<usersString.length(); i++){
                    if(usersString.charAt(i) != ','){
                        user += usersString.charAt(i);
                    }else{
                        userWOCars.add(getUserWithOuthCarByUserName(user, dh));
                        user = "";
                    }
                }
                if(user.length() > 0) {
                    userWOCars.add(getUserWithOuthCarByUserName(user, dh));
                }
                usersWCars.add(userWCar);
                userWCar.setUserWOCars(userWOCars);

                userWCar.setPassword(cursor.getString(12));

            }while(cursor.moveToNext());
        }

        try{
            cursor.close();
            db.close();
        }catch(Exception e){
        }
        cursor = null;
        db = null;

        return usersWCars;
    }

    public ArrayList<UserWOCar> getRidesRequest(DatabaseHandler dh, UserWCar userWCar) {
        ArrayList<UserWOCar> userWOCars = new ArrayList<>();
        String selectQuery = "Select " + DatabaseHandler.USERS_WITHOUT_CAR_USER_NAME + ", " +
                DatabaseHandler.USERS_WITHOUT_CAR_NAME + ", " + DatabaseHandler.USERS_WITHOUT_CAR_MONDAY_HOUR +
                ", " + DatabaseHandler.USERS_WITHOUT_CAR_TUESDAY_HOUR + ", " + DatabaseHandler.USERS_WITHOUT_CAR_WEDNESDAY_HOUR +
                ", " + DatabaseHandler.USERS_WITHOUT_CAR_THURSDAY_HOUR + ", " + DatabaseHandler.USERS_WITHOUT_CAR_FRIDAY_HOUR +
                ", " + DatabaseHandler.USERS_WITHOUT_CAR_INTEREST_POINTS + ", " + DatabaseHandler.USERS_WITHOUT_CAR_PASSWORD +
                ", " + DatabaseHandler.USERS_WITHOUT_CAR_RIDE_USER + ", " + DatabaseHandler.USERS_WITHOUT_CAR_MEETING_POINT +
                " FROM " + DatabaseHandler.USERS_WITHOUT_CAR ;

        for (int i = 0; i < userWCar.getUserWOCars().size(); i++) {
            if(i == 0){
               selectQuery += " WHERE ";
            }
            else{
                selectQuery += " OR ";
            }
            selectQuery += DatabaseHandler.USERS_WITHOUT_CAR_USER_NAME + " = '" +
                    userWCar.getUserWOCars().get(i).getUserName() + "'";
        }

        SQLiteDatabase db = dh.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                UserWOCar userWOCar = new UserWOCar();
                userWOCar.setUserName(cursor.getString(0));
                userWOCar.setName(cursor.getString(1));
                userWOCar.setMondayHour(cursor.getString(2));
                userWOCar.setTuesdayHour(cursor.getString(3));
                userWOCar.setWednesdayHour(cursor.getString(4));
                userWOCar.setThursdayHour(cursor.getString(5));
                userWOCar.setFridayHour(cursor.getString(6));


                ArrayList<String> interestPointsArray = new ArrayList<>();
                String interesPoints = cursor.getString(7);
                String point = "";
                for(int i=0; i<interesPoints.length(); i++){
                    if(interesPoints.charAt(i) != ','){
                        point += interesPoints.charAt(i);
                    }else{
                        interestPointsArray.add(point);
                        point = "";
                    }
                }
                interestPointsArray.add(point);
                userWOCar.setInterestPoints(interestPointsArray);

                userWOCar.setPassword(cursor.getString(8));
                userWOCar.setRide(cursor.getString(9));
                userWOCar.setMeetingPoint(cursor.getString(10));
                userWOCars.add(userWOCar);
            } while (cursor.moveToNext());
        }

        try{
            cursor.close();
            db.close();
        }catch(Exception e){
        }
        cursor = null;
        db = null;

        return userWOCars;
    }

    public int updateUserWithCar(DatabaseHandler dh, UserWCar userWCar){
        SQLiteDatabase db = dh.getWritableDatabase();
        ContentValues values = new ContentValues();

        int avaliable;
        if(userWCar.isAvailable()){
            avaliable = 1;
        }else{
            avaliable = 0;
        }

        String interestPoints = "";

        for(int i=0; i<userWCar.getInterestPoints().size(); i++){
            if(i>0){
                interestPoints += ",";
            }
            interestPoints += userWCar.getInterestPoints().get(i);
        }

        String rideRequest = "";
        for(int i=0; i<userWCar.getUserWOCars().size(); i++){
            if(userWCar.getUserWOCars().get(i).getUserName() != null) {
                if (i > 0) {
                    rideRequest += ",";
                }
                rideRequest += userWCar.getUserWOCars().get(i).getUserName();
            }
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
        values.put(DatabaseHandler.USERS_WITH_CAR_INTEREST_POINTS, interestPoints);
        values.put(DatabaseHandler.USERS_WITH_CAR_RIDE_REQUEST, rideRequest);

        int count = db.update(DatabaseHandler.USERS_WITH_CAR, values,
                DatabaseHandler.USERS_WITH_CAR_USER_NAME + " = ?", new String[] {userWCar.getUserName()});

        try{
            db.close();
        }catch(Exception e){
        }
        db = null;
        return count;

    }

    public int updateUsersWithOutCar(DatabaseHandler dh, UserWOCar userWOCar, String userWCName, String meetingPoint){
        SQLiteDatabase db = dh.getWritableDatabase();
        ContentValues values = new ContentValues();

        String interestPoints = "";
        for(int i=0; i<userWOCar.getInterestPoints().size(); i++){
            if(i>0){
                interestPoints += ",";
            }
            interestPoints += userWOCar.getInterestPoints().get(i);
        }
        interestPoints += "";

        values.put(DatabaseHandler.USERS_WITHOUT_CAR_USER_NAME, userWOCar.getUserName());
        values.put(DatabaseHandler.USERS_WITHOUT_CAR_PASSWORD, userWOCar.getPassword());
        values.put(DatabaseHandler.USERS_WITHOUT_CAR_NAME, userWOCar.getName());
        values.put(DatabaseHandler.USERS_WITHOUT_CAR_MONDAY_HOUR, userWOCar.getMondayHour());
        values.put(DatabaseHandler.USERS_WITHOUT_CAR_TUESDAY_HOUR, userWOCar.getTuesdayHour());
        values.put(DatabaseHandler.USERS_WITHOUT_CAR_WEDNESDAY_HOUR, userWOCar.getWednesdayHour());
        values.put(DatabaseHandler.USERS_WITHOUT_CAR_THURSDAY_HOUR, userWOCar.getThursdayHour());
        values.put(DatabaseHandler.USERS_WITHOUT_CAR_FRIDAY_HOUR, userWOCar.getFridayHour());
        values.put(DatabaseHandler.USERS_WITHOUT_CAR_INTEREST_POINTS, interestPoints);
        values.put(DatabaseHandler.USERS_WITHOUT_CAR_RIDE_USER, userWCName);
        values.put(DatabaseHandler.USERS_WITHOUT_CAR_MEETING_POINT, meetingPoint);

        int count = db.update(DatabaseHandler.USERS_WITHOUT_CAR, values,
                DatabaseHandler.USERS_WITHOUT_CAR_USER_NAME + " = ?", new String[] {userWOCar.getUserName()});

        try{
            db.close();
        }catch(Exception e){
        }
        db = null;
        return count;
    }

}
