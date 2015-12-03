package com.iteso.raiteiteso.beans;

import com.iteso.raiteiteso.beans.UserWCar;
import com.iteso.raiteiteso.beans.UserWOCar;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by giovanni on 01/12/2015.
 */
public class UserWOCarTest {
    UserWOCar userWOCar;

    @Before
    public void setUp() {
        userWOCar = new UserWOCar();
    }

    @Test
    public void testDescribeContents() {
        final int expected = 0;
        final int actual = userWOCar.describeContents();
        assertEquals("UserWOCar DescribeContents return wrong result", expected, actual);
    }

    @Test
    public void testGetAndSetUserName() {
        final String expected = "Juanito";
        userWOCar.setUserName(expected);
        final String actual = userWOCar.getUserName();
        assertEquals("Get And Set UserName are wrong", expected, actual);
    }

    @Test
    public void testGetAndSetPassword() {
        final String expected = "1234";
        userWOCar.setPassword(expected);
        final String actual = userWOCar.getPassword();
        assertEquals("Get And Set Password", expected, actual);
    }

    @Test
    public void testAddRideTrue() {
        UserWOCar userWO = new UserWOCar();
        UserWCar userW = new UserWCar(userWOCar);
        userW.setCarAttributes("Mazda", "Blanco", 5, true);
        final boolean actual = userWO.addRide(userW);
        assertEquals("Add Ride True fail", true, actual);
    }

    @Test
    public void testAddRideFalse() throws Exception{
        UserWOCar userWO = new UserWOCar();
        UserWCar userW = new UserWCar(userWOCar);
        userW.setCarAttributes("Focus", "Rojo", 2, true);
        userWO.addRide(userW);
        final boolean actual = userWO.addRide(userW);
        assertEquals("Add Ride False fail", false, actual);
    }

}
