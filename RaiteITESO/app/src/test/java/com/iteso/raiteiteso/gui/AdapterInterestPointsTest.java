package com.iteso.raiteiteso.gui;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

/**
 * Created by giovanni on 02/12/2015.
 */
public class AdapterInterestPointsTest {
    AdapterInterestPoints adapterInterestPoints;

    @Before
    public void setUp() {
        ArrayList<String> interestPoints = new ArrayList<String>();
        interestPoints.add("Patria");
        interestPoints.add("Av Guadalupe");
        adapterInterestPoints = new AdapterInterestPoints(mock(Context.class), interestPoints);
    }

    @Test
    public void getCountTest() {
        final int expected = 2;
        final int actual = adapterInterestPoints.getCount();
        assertEquals("getCount fail", expected, actual);
    }

    @Test
    public void getItemTest() {
        final String expected = "Av Guadalupe";
        final String actual = adapterInterestPoints.getItem(1).toString();
        assertEquals("getItem fail", expected, actual);
    }

    @Test
    public void getItemID() {
        final long expected = 1;
        final long actual = adapterInterestPoints.getItemId(1);
        assertEquals("getItemID fail", expected, actual);
    }
}
