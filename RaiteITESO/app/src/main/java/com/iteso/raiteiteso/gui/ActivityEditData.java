package com.iteso.raiteiteso.gui;

import android.app.Activity;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.TimePicker;

import com.iteso.raiteiteso.beans.UserWCar;
import com.iteso.raiteiteso.database.DatabaseHandler;
import com.iteso.raiteiteso.database.UserControl;

import java.util.ArrayList;
import java.util.Calendar;

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
    private String monday;
    private String tuesday;
    private String wednesday;
    private String thursday;
    private String friday;
    private TextView mondayHourText;
    private TextView tuesdayHourText;
    private TextView wednesdayHourText;
    private TextView thursdayHourText;
    private TextView fridayHourText;
    private ListView interestPointsListView;
    private AdapterInterestPoints adapterInterestPoints;
    private ArrayList<String> interestPoints;
    private UserWCar userWCar;

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

        interestPoints = userWCar.getInterestPoints();

        mondayEditText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mondayEditText.setBackgroundColor(getResources().getColor(R.color.gray));
                tuesdayEditText.setBackgroundColor(getResources().getColor(R.color.black));
                wednesdayEditText.setBackgroundColor(getResources().getColor(R.color.black));
                thursdayEditText.setBackgroundColor(getResources().getColor(R.color.black));
                fridayEditText.setBackgroundColor(getResources().getColor(R.color.black));
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
                mondayEditText.setBackgroundColor(getResources().getColor(R.color.black));
                tuesdayEditText.setBackgroundColor(getResources().getColor(R.color.gray));
                wednesdayEditText.setBackgroundColor(getResources().getColor(R.color.black));
                thursdayEditText.setBackgroundColor(getResources().getColor(R.color.black));
                fridayEditText.setBackgroundColor(getResources().getColor(R.color.black));
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
                mondayEditText.setBackgroundColor(getResources().getColor(R.color.black));
                tuesdayEditText.setBackgroundColor(getResources().getColor(R.color.black));
                wednesdayEditText.setBackgroundColor(getResources().getColor(R.color.gray));
                thursdayEditText.setBackgroundColor(getResources().getColor(R.color.black));
                fridayEditText.setBackgroundColor(getResources().getColor(R.color.black));
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
                mondayEditText.setBackgroundColor(getResources().getColor(R.color.black));
                tuesdayEditText.setBackgroundColor(getResources().getColor(R.color.black));
                wednesdayEditText.setBackgroundColor(getResources().getColor(R.color.black));
                thursdayEditText.setBackgroundColor(getResources().getColor(R.color.gray));
                fridayEditText.setBackgroundColor(getResources().getColor(R.color.black));
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
                mondayEditText.setBackgroundColor(getResources().getColor(R.color.black));
                tuesdayEditText.setBackgroundColor(getResources().getColor(R.color.black));
                wednesdayEditText.setBackgroundColor(getResources().getColor(R.color.black));
                thursdayEditText.setBackgroundColor(getResources().getColor(R.color.black));
                fridayEditText.setBackgroundColor(getResources().getColor(R.color.gray));
                mondayHourText.setVisibility(View.GONE);
                tuesdayHourText.setVisibility(View.GONE);
                wednesdayHourText.setVisibility(View.GONE);
                thursdayHourText.setVisibility(View.GONE);
                fridayHourText.setVisibility(View.VISIBLE);
            }
        });

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
                        mondayHourText.setText(selectedHour + " : " + selectedMinute);
                    }
                }, hour, minute, false);
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
                        tuesdayHourText.setText(selectedHour + " : " + selectedMinute);
                    }
                }, hour, minute, false);
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
                        wednesdayHourText.setText(selectedHour + " : " + selectedMinute);
                    }
                }, hour, minute, false);
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
                        thursdayHourText.setText(selectedHour + " : " + selectedMinute);
                    }
                }, hour, minute, false);
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
                        fridayHourText.setText(selectedHour + " : " + selectedMinute);
                    }
                }, hour, minute, false);
                mTimePicker.setTitle("Seleccionar hora");
                mTimePicker.show();

            }
        });

    }
}
