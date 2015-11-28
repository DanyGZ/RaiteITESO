package com.iteso.raiteiteso;

import android.test.ActivityInstrumentationTestCase2;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.iteso.raiteiteso.gui.ActivityRaiteDetail;
import com.iteso.raiteiteso.gui.R;

/**
 * Created by giovanni on 28/11/2015.
 */
public class ActRaiteDetailTest extends ActivityInstrumentationTestCase2<ActivityRaiteDetail> {
    private ActivityRaiteDetail activityRaiteDetail;
    private TextView nameTextView;
//    private TextView noRaiteTextView;
    private ImageView logoImageView;
    private Button pedirRideButton;

    public ActRaiteDetailTest() {
        super(ActivityRaiteDetail.class);
    }

    @Override
    protected void setUp() throws Exception{
        super.setUp();
        setActivityInitialTouchMode(true);

        activityRaiteDetail = getActivity();
        nameTextView = (TextView) activityRaiteDetail.findViewById(R.id.activity_raite_detail_name);
//        noRaiteTextView = (TextView) activityRaiteDetail.findViewById(R.id.activity_raite_detail_no_raite_detail);
        logoImageView = (ImageView) activityRaiteDetail.findViewById(R.id.activity_raite_details_image);
        pedirRideButton = (Button) activityRaiteDetail.findViewById(R.id.activity_raite_detail_buttom_raite);
    }

    public void testPreconditions() {
        assertNotNull("activityRaiteDetail is null", activityRaiteDetail);
        assertNotNull("nameTextView is null", nameTextView);
 //       assertNotNull("noRaiteTextView is null", noRaiteTextView);
        assertNotNull("logoImageView is null", logoImageView);
        assertNotNull("pedirRideButton is null", pedirRideButton);
    }

    public void testNameTextView_text() {
        final String expected = "Wey del raite";
        final String actual = nameTextView.getText().toString();
        assertEquals("nameTextView contains wrong text", expected, actual);
    }
/*
    public void testNoRaiteTextView_text() {
        final String expected = "No hay detalles Disponibles";
        final String actual = noRaiteTextView.getText().toString();
        assertEquals("noRaiteTextView contains wrong text", expected, actual);
    }
*/
    public void testPedirRideButton_text() {
        final String expected = "Pedir Raite";
        final String actual = pedirRideButton.getText().toString();
        assertEquals("pedirRaiteButton contains wrong text", expected, actual);
    }
}
