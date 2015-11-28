package com.iteso.raiteiteso;

import android.test.ActivityInstrumentationTestCase2;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.TextView;

import com.iteso.raiteiteso.gui.ActivityMainWithOutCar;
import com.iteso.raiteiteso.gui.R;

/**
 * Created by giovanni on 28/11/2015.
 */
public class ActMainWithOutCarTest extends ActivityInstrumentationTestCase2<ActivityMainWithOutCar> {
    private ActivityMainWithOutCar activityMainWithOutCar;
    private TextView titleTextView;
    private ImageView logoImageView;
    private ImageView refreshImageView;
    private ListView ridesListView;
//    private LinearLayout irmeAhoraLinearLayout;
//    private Switch irmeAhoraSwitch;

    public ActMainWithOutCarTest() {
        super(ActivityMainWithOutCar.class);
    }

    @Override
    protected void setUp() throws Exception{
        super.setUp();

        activityMainWithOutCar = getActivity();
        titleTextView = (TextView) activityMainWithOutCar.findViewById(R.id.activity_main_without_car_no_raite);
        logoImageView = (ImageView) activityMainWithOutCar.findViewById(R.id.activity_main_without_car_image);
        refreshImageView = (ImageView) activityMainWithOutCar.findViewById(R.id.activity_main_without_car_refresh);
        ridesListView = (ListView) activityMainWithOutCar.findViewById(R.id.activity_main_without_car_list);
//        irmeAhoraLinearLayout = (LinearLayout) irmeAhoraLinearLayout.findViewById(R.id.activity_main_without_car_layout1);
//        irmeAhoraSwitch = (Switch) irmeAhoraSwitch.findViewById(R.id.activity_main_without_car_visible);
    }

    public void testPreconditions() {
        assertNotNull("activityMainWithOutCar is null", activityMainWithOutCar);
        assertNotNull("titleTextView is null", titleTextView);
        assertNotNull("logoImageView is null", logoImageView);
        assertNotNull("refreshImageView is null", refreshImageView);
        assertNotNull("ridesListView is null", ridesListView);
//        assertNotNull("irmeAhoraLinearLayout is null", irmeAhoraLinearLayout);
//        assertNotNull("irmeAhoraSwitch is null", irmeAhoraSwitch);
    }

    public void testTitleTextView_text() {
        final String expected = "Raites Disponibles";
        final String actual = titleTextView.getText().toString();
        assertEquals("titleTextView contains wrong text", expected, actual);
    }
/*
    public void testIrmeAhoraSwitch_text() {
        final String actual = irmeAhoraSwitch.getText().toString();
        assertEquals("irmeAhoraSwitch isn't empty", "", actual);
    }

    public void testIrmeAhoraSwitch_isNotChecked() {
        final boolean actual = irmeAhoraSwitch.isChecked();
        assertEquals("irmeAhoraSwitch is checked", false, actual);
    }
*/
}
