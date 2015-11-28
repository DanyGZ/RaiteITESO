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
    private EditText messageConfirmEditText;
    private TextView messageSolicitudTextView;
    private TextView pendingCarRequestTextView;
    private TextView messageAvisoTextView;
    private Button confirmButton;
    private Button cancelButton;
    private Switch visibleSwitch;
    private ImageView logoImageView;
    private ListView solicitudesListView;

    public ActMainWithCarTest () {
        super(ActivityMainWithCar.class);
    }

    @Override
    protected void setUp() throws Exception{
        super.setUp();
        setActivityInitialTouchMode(true);

        activityMainWithCar = getActivity();
        messageSolicitudTextView = (TextView) activityMainWithCar.findViewById(R.id.activity_main_with_car_message_solicitud);
        /*
        messageConfirmEditText = (EditText) activityMainWithCar.findViewById(R.id.activity_main_with_car_message_confirm);
        pendingCarRequestTextView = (TextView) activityMainWithCar.findViewById(R.id.activity_main_with_car_pending_ride_request);
        messageAvisoTextView = (TextView) activityMainWithCar.findViewById(R.id.activity_main_with_car_message_aviso);
        confirmButton = (Button) activityMainWithCar.findViewById(R.id.activity_main_with_car_confirm_button);
        cancelButton = (Button) activityMainWithCar.findViewById(R.id.activity_main_with_car_cancel_button);
        visibleSwitch = (Switch) activityMainWithCar.findViewById(R.id.activity_main_with_car_visible);
        logoImageView = (ImageView) activityMainWithCar.findViewById(R.id.activity_main_with_car_image_signo);
        solicitudesListView = (ListView) activityMainWithCar.findViewById(R.id.activity_main_with_car_points_interest);
        */
    }

    public void testPreconditions() {
        assertNotNull("activityMainWithCar is null", activityMainWithCar);
        assertNotNull("messageSolicitudTextView is null", messageSolicitudTextView);
    //   assertNotNull("messageConfirmEditText is null", messageConfirmEditText);
    //    assertNotNull("pendingCarRequestTextView is null", pendingCarRequestTextView);
    //    assertNotNull("messageAvisoTextView is null", messageAvisoTextView);
    //    assertNotNull("confirmButton is null", confirmButton);
    //    assertNotNull("cancelButton is null", cancelButton);
    //    assertNotNull("visibleSwitch is null", visibleSwitch);
    //    assertNotNull("logoImageView is null", logoImageView);
    //    assertNotNull("solicitudesListView is null", solicitudesListView);
    }
/*
    public void testMessageConfirmEditText_hint() {
        final String expected = "¿Donde nos vemos?";
        final String actual = messageConfirmEditText.getHint().toString();
        assertEquals("messageConfirmEditText contains wrong hint", expected, actual);
    }

    public void testMessageConfirmEditText_emptyText() {
        final String actual = messageAvisoTextView.getText().toString();
        assertEquals("messageConfirmEditText isn't empty", "", actual);
    }

    public void testMessageSolicitudTextView_text() {
        final String expected = "Solicitudes de Raite";
        final String actual = messageSolicitudTextView.getText().toString();
        assertEquals("messageSolicitudTextView contains wrong text", expected, actual);
    }

    public void testMessageAvisoTextView_text() {
        final String expected = "Mensaje de Aviso:";
        final String actual = messageAvisoTextView.getText().toString();
        assertEquals("messageAvisoTextView contains wrong text", expected, actual);
    }

    public void testPendingCarRequestTextView_text() {
        final String expected = "No tienes solicitudes de raite pendientes";
        final String actual = pendingCarRequestTextView.getText().toString();
        assertEquals("pendingCarRequestTextView contains wrong text", expected, actual);
    }

    public void testConfirmButton_text() {
        final String expected = "Confirmar";
        final String actual = confirmButton.getText().toString();
        assertEquals("confirmButton contains wrong text", expected, actual);
    }

    public void testCancelButton_text() {
        final String expected = "Cancelar";
        final String actual = cancelButton.getText().toString();
        assertEquals("cancelButton contains wrong text", expected, actual);
    }

    public void testVisibleSwitch_empty() {
        final String actual = visibleSwitch.getText().toString();
        assertEquals("visibleSwitch isn't emppty", "", actual);
    }
*/
}
