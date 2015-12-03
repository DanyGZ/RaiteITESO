package com.iteso.raiteiteso.gui;

import android.content.Context;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

/**
 * Created by giovanni on 02/12/2015.
 */
public class AdapterListRaiteDetailTest {
    AdapterListRaiteDetail adapterListRaiteDetail;

    @Before
    public void setUp() {
        ArrayList<String> details = new ArrayList<>();
        details.add("Carro Bonito");
        details.add("Color Blanco");
        adapterListRaiteDetail = new AdapterListRaiteDetail(details, mock(Context.class));
    }

    @Test
    public void getCountTest() {
        final int expected = 2;
        final int actual = adapterListRaiteDetail.getCount();
        assertEquals("getCount fail", expected, actual);
    }

    @Test
    public void getItemTest() {
        final String expected = "Carro Bonito";
        final String actual = adapterListRaiteDetail.getItem(0).toString();
        assertEquals("getItem fail", expected, actual);
    }

    @Test
    public void getItemIDTest() {
        final long expected = 0;
        final long actual = adapterListRaiteDetail.getItemId(0);
        assertEquals("getItemID fail", expected, actual);
    }
}
