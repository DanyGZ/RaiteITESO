package com.iteso.raiteiteso.utils;

import com.iteso.raiteiteso.utils.Constants;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

/**
 * Created by giovanni on 02/12/2015.
 */
public class ConstantsTest {
    Constants constants;

    @Before
    public void setUp() {
        constants = new Constants();
    }

    @Test
    public void fillInterestPointsTest() {
        ArrayList<String> iPoints = new ArrayList<>();
        iPoints.add("Patria");
        iPoints.add("Colón");
        iPoints.add("Guadalupe");
        iPoints.add("López Mateos");
        constants.fillInterestPoints();
        assertEquals("fillInterestPoints works wrong", iPoints, constants.interestPoints);
    }
}
