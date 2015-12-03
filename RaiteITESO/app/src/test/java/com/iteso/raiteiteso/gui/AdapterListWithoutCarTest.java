package com.iteso.raiteiteso.gui;

/**
 * Created by Daniel on 02/12/2015.
 */
import android.content.Context;
import com.iteso.raiteiteso.beans.UserWCar;
import com.iteso.raiteiteso.beans.UserWOCar;

import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
/**
 * Created by salvadorbeltran on 12/2/2015.
 */
public class AdapterListWithoutCarTest {
    AdapterListWithoutCar adapterListWithoutCar;

    @Before
    public void setUp() {
        UserWOCar user3 = new UserWOCar();
        user3.setUserName("Pancho");
        UserWCar user1 = new UserWCar(user3);
        user1.setUserName("Salvador");
        UserWOCar user4 = new UserWOCar();
        user4.setUserName("Pablito");
        UserWCar user2 = new UserWCar(user4);
        user2.setUserName("Fabian");

        ArrayList<UserWCar> interestPoints = new ArrayList<>();
        interestPoints.add(user1);
        interestPoints.add(user2);
        adapterListWithoutCar = new AdapterListWithoutCar(interestPoints, mock(Context.class));
    }

    @Test
    public void getCountTest() {
        final int expected = 2;
        final int actual = adapterListWithoutCar.getCount();
        assertEquals("getCount fail", expected, actual);
    }

    @Test
    public void getItemTest() {
        final String expected = "com.iteso.raiteiteso.beans.UserWCar@402f32ff";
        final String actual = adapterListWithoutCar.getItem(1).toString();
        assertEquals("getItem fail", expected, actual);
    }

    @Test
    public void getItemIDTest() {
        final long expected = 1;
        final long actual = adapterListWithoutCar.getItemId(1);
        assertEquals("getItemIDTest fail", expected, actual);
    }
}
