package com.iteso.raiteiteso.beans;

import android.os.Parcel;
import android.os.Parcelable;

import com.iteso.raiteiteso.database.DatabaseHandler;
import com.iteso.raiteiteso.database.UserControl;
import com.iteso.raiteiteso.gui.Subject;

import java.util.ArrayList;

/**
 * Created by Daniel on 08/11/2015.
 */
public class UserWCar extends UserDecorator implements Parcelable, Subject{
    private String car;
    private String carColor;
    private int carCapacity;
    private boolean available;
    private UserWOCar userWOCar;
    private ArrayList<UserWOCar> userWOCars;


    public UserWCar(UserWOCar userWOCar){
        userWOCars = new ArrayList<>();
        this.userWOCar = userWOCar;
    }

    protected UserWCar(Parcel in) {
        car = in.readString();
        carColor = in.readString();
        carCapacity = in.readInt();
        available = in.readByte() != 0;
        userWOCar = in.readParcelable(UserWOCar.class.getClassLoader());
        userWOCars = in.createTypedArrayList(UserWOCar.CREATOR);
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(car);
        dest.writeString(carColor);
        dest.writeInt(carCapacity);
        dest.writeByte((byte) (available ? 1 : 0));
        dest.writeParcelable(userWOCar, flags);
        dest.writeTypedList(userWOCars);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<UserWCar> CREATOR = new Creator<UserWCar>() {
        @Override
        public UserWCar createFromParcel(Parcel in) {
            return new UserWCar(in);
        }

        @Override
        public UserWCar[] newArray(int size) {
            return new UserWCar[size];
        }
    };

    public String getCar() {
        return car;
    }

    public void setCar(String car) {
        this.car = car;
    }

    public String getCarColor() {
        return carColor;
    }

    public void setCarColor(String carColor) {
        this.carColor = carColor;
    }

    public int getCarCapacity() {
        return carCapacity;
    }

    public void setCarCapacity(int carCapacity) {
        this.carCapacity = carCapacity;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public ArrayList<UserWOCar> getUserWOCars() {
        return userWOCars;
    }

    public void setUserWOCars(ArrayList<UserWOCar> userWOCars) {
        this.userWOCars = userWOCars;
    }

    @Override
    public boolean registerObserver(UserWOCar observer) {
        boolean flag = true;
        for(int i=0; i<userWOCars.size(); i++){
            if(userWOCars.get(i).getUserName() == (observer.getUserName())){
                flag = false;
            }
        }

        if(flag){
            userWOCars.add(observer);
        }

        return flag;
    }

    @Override
    public void notifyObservers(DatabaseHandler dh, String meetingPoint, UserControl userControl, String userName) {
        for(UserWOCar userWOCar : userWOCars){
            if(userWOCar.getRide().equals(getUserName()) || !meetingPoint.equals(""))
                userWOCar.update(dh, userControl, userName, meetingPoint);
        }
    }

    @Override
    public void removeObserver(UserWOCar observer) {
        userWOCars.remove(observer);
    }

    @Override
    public void setCarAttributes(String car, String color, int capacity, boolean available) {
        setCar(car);
        setCarColor(color);
        setCarCapacity(capacity);
        setAvailable(available);
    }

    public String getUserName() {
        return userWOCar.getUserName();
    }

    public void setUserName(String userName) {
        userWOCar.setUserName(userName);
    }

    public String getPassword() {
        return userWOCar.getPassword();
    }

    public void setPassword(String password) {
        userWOCar.setPassword(password);
    }

    public String getName() {
        return userWOCar.getName();
    }

    public void setName(String name) {
        userWOCar.setName(name);
    }

    public String getMondayHour() {
        return userWOCar.getMondayHour();
    }

    public void setMondayHour(String mondayHour) {
        userWOCar.setMondayHour(mondayHour);
    }

    public String getTuesdayHour() {
        return userWOCar.getTuesdayHour();
    }

    public void setTuesdayHour(String tuesdayHour) {
        userWOCar.setTuesdayHour(tuesdayHour);
    }

    public String getWednesdayHour() {
        return userWOCar.getWednesdayHour();
    }

    public void setWednesdayHour(String wednesdayHour) {
        userWOCar.setWednesdayHour(wednesdayHour);
    }

    public String getThursdayHour() {
        return userWOCar.getThursdayHour();
    }

    public void setThursdayHour(String thursdayHour) {
        userWOCar.setThursdayHour(thursdayHour);
    }

    public String getFridayHour() {
        return userWOCar.getFridayHour();
    }

    public void setFridayHour(String fridayHour) {
        userWOCar.setFridayHour(fridayHour);
    }

    public ArrayList<String> getInterestPoints() {
        return userWOCar.getInterestPoints();
    }

    public void setInterestPoints(ArrayList<String> interestPoints) {
        userWOCar.setInterestPoints(interestPoints);
    }
}
