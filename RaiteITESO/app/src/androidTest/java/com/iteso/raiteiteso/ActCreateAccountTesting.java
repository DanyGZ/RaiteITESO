package com.iteso.raiteiteso;

import android.test.ActivityInstrumentationTestCase2;
import android.widget.Button;
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
    private Button actMondayEditText;
    private Button actTuesdayEditText;
    private Button actWednesdayEditText;
    private Button actThursdayEditText;
    private Button actFridayEditText;
    private Button actCreateAccount;
    private Button actFirstContainerNext;
    private Button actBack;

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
        actMondayEditText = (Button) activityCreateAccount.findViewById(R.id.activity_create_account_monday);
        actTuesdayEditText = (Button) activityCreateAccount.findViewById(R.id.activity_create_account_tuesday);
        actWednesdayEditText = (Button) activityCreateAccount.findViewById(R.id.activity_create_account_wednesday);
        actThursdayEditText = (Button) activityCreateAccount.findViewById(R.id.activity_create_account_thursday);
        actFridayEditText = (Button) activityCreateAccount.findViewById(R.id.activity_create_account_friday);
        actCreateAccount = (Button) activityCreateAccount.findViewById(R.id.activity_create_account_create);
        actFirstContainerNext = (Button) activityCreateAccount.findViewById(R.id.activity_create_account_next);
        actBack = (Button) activityCreateAccount.findViewById(R.id.activity_create_account_back);
    }

    public void testPreconditions() {
        assertNotNull("activityCreateAccount is null", activityCreateAccount);
        assertNotNull("actMondayHourText is null", actMondayHourText);
        assertNotNull("actTuesdayHourText is null", actTuesdayHourText);
        assertNotNull("actWednesdayHourText is null", actWednesdayHourText);
        assertNotNull("actThursdayHourText is null", actThursdayHourText);
        assertNotNull("actFridayHourText is null",actFridayHourText);
        assertNotNull("actMondayEditText is null", actMondayEditText);
        assertNotNull("actTuesdayEditText is null", actTuesdayEditText);
        assertNotNull("actWednesday is null", actWednesdayEditText);
        assertNotNull("actThursday is null", actThursdayEditText);
        assertNotNull("actFriday is null", actFridayEditText);
        assertNotNull("actCreateAccount is null", actCreateAccount);
        assertNotNull("actFirstContainerNext", actFirstContainerNext);
        assertNotNull("actBack is null", actBack);
    }

    public void testTextViews_labelText() {
        final String expectedText = activityCreateAccount.getString(R.string.Presione_para_seleccionar_la_hora);

        final String actualLunText = actMondayHourText.getText().toString();
        assertEquals("actMondayHourText contains wrong text!", expectedText, actualLunText);

        final String actualMarText = actTuesdayHourText.getText().toString();
        assertEquals("actTuesdayHourText contains wrong text!", expectedText, actualMarText);

        final String actualMierText = actWednesdayHourText.getText().toString();
        assertEquals("actWednesdayHourText contains wrong text!", expectedText, actualMierText);

        final String actualJuevText = actThursdayHourText.getText().toString();
        assertEquals("actThursdayHourText contains wrong text!", expectedText, actualJuevText);

        final String actualVierText = actFridayHourText.getText().toString();
        assertEquals("actFridayHourText contains wrong text!", expectedText, actualVierText);
    }

    public void testButtons_labelText() {
        final String expectedButtonMondayText = "Lun";
        final String actualButtonMondayText = actMondayEditText.getText().toString();
        assertEquals("actMondayEditText contains wrong text!", expectedButtonMondayText,actualButtonMondayText);

        final String expectedButtonTuesdayText = "Mar";
        final String actualButtonTuesdayText = actTuesdayEditText.getText().toString();
        assertEquals("actTuesdayEditText contains wrong text!", expectedButtonTuesdayText,actualButtonTuesdayText);

        final String expectedButtonThursdayText = "Jue";
        final String actualButtonThursdayText = actThursdayEditText.getText().toString();
        assertEquals("actWednesdayEditText contains wrong text!", expectedButtonThursdayText, actualButtonThursdayText);

        final String expectedButtonWednesdayText = "Mié";
        final String actualButtonWednesdayText = actWednesdayEditText.getText().toString();
        assertEquals("actThursdayEditText contains wrong text!", expectedButtonWednesdayText, actualButtonWednesdayText);

        final String expectedButtonFridayText = "Vier";
        final String actualButtonFridayText = actFridayEditText.getText().toString();
        assertEquals("actFridayEdiText contains wrong text!", expectedButtonFridayText, actualButtonFridayText);

        final String expectedButtonCreateAccount = "Crear";
        final String actualButtonCreateAccount = actCreateAccount.getText().toString();
        assertEquals("actCreateAccount contains wrong text!", expectedButtonCreateAccount,actualButtonCreateAccount);

        final String expectedButtonBack = "Atrás";
        final String actualButtonBack = actBack.getText().toString();
        assertEquals("actBack contains wrong text!", expectedButtonBack, actualButtonBack);
    }
}
