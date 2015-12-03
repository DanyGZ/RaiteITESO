package com.iteso.raiteiteso.beans;

import com.iteso.raiteiteso.beans.UserWCar;
import com.iteso.raiteiteso.beans.UserWOCar;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

/**
 * Created by giovanni on 01/12/2015.
 */
public class UserWCarTest {
    UserWCar userWcar;

    @Before
    public void setUp() {
        userWcar = new UserWCar(mock(UserWOCar.class));
    }


    @Test
    public void testDescribeContents() {
        final int expected = 0;
        final int actual = userWcar.describeContents();
        assertEquals("UserWCar DescribeContents return wrong result", expected, actual);
    }

    @Test
    public void testGetAndSetCar() {
        final String expected = "Mazda";
        userWcar.setCar(expected);
        final String actual = userWcar.getCar();
        assertEquals("Get or Set car is wrong", expected, actual);
    }

    @Test
    public void testGetAndSetColor() {
        final String expected = "Blanco";
        userWcar.setCarColor(expected);
        final String actual = userWcar.getCarColor();
        assertEquals("Get or Set car color is wrong", expected, actual);
    }

    @Test
    public void testSetCarAttributes() {
        final String carro = "Focus";
        final String color = "Rojo";
        final int capacidad = 5;
        final boolean disponible = true;
        userWcar.setCarAttributes(carro, color, capacidad, disponible);
        assertEquals("testSetCarAttributes carro is wrong", carro, userWcar.getCar());
        assertEquals("testSetCarAttributes color is wrong", color, userWcar.getCarColor());
        assertEquals("testSetCarAttributes capacidad is wrong", capacidad, userWcar.getCarCapacity());
        assertEquals("testSetCarAttributes disponible is wrong", disponible, userWcar.isAvailable());
    }

    @Test
    public void testAddRideTrue() {
        UserWOCar userWO = new UserWOCar();
        userWcar.setCarAttributes("Mazda", "Blanco", 5, true);
        final boolean actual = userWO.addRide(userWcar);
        assertEquals("Add Ride True fail", true, actual);
    }

    @Test
    public void testAddRideFalse() throws Exception{
        UserWOCar userWO = new UserWOCar();
        userWcar.setCarAttributes("Focus", "Rojo", 2, true);
        userWO.addRide(userWcar);
        final boolean actual = userWO.addRide(userWcar);
        assertEquals("Add Ride False fail", false, actual);
    }

    @Test
    public void testRemoveObserver() {
        UserWOCar userWO = new UserWOCar();
        userWcar.setCarAttributes("Mazda", "Blanco", 5, true);
        userWO.addRide(userWcar);
        userWcar.removeObserver(userWO);
        ArrayList<UserWOCar> expected = new ArrayList<UserWOCar>(); // Lista Vacia
        assertEquals("removeObserver isn't working", expected , userWcar.getUserWOCars());
    }
}
