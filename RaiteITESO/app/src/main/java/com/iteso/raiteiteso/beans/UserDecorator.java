package com.iteso.raiteiteso.beans;

/**
 * Created by Daniel on 24/11/2015.
 */
public abstract class UserDecorator extends UserWOCar {
    public abstract void setCarAttributes(String car, String color, int capacity, boolean available);
}
