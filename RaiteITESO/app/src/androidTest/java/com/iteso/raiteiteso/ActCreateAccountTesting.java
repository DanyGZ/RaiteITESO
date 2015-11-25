package com.iteso.raiteiteso;

import android.test.ActivityInstrumentationTestCase2;
import android.widget.TextView;

import com.iteso.raiteiteso.gui.ActivityCreateAccount;
import com.iteso.raiteiteso.gui.R;

public class ActCreateAccountTesting extends ActivityInstrumentationTestCase2<ActivityCreateAccount> {
    private ActivityCreateAccount activityCreateAccount;
    private TextView actMondayHourText;
    private TextView actTuesdayHourText;
    private TextView actWednesdayHourText;
    private TextView actThursdayHourText;
    private TextView actFridayHourText;

    public ActCreateAccountTesting() { super(ActivityCreateAccount.class); }

    @Override
    protected void setUp() throws Exception {
        super.setUp();

        activityCreateAccount = getActivity();
        actMondayHourText = (TextView) activityCreateAccount.findViewById(R.id.activity_create_account_monday_hour);
        actTuesdayHourText = (TextView) activityCreateAccount.findViewById(R.id.activity_create_account_tuesday_hour);
        actWednesdayHourText = (TextView) activityCreateAccount.findViewById(R.id.activity_create_account_wednesday_hour);
        actThursdayHourText = (TextView) activityCreateAccount.findViewById(R.id.activity_create_account_thursday_hour);
        actFridayHourText = (TextView) activityCreateAccount.findViewById(R.id.activity_create_account_friday_hour);
    }

    public void testPreconditions() {
        assertNotNull("activityCreateAccount is null", activityCreateAccount);
        assertNotNull("actMondayHourText is null", actMondayHourText);
        assertNotNull("actTuesdayHourText is null", actTuesdayHourText);
        assertNotNull("actWednesdayHourText is null", actWednesdayHourText);
        assertNotNull("actThursdayHourText is null", actThursdayHourText);
        assertNotNull("actFridayHourText is null",actFridayHourText);
    }

    public void testTextViews_labelText() {
        final String expectedText = activityCreateAccount.getString(R.string.Presione_para_seleccionar_la_hora);

        final String actualLunText = actMondayHourText.getText().toString();
        assertEquals("actMondayHourText contains wrong text!", expectedText, actualLunText);

        final String actualMarText = actTuesdayHourText.getText().toString();
        assertEquals("actTuesdayHourText contains wrong text!", expectedText,actualMarText);

        final String actualMierText = actWednesdayHourText.getText().toString();
        assertEquals("actWednesdayHourText contains wrong text!", expectedText, actualMierText);

        final String actualJuevText = actThursdayHourText.getText().toString();
        assertEquals("actThursdayHourText contains wrong text!", expectedText, actualJuevText);

        final String actualVierText = actFridayHourText.getText().toString();
        assertEquals("actFridayHourText contains wrong text!", expectedText, actualVierText);
    }
}
