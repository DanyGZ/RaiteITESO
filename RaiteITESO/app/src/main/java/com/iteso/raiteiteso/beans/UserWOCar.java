package com.iteso.raiteiteso.beans;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

/**
 * Created by Daniel on 18/10/2015.
 */
public class UserWOCar implements Parcelable{
    private String userName;
    private String password;
    private String name;
    private String mondayHour;
    private String tuesdayHour;
    private String wednesdayHour;
    private String thursdayHour;
    private String fridayHour;
    private String ride;
    private ArrayList<String> interestPoints;


    public UserWOCar(){
        ride = "";
    }

    protected UserWOCar(Parcel in) {
        userName = in.readString();
        password = in.readString();
        name = in.readString();
        mondayHour = in.readString();
        tuesdayHour = in.readString();
        wednesdayHour = in.readString();
        thursdayHour = in.readString();
        fridayHour = in.readString();
        ride = in.readString();
        interestPoints = in.createStringArrayList();
    }

    public static final Creator<UserWOCar> CREATOR = new Creator<UserWOCar>() {
        @Override
        public UserWOCar createFromParcel(Parcel in) {
            return new UserWOCar(in);
        }

        @Override
        public UserWOCar[] newArray(int size) {
            return new UserWOCar[size];
        }
    };

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMondayHour() {
        return mondayHour;
    }

    public void setMondayHour(String mondayHour) {
        this.mondayHour = mondayHour;
    }

    public String getTuesdayHour() {
        return tuesdayHour;
    }

    public void setTuesdayHour(String tuesdayHour) {
        this.tuesdayHour = tuesdayHour;
    }

    public String getWednesdayHour() {
        return wednesdayHour;
    }

    public void setWednesdayHour(String wednesdayHour) {
        this.wednesdayHour = wednesdayHour;
    }

    public String getThursdayHour() {
        return thursdayHour;
    }

    public void setThursdayHour(String thursdayHour) {
        this.thursdayHour = thursdayHour;
    }

    public String getFridayHour() {
        return fridayHour;
    }

    public void setFridayHour(String fridayHour) {
        this.fridayHour = fridayHour;
    }

    public String getRide() {
        return ride;
    }

    public void setRide(String ride) {
        this.ride = ride;
    }

    public ArrayList<String> getInterestPoints() {
        return interestPoints;
    }

    public void setInterestPoints(ArrayList<String> interestPoints) {
        this.interestPoints = interestPoints;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(userName);
        dest.writeString(password);
        dest.writeString(name);
        dest.writeString(mondayHour);
        dest.writeString(tuesdayHour);
        dest.writeString(wednesdayHour);
        dest.writeString(thursdayHour);
        dest.writeString(fridayHour);
        dest.writeString(ride);
        dest.writeStringList(interestPoints);
    }
}
