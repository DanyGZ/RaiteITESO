package com.iteso.raiteiteso.gui;

import android.content.Context;

import com.iteso.raiteiteso.beans.UserWOCar;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

/**
 * Created by giovanni on 02/12/2015.
 */
public class AdapterListWithCarTest {
    AdapterListWithCar adapterListWithCar;

    @Before
    public void setUp() {
        UserWOCar user1 = new UserWOCar();
        user1.setUserName("Juan");
        UserWOCar user2 = new UserWOCar();
        user2.setUserName("Pedro");
        ArrayList<UserWOCar> pointsInterest = new ArrayList<>();
        pointsInterest.add(user1);
        pointsInterest.add(user2);
        adapterListWithCar = new AdapterListWithCar(pointsInterest, mock(Context.class));
    }
    /*
    @Test
    public void getCheckedItemsTest() {
        ArrayList<Boolean> checkedExpected = new ArrayList<>();
        checkedExpected.add(true);
        checkedExpected.add(true);
        assertEquals("getChekedItems fail", checkedExpected, AdapterListWithCar.getCheckedItems());
    }
    */
    @Test
    public void getCountTest() {
        final int expected = 2;
        final int actual = adapterListWithCar.getCount();
        assertEquals("getCount fail", expected, actual);
    }

    @Test
    public void getItemTest() {
        final String expected = "Juan";
        UserWOCar userExpected = new UserWOCar();
        userExpected.setUserName(expected);
        UserWOCar userActual = (UserWOCar) adapterListWithCar.getItem(0);
        final String actual = userActual.getUserName();
        assertEquals("getItem fail", expected, actual);
    }

    @Test
    public void getItemIDTest() {
        final long expected = 0;
        final long actual = adapterListWithCar.getItemId(0);
        assertEquals("getItemID fail", expected, actual);
    }
}
