package com.iteso.raiteiteso.beans;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Daniel on 08/11/2015.
 */
public class UserWCar extends UserWOCar implements Parcelable{
    private String car;
    private String carColor;
    private int carCapacity;
    private boolean available;

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        super.writeToParcel(dest, flags);
        dest.writeString(car);
        dest.writeString(carColor);
        dest.writeInt(carCapacity);
        dest.writeByte((byte) (available ? 1 : 0));
    }

    public UserWCar(){

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

    protected UserWCar(Parcel in) {
        super(in);
        car = in.readString();
        carColor = in.readString();
        carCapacity = in.readInt();
        available = in.readByte() != 0;
    }
}