package com.iteso.raiteiteso.gui;

import android.app.Activity;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.iteso.raiteiteso.beans.UserWCar;
import com.iteso.raiteiteso.beans.UserWOCar;
import com.iteso.raiteiteso.database.DatabaseHandler;
import com.iteso.raiteiteso.database.UserControl;
import com.iteso.raiteiteso.utils.Constants;

import java.util.ArrayList;
import java.util.Calendar;

import static android.view.View.GONE;
import static android.view.View.OnClickListener;
import static android.view.View.VISIBLE;

/**
 * Created by Daniel on 29/10/2015.
 */
public class ActivityEditData extends Activity{
    private Button mondayEditText;
    private Button tuesdayEditText;
    private Button wednesdayEditText;
    private Button thursdayEditText;
    private Button fridayEditText;
    private Button aceptar;
    private DatabaseHandler dh;
    private UserControl userControl;
    private TextView mondayHourText;
    private TextView tuesdayHourText;
    private TextView wednesdayHourText;
    private TextView thursdayHourText;
    private TextView fridayHourText;
    private EditText capacityEditText;
    private EditText colorEditText;
    private EditText carEditText;
    private LinearLayout carLayout;
    private ListView interestPointsListView;
    private ToggleButton available;
    private AdapterInterestPoints adapterInterestPoints;
    private ArrayList<String> interestPoints;
    private UserWOCar user;
    private String car;
    private String capacity;
    private String color;
    private UserWCar userWCar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_data);

        dh = DatabaseHandler.getInstance(this);
        userControl = new UserControl(this);

        if(!getIntent().getBooleanExtra(Constants.USER_EXTRA_HAS_CAR, false)){
            user = userControl.getUserWithOuthCarByUserName(getIntent().getStringExtra(Constants.USER_EXTRA_NAME), dh);
        }else{
            user = userControl.getUserWithCarByUserName(getIntent().getStringExtra(Constants.USER_EXTRA_NAME), dh);
            userWCar = userControl.getUserWithCarByUserName(getIntent().getStringExtra(Constants.USER_EXTRA_NAME), dh);
        }

        mondayEditText = (Button) findViewById(R.id.activity_edit_data_monday);
        tuesdayEditText = (Button) findViewById(R.id.activity_edit_data_tuesday);
        wednesdayEditText = (Button) findViewById(R.id.activity_edit_data_wednesday);
        thursdayEditText = (Button) findViewById(R.id.activity_edit_data_thursday);
        fridayEditText = (Button) findViewById(R.id.activity_edit_data_friday);
        mondayHourText = (TextView) findViewById(R.id.activity_edit_data_monday_hour);
        tuesdayHourText = (TextView) findViewById(R.id.activity_edit_data_tuesday_hour);
        wednesdayHourText = (TextView) findViewById(R.id.activity_edit_data_wednesday_hour);
        thursdayHourText = (TextView) findViewById(R.id.activity_edit_data_thursday_hour);
        fridayHourText = (TextView) findViewById(R.id.activity_edit_data_friday_hour);
        interestPointsListView = (ListView) findViewById(R.id.activity_edit_data_interest_points);
        carEditText = (EditText) findViewById(R.id.activity_edit_data_car);
        capacityEditText = (EditText) findViewById(R.id.activity_edit_data_car_capacity);
        colorEditText = (EditText) findViewById(R.id.activity_edit_data_car_color);
        aceptar = (Button) findViewById(R.id.activity_edit_data_aceptar);
        carLayout = (LinearLayout) findViewById(R.id.activity_edit_data_layout_car);
        available = (ToggleButton) findViewById(R.id.activity_edit_data_toggle_available);

        Constants.fillInterestPoints();
        interestPoints = Constants.interestPoints;

        if(userWCar!= null)
            carLayout.setVisibility(View.VISIBLE);

        if(userWCar != null) {
            carEditText.setText(userWCar.getCar());
            capacityEditText.setText(String.valueOf(userWCar.getCarCapacity()));
            colorEditText.setText(userWCar.getCarColor());
            available.setChecked(userWCar.isAvailable());
        }

        mondayHourText.setText(user.getMondayHour());
        tuesdayHourText.setText(user.getTuesdayHour());
        wednesdayHourText.setText(user.getWednesdayHour());
        thursdayHourText.setText(user.getThursdayHour());
        fridayHourText.setText(user.getFridayHour());

        mondayEditText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mondayEditText.setBackgroundColor(getResources().getColor(R.color.verdeGoogle));
                tuesdayEditText.setBackgroundColor(getResources().getColor(R.color.AzulIteso));
                wednesdayEditText.setBackgroundColor(getResources().getColor(R.color.AzulIteso));
                thursdayEditText.setBackgroundColor(getResources().getColor(R.color.AzulIteso));
                fridayEditText.setBackgroundColor(getResources().getColor(R.color.AzulIteso));
                mondayHourText.setVisibility(View.VISIBLE);
                tuesdayHourText.setVisibility(View.GONE);
                wednesdayHourText.setVisibility(View.GONE);
                thursdayHourText.setVisibility(View.GONE);
                fridayHourText.setVisibility(View.GONE);
            }
        });

        tuesdayEditText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mondayEditText.setBackgroundColor(getResources().getColor(R.color.AzulIteso));
                tuesdayEditText.setBackgroundColor(getResources().getColor(R.color.verdeGoogle));
                wednesdayEditText.setBackgroundColor(getResources().getColor(R.color.AzulIteso));
                thursdayEditText.setBackgroundColor(getResources().getColor(R.color.AzulIteso));
                fridayEditText.setBackgroundColor(getResources().getColor(R.color.AzulIteso));
                mondayHourText.setVisibility(View.GONE);
                tuesdayHourText.setVisibility(View.VISIBLE);
                wednesdayHourText.setVisibility(View.GONE);
                thursdayHourText.setVisibility(View.GONE);
                fridayHourText.setVisibility(View.GONE);
            }
        });

        wednesdayEditText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mondayEditText.setBackgroundColor(getResources().getColor(R.color.AzulIteso));
                tuesdayEditText.setBackgroundColor(getResources().getColor(R.color.AzulIteso));
                wednesdayEditText.setBackgroundColor(getResources().getColor(R.color.verdeGoogle));
                thursdayEditText.setBackgroundColor(getResources().getColor(R.color.AzulIteso));
                fridayEditText.setBackgroundColor(getResources().getColor(R.color.AzulIteso));
                mondayHourText.setVisibility(View.GONE);
                tuesdayHourText.setVisibility(View.GONE);
                wednesdayHourText.setVisibility(View.VISIBLE);
                thursdayHourText.setVisibility(View.GONE);
                fridayHourText.setVisibility(View.GONE);
            }
        });

        thursdayEditText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mondayEditText.setBackgroundColor(getResources().getColor(R.color.AzulIteso));
                tuesdayEditText.setBackgroundColor(getResources().getColor(R.color.AzulIteso));
                wednesdayEditText.setBackgroundColor(getResources().getColor(R.color.AzulIteso));
                thursdayEditText.setBackgroundColor(getResources().getColor(R.color.verdeGoogle));
                fridayEditText.setBackgroundColor(getResources().getColor(R.color.AzulIteso));
                mondayHourText.setVisibility(View.GONE);
                tuesdayHourText.setVisibility(View.GONE);
                wednesdayHourText.setVisibility(View.GONE);
                thursdayHourText.setVisibility(View.VISIBLE);
                fridayHourText.setVisibility(View.GONE);
            }
        });

        fridayEditText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mondayEditText.setBackgroundColor(getResources().getColor(R.color.AzulIteso));
                tuesdayEditText.setBackgroundColor(getResources().getColor(R.color.AzulIteso));
                wednesdayEditText.setBackgroundColor(getResources().getColor(R.color.AzulIteso));
                thursdayEditText.setBackgroundColor(getResources().getColor(R.color.AzulIteso));
                fridayEditText.setBackgroundColor(getResources().getColor(R.color.verdeGoogle));
                mondayHourText.setVisibility(View.GONE);
                tuesdayHourText.setVisibility(View.GONE);
                wednesdayHourText.setVisibility(View.GONE);
                thursdayHourText.setVisibility(View.GONE);
                fridayHourText.setVisibility(View.VISIBLE);
            }
        });

        Constants.fillInterestPoints();
        adapterInterestPoints = new AdapterInterestPoints(ActivityEditData.this, Constants.interestPoints, user.getInterestPoints());
        interestPointsListView.setAdapter(adapterInterestPoints);

        mondayHourText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar mcurrentTime = Calendar.getInstance();
                int hour = mcurrentTime.get(Calendar.HOUR_OF_DAY);
                final int minute = mcurrentTime.get(Calendar.MINUTE);
                final TimePickerDialog mTimePicker;
                mTimePicker = new TimePickerDialog(ActivityEditData.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
                        String hourText = "" + selectedHour + ":";
                        if(selectedMinute < 10){
                            hourText += "0";
                        }

                        hourText += selectedMinute;
                        mondayHourText.setText(hourText);
                    }
                }, hour, minute, true);
                mTimePicker.setTitle("Seleccionar hora");
                mTimePicker.show();
            }
        });

        tuesdayHourText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar mcurrentTime = Calendar.getInstance();
                int hour = mcurrentTime.get(Calendar.HOUR_OF_DAY);
                final int minute = mcurrentTime.get(Calendar.MINUTE);
                final TimePickerDialog mTimePicker;
                mTimePicker = new TimePickerDialog(ActivityEditData.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
                        String hourText = "" + selectedHour + ":";
                        if(selectedMinute < 10){
                            hourText += "0";
                        }

                        hourText += selectedMinute;
                        tuesdayHourText.setText(hourText);
                    }
                }, hour, minute, true);
                mTimePicker.setTitle("Seleccionar hora");
                mTimePicker.show();

            }
        });

        wednesdayHourText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar mcurrentTime = Calendar.getInstance();
                int hour = mcurrentTime.get(Calendar.HOUR_OF_DAY);
                final int minute = mcurrentTime.get(Calendar.MINUTE);
                final TimePickerDialog mTimePicker;
                mTimePicker = new TimePickerDialog(ActivityEditData.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
                        String hourText = "" + selectedHour + ":";
                        if(selectedMinute < 10){
                            hourText += "0";
                        }

                        hourText += selectedMinute;
                        wednesdayHourText.setText(hourText);
                    }
                }, hour, minute, true);
                mTimePicker.setTitle("Seleccionar hora");
                mTimePicker.show();

            }
        });

        thursdayHourText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar mcurrentTime = Calendar.getInstance();
                int hour = mcurrentTime.get(Calendar.HOUR_OF_DAY);
                final int minute = mcurrentTime.get(Calendar.MINUTE);
                final TimePickerDialog mTimePicker;
                mTimePicker = new TimePickerDialog(ActivityEditData.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
                        String hourText = "" + selectedHour + ":";
                        if(selectedMinute < 10){
                            hourText += "0";
                        }

                        hourText += selectedMinute;
                        thursdayHourText.setText(hourText);
                    }
                }, hour, minute, true);
                mTimePicker.setTitle("Seleccionar hora");
                mTimePicker.show();

            }
        });

        fridayHourText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar mcurrentTime = Calendar.getInstance();
                int hour = mcurrentTime.get(Calendar.HOUR_OF_DAY);
                final int minute = mcurrentTime.get(Calendar.MINUTE);
                final TimePickerDialog mTimePicker;
                mTimePicker = new TimePickerDialog(ActivityEditData.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
                        String hourText = "" + selectedHour + ":";
                        if (selectedMinute < 10) {
                            hourText += "0";
                        }

                        hourText += selectedMinute;
                        fridayHourText.setText(hourText);
                    }
                }, hour, minute, true);
                mTimePicker.setTitle("Seleccionar hora");
                mTimePicker.show();

            }
        });


        if(userWCar != null){
            car = carEditText.getText().toString();
            capacity = capacityEditText.getText().toString();
            color = colorEditText.getText().toString();

            carEditText.setText(car);
            capacityEditText.setText(capacity);
            colorEditText.setText(color);
        }

        aceptar.setOnClickListener(new OnClickListener() {
            ArrayList<Boolean> checkedPlaces;
            ArrayList<String> checkedPlacesList;

            @Override
            public void onClick(View v) {
                boolean changeFlag = false;
                Calendar calendar = Calendar.getInstance();
                switch(calendar.get(Calendar.DAY_OF_WEEK)){
                    case Calendar.MONDAY:
                        if(!user.getMondayHour().equals(mondayHourText.getText().toString())){
                            changeFlag = true;
                        }
                        break;
                    case Calendar.TUESDAY:
                        if(!user.getTuesdayHour().equals(tuesdayHourText.getText().toString())){
                            changeFlag = true;
                        }
                        break;
                    case Calendar.WEDNESDAY:
                        if(!user.getWednesdayHour().equals(wednesdayHourText.getText().toString())){
                            changeFlag = true;
                        }
                        break;
                    case Calendar.THURSDAY:
                        if(!user.getThursdayHour().equals(thursdayHourText.getText().toString())){
                            changeFlag = true;
                        }
                        break;
                    case Calendar.FRIDAY:
                        if(!user.getFridayHour().equals(fridayHourText.getText().toString())){
                            changeFlag = true;
                        }
                        break;
                }

                user.setMondayHour(mondayHourText.getText().toString());
                user.setTuesdayHour(tuesdayHourText.getText().toString());
                user.setWednesdayHour(wednesdayHourText.getText().toString());
                user.setThursdayHour(thursdayHourText.getText().toString());
                user.setFridayHour(fridayHourText.getText().toString());

                checkedPlaces = adapterInterestPoints.getCheckedPoints();
                checkedPlacesList = new ArrayList<>();
                for(int i=0; i<checkedPlaces.size(); i++){
                    if(checkedPlaces.get(i)){
                        checkedPlacesList.add(interestPoints.get(i));
                    }
                }
                if(checkedPlacesList.size() == 0){
                    Toast.makeText(ActivityEditData.this, "Debe seleccionar al menos un punto de interés", Toast.LENGTH_LONG).show();
                }else {
                    user.setInterestPoints(checkedPlacesList);

                    if (userWCar != null) {

                        ArrayList<UserWOCar> rides = userWCar.getUserWOCars();

                        userWCar = new UserWCar(user);

                        userWCar.setUserWOCars(rides);

                        if(userWCar.isAvailable() && !available.isChecked()){
                            changeFlag = true;
                        }

                        userWCar.setCar(car);
                        userWCar.setCarCapacity(Integer.parseInt(capacity));
                        userWCar.setCarColor(color);
                        userWCar.setAvailable(available.isChecked());
                        userWCar.setInterestPoints(checkedPlacesList);

                        if(changeFlag){
                            userWCar.notifyObservers(dh, "", userControl, "");
                            userWCar.setUserWOCars(new ArrayList<UserWOCar>());
                        }

                        userControl.updateUserWithCar(dh, userWCar);
                    } else {
                        userControl.updateUsersWithOutCar(dh, user, user.getRide(), user.getMeetingPoint());
                    }
                    finish();
                }
            }
        });

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
