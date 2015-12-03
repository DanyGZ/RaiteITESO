package com.iteso.raiteiteso;

import android.content.Intent;
import android.test.ActivityInstrumentationTestCase2;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.iteso.raiteiteso.gui.ActivityLogin;
import com.iteso.raiteiteso.gui.R;

/**
 * Created by giovanni on 27/11/2015.
 */
public class ActLoginTest extends ActivityInstrumentationTestCase2<ActivityLogin>{
    private ActivityLogin activityLogin;
    private TextView titleTextView;
    private Button logInButton;
    private Button signUpButton;
    private EditText userEditText;
    private EditText passwordEditText;
    private ImageView logoImageView;

    private Intent signLaunchIntent;

    public ActLoginTest() {
        super(ActivityLogin.class);
    }

    @Override
    protected void setUp() throws Exception{
        super.setUp();
        setActivityInitialTouchMode(true);

        signLaunchIntent = new Intent(getInstrumentation().getTargetContext(),ActivityLogin.class);

        activityLogin = getActivity();
        titleTextView = (TextView) activityLogin.findViewById(R.id.activity_login_title);
        logInButton = (Button) activityLogin.findViewById(R.id.activity_login_login);
        signUpButton = (Button) activityLogin.findViewById(R.id.activity_login_create);
        userEditText = (EditText) activityLogin.findViewById(R.id.activity_login_user);
        passwordEditText = (EditText) activityLogin.findViewById(R.id.activity_login_password);
        logoImageView = (ImageView) activityLogin.findViewById(R.id.activity_login_logo);
    }

    public void testPreconditions() {
        assertNotNull("activityLogin is null", activityLogin);
        assertNotNull("titleTextView is null", titleTextView);
        assertNotNull("logInButton is null", logInButton);
        assertNotNull("signUpButton is null", signUpButton);
        assertNotNull("userEditText is null", userEditText);
        assertNotNull("passwordEditText is null", passwordEditText);
        assertNotNull("logoImageView is null", logoImageView);
    }

    public void testTitleTextView_text() {
        final String expected = "Ride ITESO";
        final String actual = titleTextView.getText().toString();
        assertEquals("titleTextView contains wrong text", expected, actual);
    }

    public void testLogInButton_labelText() {
        final String expectedLoginButtonText = "Log In";
        final String actualLoginButtonText = logInButton.getText().toString();
        assertEquals("logInButton contains wrong text", expectedLoginButtonText, actualLoginButtonText);
    }

    public void testSignUpButton_labelText() {
        final String expectedSignUpButtonText = "Sign Up";
        final String actualSignUpButtonText = signUpButton.getText().toString();
        assertEquals("signUpButton contains wrong text", expectedSignUpButtonText, actualSignUpButtonText);
    }
}
