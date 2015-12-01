package com.iteso.raiteiteso;

import android.test.ActivityInstrumentationTestCase2;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.TextView;

import com.iteso.raiteiteso.gui.ActivityMainWithCar;
import com.iteso.raiteiteso.gui.R;

/**
 * Created by giovanni on 28/11/2015.
 */
public class ActMainWithCarTest extends ActivityInstrumentationTestCase2<ActivityMainWithCar> {
    private ActivityMainWithCar activityMainWithCar;
    private TextView titleTextView;

    public ActMainWithCarTest() {
        super(ActivityMainWithCar.class);
    }

    @Override
    protected void setUp() throws Exception{
        super.setUp();

        activityMainWithCar = getActivity();
        titleTextView = (TextView) activityMainWithCar.findViewById(R.id.activity_main_with_car_message_solicitud);
    }

    public void testPreconditions() {
        assertNotNull("titleTextView is null", activityMainWithCar);
    }

    public void testTitleTextView_text() {
        final String expected = "Solicitudes de Raite";
        final String actual = titleTextView.getText().toString();
        assertEquals("titleTextView contains wrong text", expected, actual);
    }
}