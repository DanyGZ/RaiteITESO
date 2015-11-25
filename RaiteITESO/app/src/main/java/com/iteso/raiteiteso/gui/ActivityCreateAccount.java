package com.iteso.raiteiteso.gui;

import android.app.Activity;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.iteso.raiteiteso.beans.UserWOCar;
import com.iteso.raiteiteso.database.DatabaseHandler;
import com.iteso.raiteiteso.database.UserControl;

import java.util.ArrayList;
import java.util.Calendar;

/**
 * Created by Daniel on 25/10/2015.
 */
public class ActivityCreateAccount extends Activity {
    private EditText userNameEditText;
    private EditText nameEditText;
    private EditText lastNameeditText;
    private EditText passwordEditText;
    private EditText repeatEditText;
    private Button mondayEditText;
    private Button tuesdayEditText;
    private Button wednesdayEditText;
    private Button thursdayEditText;
    private Button  fridayEditText;
    private EditText carEditText;
    private EditText carColorEditText;
    private EditText carCapacityEditText;
    private ToggleButton carToggle;
    private ToggleButton availableToggle;
    private Button createActount;
    private LinearLayout carLayout;
    private DatabaseHandler dh;
    private UserControl userControl;
    private Button firstContainerNext;
    private String userName;
    private String lastName;
    private String name;
    private String password;
    private String repeatedPassword;
    private String monday;
    private String tuesday;
    private String wednesday;
    private String thursday;
    private String friday;
    private String car;
    private String carColor;
    private String carCapacity;
    private LinearLayout firstContainer;
    private LinearLayout secondContainer;
    private Button back;
    private TextView mondayHourText;
    private TextView tuesdayHourText;
    private TextView wednesdayHourText;
    private TextView thursdayHourText;
    private TextView fridayHourText;
    private ListView interestPointsListView;
    private AdapterInterestPoints adapterInterestPoints;
    private ArrayList<String> interestPoints;
    private UserWOCar user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);

        dh = DatabaseHandler.getInstance(this);
        userControl = new UserControl(this);

        userNameEditText = (EditText) findViewById(R.id.activity_create_account_userName);
        nameEditText = (EditText) findViewById(R.id.activity_create_account_name);
        passwordEditText = (EditText) findViewById(R.id.activity_create_account_password);
        repeatEditText = (EditText) findViewById(R.id.activity_create_account_repeat_password);
        mondayEditText = (Button) findViewById(R.id.activity_create_account_monday);
        tuesdayEditText = (Button) findViewById(R.id.activity_create_account_tuesday);
        wednesdayEditText = (Button) findViewById(R.id.activity_create_account_wednesday);
        thursdayEditText = (Button) findViewById(R.id.activity_create_account_thursday);
        fridayEditText = (Button) findViewById(R.id.activity_create_account_friday);
        carEditText = (EditText) findViewById(R.id.activity_create_account_car);
        carColorEditText = (EditText) findViewById(R.id.activity_create_account_car_color);
        carCapacityEditText = (EditText) findViewById(R.id.activity_create_account_car_capacity);
        carToggle = (ToggleButton) findViewById(R.id.activity_create_account_toggle);
        availableToggle = (ToggleButton) findViewById(R.id.activity_create_account_toggle_available);
        createActount = (Button) findViewById(R.id.activity_create_account_create);
        carLayout = (LinearLayout) findViewById(R.id.activity_create_account_layout_car);
        firstContainerNext = (Button) findViewById(R.id.activity_create_account_next);
        lastNameeditText = (EditText) findViewById(R.id.activity_create_account_last_name);
        firstContainer = (LinearLayout) findViewById(R.id.activity_create_account_first_data_container);
        secondContainer = (LinearLayout) findViewById(R.id.activity_create_account_second_data_container);
        back = (Button) findViewById(R.id.activity_create_account_back);
        mondayHourText = (TextView) findViewById(R.id.activity_create_account_monday_hour);
        tuesdayHourText = (TextView) findViewById(R.id.activity_create_account_tuesday_hour);
        wednesdayHourText = (TextView) findViewById(R.id.activity_create_account_wednesday_hour);
        thursdayHourText = (TextView) findViewById(R.id.activity_create_account_thursday_hour);
        fridayHourText = (TextView) findViewById(R.id.activity_create_account_friday_hour);
        interestPointsListView = (ListView) findViewById(R.id.activity_create_account_interest_points);

        interestPoints = new ArrayList<>();
        interestPoints.add("Patria");
        interestPoints.add("Colón");
        interestPoints.add("Guadalupe");
        interestPoints.add("López Mateos");
        adapterInterestPoints = new AdapterInterestPoints(this, interestPoints);
        interestPointsListView.setAdapter(adapterInterestPoints);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                firstContainer.setVisibility(View.VISIBLE);
                secondContainer.setVisibility(View.INVISIBLE);
            }
        });

        carToggle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    carLayout.setVisibility(View.VISIBLE);
                } else {
                    carLayout.setVisibility(View.GONE);
                }
            }
        });

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
                mTimePicker = new TimePickerDialog(ActivityCreateAccount.this, new TimePickerDialog.OnTimeSetListener() {
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
                mTimePicker = new TimePickerDialog(ActivityCreateAccount.this, new TimePickerDialog.OnTimeSetListener() {
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
                mTimePicker = new TimePickerDialog(ActivityCreateAccount.this, new TimePickerDialog.OnTimeSetListener() {
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
                mTimePicker = new TimePickerDialog(ActivityCreateAccount.this, new TimePickerDialog.OnTimeSetListener() {
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
                mTimePicker = new TimePickerDialog(ActivityCreateAccount.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
                        fridayHourText.setText(selectedHour + " : " + selectedMinute);
                    }
                }, hour, minute, false);
                mTimePicker.setTitle("Seleccionar hora");
                mTimePicker.show();

            }
        });

        firstContainerNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userName = userNameEditText.getText().toString();
                name = nameEditText.getText().toString();
                lastName = lastNameeditText.getText().toString();
                password = passwordEditText.getText().toString();
                repeatedPassword = repeatEditText.getText().toString();

                if (userName.equals("") || name.equals("") || password.equals("") || repeatedPassword.equals("") ||
                        lastName.equals("")) {
                    Toast.makeText(ActivityCreateAccount.this, "Debe llenar todos los campos", Toast.LENGTH_LONG).show();
                } else {
                    if (password.equals(repeatedPassword)) {
                        if (userControl.getUserWithCarByUserName(userName, dh) == null &&
                                userControl.getUserWithOuthCarByUserName(userName, dh) == null) {
                            user = new UserWOCar();
                            user.setUserName(userName);
                            user.setName(name);
                            user.setPassword(password);
                            firstContainer.setVisibility(View.GONE);
                            secondContainer.setVisibility(View.VISIBLE);
                        } else {
                            Toast.makeText(ActivityCreateAccount.this, "Nombre de usuario ya existente", Toast.LENGTH_LONG).show();
                        }
                    } else {
                        Toast.makeText(ActivityCreateAccount.this, "Las contraseñas no coinciden", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });

        createActount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayList<Boolean> checkedPlaces;
                ArrayList<String> checkedPlacesList;

                monday = mondayHourText.getText().toString();
                tuesday = tuesdayHourText.getText().toString();
                wednesday = wednesdayHourText.getText().toString();
                thursday = thursdayHourText.getText().toString();
                friday = fridayHourText.getText().toString();
                car = carEditText.getText().toString();
                carColor = carColorEditText.getText().toString();
                carCapacity = carCapacityEditText.getText().toString();


                if(monday.equals("Presione para selecicionar la hora") || tuesday.equals("Presione para selecicionar la hora")
                        || wednesday.equals("Presione para selecicionar la hora") || thursday.equals("Presione para selecicionar la hora")
                        || friday.equals("Presione para selecicionar la hora") || (car.equals("") && carToggle.isChecked()) ||
                        (carColor.equals("") && carToggle.isChecked()) || (carCapacity.equals("") && carToggle.isChecked())){
                    Toast.makeText(ActivityCreateAccount.this, "Debe llenar todos los campos", Toast.LENGTH_LONG).show();
                }else{
                    checkedPlaces = adapterInterestPoints.getCheckedPoints();
                    checkedPlacesList = new ArrayList<>();
                    for(int i=0; i<checkedPlaces.size(); i++){
                        if(checkedPlaces.get(i)){
                            checkedPlacesList.add(interestPoints.get(i));
                        }
                    }
                    if(checkedPlacesList.size() == 0){
                        Toast.makeText(ActivityCreateAccount.this, "Debe seleccionar al menos un punto de interés", Toast.LENGTH_LONG).show();
                    }else{
                        user.setMondayHour(monday);
                        user.setTuesdayHour(tuesday);
                        user.setWednesdayHour(wednesday);
                        user.setThursdayHour(thursday);
                        user.setFridayHour(friday);
                        user.setInterestPoints(interestPoints);

                        if(carToggle.isChecked()){
                            /*user = new UserWCar(user);
                            user.setCar(car);
                            user.setCarColor(carColor);
                            user.setCarCapacity(Integer.parseInt(carCapacity));
                            user.setAvailable(availableToggle.isChecked());

                            if(userControl.addUserWithCar(user, dh) == -1){
                                Toast.makeText(ActivityCreateAccount.this, "Usuario inválido", Toast.LENGTH_LONG).show();
                            }else{
                                Intent intent = new Intent(ActivityCreateAccount.this, ActivityLogin.class);
                                startActivity(intent);
                            }*/
                        }else{
                            if(userControl.addUserWithOutCar(user, dh) == -1){
                                Toast.makeText(ActivityCreateAccount.this, "Usuario inválido", Toast.LENGTH_LONG).show();
                            }else{
                                Intent intent = new Intent(ActivityCreateAccount.this, ActivityLogin.class);
                                startActivity(intent);
                            }
                        }
                    }
                }
            }
        });
    }
}
