package com.iteso.raiteiteso.gui;

import android.app.Activity;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.TimePicker;

import com.iteso.raiteiteso.beans.UserWCar;
import com.iteso.raiteiteso.beans.UserWOCar;
import com.iteso.raiteiteso.database.DatabaseHandler;
import com.iteso.raiteiteso.database.UserControl;

import java.util.ArrayList;
import java.util.Calendar;

import static android.view.View.*;

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
    private TextView capacityText;
    private TextView carText;
    private TextView colorText;
    private EditText capacityEditText;
    private EditText colorEditText;
    private EditText carEditText;
    private ListView interestPointsListView;
    private AdapterInterestPoints adapterInterestPoints;
    private ArrayList<String> interestPoints;
    private UserWCar userWCar;
    private String car;
    private String capacity;
    private String color;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_data);

        dh = DatabaseHandler.getInstance(this);
        userControl = new UserControl(this);
        userWCar = new UserWCar();

        mondayEditText = (Button) findViewById(R.id.activity_edit_data_monday);
        tuesdayEditText = (Button) findViewById(R.id.activity_edit_data_tuesday);
        wednesdayEditText = (Button) findViewById(R.id.activity_edit_data_wednesday);
        thursdayEditText = (Button) findViewById(R.id.activity_edit_data_thursday);
        fridayEditText = (Button) findViewById(R.id.activity_edit_data_friday);
        aceptar = (Button) findViewById(R.id.activity_edit_data_botton);
        mondayHourText = (TextView) findViewById(R.id.activity_edit_data_monday_hour);
        tuesdayHourText = (TextView) findViewById(R.id.activity_edit_data_tuesday_hour);
        wednesdayHourText = (TextView) findViewById(R.id.activity_edit_data_wednesday_hour);
        thursdayHourText = (TextView) findViewById(R.id.activity_edit_data_thursday_hour);
        fridayHourText = (TextView) findViewById(R.id.activity_edit_data_friday_hour);
        interestPointsListView = (ListView) findViewById(R.id.activity_edit_data_points_interes);
        carEditText = (EditText) findViewById(R.id.activity_edit_data_car_text);
        capacityEditText = (EditText) findViewById(R.id.activity_edit_data_capacity_text);
        colorEditText = (EditText) findViewById(R.id.activity_edit_data_color_text);
        carText = (TextView) findViewById(R.id.activity_edit_data_car);
        capacityText = (TextView) findViewById(R.id.activity_edit_data_capacity);
        colorText = (TextView) findViewById(R.id.activity_edit_data_color);

        interestPoints = userWCar.getInterestPoints();

        carEditText.setText(userWCar.getCar());
        capacityEditText.setText(userWCar.getCarCapacity());
        colorEditText.setText(userWCar.getCarColor());

        interestPoints = new ArrayList<>();

        mondayEditText.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                mondayEditText.setBackgroundColor(getResources().getColor(R.color.gray));
                tuesdayEditText.setBackgroundColor(getResources().getColor(R.color.black));
                wednesdayEditText.setBackgroundColor(getResources().getColor(R.color.black));
                thursdayEditText.setBackgroundColor(getResources().getColor(R.color.black));
                fridayEditText.setBackgroundColor(getResources().getColor(R.color.black));
                mondayHourText.setVisibility(VISIBLE);
                tuesdayHourText.setVisibility(GONE);
                wednesdayHourText.setVisibility(GONE);
                thursdayHourText.setVisibility(GONE);
                fridayHourText.setVisibility(GONE);
                mondayHourText.setText(userWCar.getMondayHour());
            }
        });

        tuesdayEditText.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                mondayEditText.setBackgroundColor(getResources().getColor(R.color.black));
                tuesdayEditText.setBackgroundColor(getResources().getColor(R.color.gray));
                wednesdayEditText.setBackgroundColor(getResources().getColor(R.color.black));
                thursdayEditText.setBackgroundColor(getResources().getColor(R.color.black));
                fridayEditText.setBackgroundColor(getResources().getColor(R.color.black));
                mondayHourText.setVisibility(GONE);
                tuesdayHourText.setVisibility(VISIBLE);
                wednesdayHourText.setVisibility(GONE);
                thursdayHourText.setVisibility(GONE);
                fridayHourText.setVisibility(GONE);
                tuesdayHourText.setText(userWCar.getTuesdayHour());
            }
        });

        wednesdayEditText.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                mondayEditText.setBackgroundColor(getResources().getColor(R.color.black));
                tuesdayEditText.setBackgroundColor(getResources().getColor(R.color.black));
                wednesdayEditText.setBackgroundColor(getResources().getColor(R.color.gray));
                thursdayEditText.setBackgroundColor(getResources().getColor(R.color.black));
                fridayEditText.setBackgroundColor(getResources().getColor(R.color.black));
                mondayHourText.setVisibility(GONE);
                tuesdayHourText.setVisibility(GONE);
                wednesdayHourText.setVisibility(VISIBLE);
                thursdayHourText.setVisibility(GONE);
                fridayHourText.setVisibility(GONE);
                wednesdayHourText.setText(userWCar.getWednesdayHour());
            }
        });

        thursdayEditText.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                mondayEditText.setBackgroundColor(getResources().getColor(R.color.black));
                tuesdayEditText.setBackgroundColor(getResources().getColor(R.color.black));
                wednesdayEditText.setBackgroundColor(getResources().getColor(R.color.black));
                thursdayEditText.setBackgroundColor(getResources().getColor(R.color.gray));
                fridayEditText.setBackgroundColor(getResources().getColor(R.color.black));
                mondayHourText.setVisibility(GONE);
                tuesdayHourText.setVisibility(GONE);
                wednesdayHourText.setVisibility(GONE);
                thursdayHourText.setVisibility(VISIBLE);
                thursdayHourText.setText(userWCar.getThursdayHour());
                fridayHourText.setVisibility(GONE);
            }
        });

        fridayEditText.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                mondayEditText.setBackgroundColor(getResources().getColor(R.color.black));
                tuesdayEditText.setBackgroundColor(getResources().getColor(R.color.black));
                wednesdayEditText.setBackgroundColor(getResources().getColor(R.color.black));
                thursdayEditText.setBackgroundColor(getResources().getColor(R.color.black));
                fridayEditText.setBackgroundColor(getResources().getColor(R.color.gray));
                mondayHourText.setVisibility(GONE);
                tuesdayHourText.setVisibility(GONE);
                wednesdayHourText.setVisibility(GONE);
                thursdayHourText.setVisibility(GONE);
                fridayHourText.setVisibility(VISIBLE);
                fridayHourText.setText(userWCar.getFridayHour());
            }
        });

        mondayHourText.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar mcurrentTime = Calendar.getInstance();
                int hour = mcurrentTime.get(Calendar.HOUR_OF_DAY);
                final int minute = mcurrentTime.get(Calendar.MINUTE);
                final TimePickerDialog mTimePicker;
                mTimePicker = new TimePickerDialog(ActivityEditData.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
                        mondayHourText.setText(selectedHour + " : " + selectedMinute);
                    }
                }, hour, minute, false);
                mTimePicker.setTitle("Seleccionar hora");
                mTimePicker.show();
            }
        });

        tuesdayHourText.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar mcurrentTime = Calendar.getInstance();
                int hour = mcurrentTime.get(Calendar.HOUR_OF_DAY);
                final int minute = mcurrentTime.get(Calendar.MINUTE);
                final TimePickerDialog mTimePicker;
                mTimePicker = new TimePickerDialog(ActivityEditData.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
                        tuesdayHourText.setText(selectedHour + " : " + selectedMinute);
                    }
                }, hour, minute, false);
                mTimePicker.setTitle("Seleccionar hora");
                mTimePicker.show();

            }
        });

        wednesdayHourText.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar mcurrentTime = Calendar.getInstance();
                int hour = mcurrentTime.get(Calendar.HOUR_OF_DAY);
                final int minute = mcurrentTime.get(Calendar.MINUTE);
                final TimePickerDialog mTimePicker;
                mTimePicker = new TimePickerDialog(ActivityEditData.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
                        wednesdayHourText.setText(selectedHour + " : " + selectedMinute);
                    }
                }, hour, minute, false);
                mTimePicker.setTitle("Seleccionar hora");
                mTimePicker.show();

            }
        });

        thursdayHourText.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar mcurrentTime = Calendar.getInstance();
                int hour = mcurrentTime.get(Calendar.HOUR_OF_DAY);
                final int minute = mcurrentTime.get(Calendar.MINUTE);
                final TimePickerDialog mTimePicker;
                mTimePicker = new TimePickerDialog(ActivityEditData.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
                        thursdayHourText.setText(selectedHour + " : " + selectedMinute);
                    }
                }, hour, minute, false);
                mTimePicker.setTitle("Seleccionar hora");
                mTimePicker.show();

            }
        });

        fridayHourText.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar mcurrentTime = Calendar.getInstance();
                int hour = mcurrentTime.get(Calendar.HOUR_OF_DAY);
                final int minute = mcurrentTime.get(Calendar.MINUTE);
                final TimePickerDialog mTimePicker;
                mTimePicker = new TimePickerDialog(ActivityEditData.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
                        fridayHourText.setText(selectedHour + " : " + selectedMinute);
                    }
                }, hour, minute, false);
                mTimePicker.setTitle("Seleccionar hora");
                mTimePicker.show();

            }
        });

        if(userWCar.getCar()!= null){
            carEditText.setVisibility(VISIBLE);
            capacityEditText.setVisibility(VISIBLE);
            colorEditText.setVisibility(VISIBLE);
            carText.setVisibility(VISIBLE);
            capacityText.setVisibility(VISIBLE);
            colorText.setVisibility(VISIBLE);

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
                userWCar.setMondayHour(mondayHourText.getText().toString());
                userWCar.setTuesdayHour(tuesdayHourText.getText().toString());
                userWCar.setWednesdayHour(wednesdayHourText.getText().toString());
                userWCar.setThursdayHour(thursdayHourText.getText().toString());
                userWCar.setFridayHour(fridayHourText.getText().toString());

                checkedPlaces = adapterInterestPoints.getCheckedPoints();
                checkedPlacesList = new ArrayList<>();
                for(int i=0; i<checkedPlaces.size(); i++){
                    if(checkedPlaces.get(i)){
                        checkedPlacesList.add(interestPoints.get(i));
                    }
                }
                userWCar.setInterestPoints(checkedPlacesList);

                adapterInterestPoints = new AdapterInterestPoints(ActivityEditData.this, checkedPlacesList);
                interestPointsListView.setAdapter(adapterInterestPoints);

                if(userWCar.getCar()!= null) {
                    userWCar.setCar(car);
                    userWCar.setCarCapacity(Integer.parseInt(capacity));
                    userWCar.setCarColor(color);
                }
            }
        });

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
