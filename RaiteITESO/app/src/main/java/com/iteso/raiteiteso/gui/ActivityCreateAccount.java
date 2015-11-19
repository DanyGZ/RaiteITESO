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
import android.widget.TimePicker;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.iteso.raiteiteso.beans.UserWCar;
import com.iteso.raiteiteso.beans.UserWOCar;
import com.iteso.raiteiteso.database.DatabaseHandler;
import com.iteso.raiteiteso.database.UserControl;

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
    private EditText mondayEditText;
    private EditText tuesdayEditText;
    private EditText wednesdayEditText;
    private EditText thursdayEditText;
    private EditText fridayEditText;
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
        mondayEditText = (EditText) findViewById(R.id.activity_create_account_monday);
        tuesdayEditText = (EditText) findViewById(R.id.activity_create_account_tuesday);
        wednesdayEditText = (EditText) findViewById(R.id.activity_create_account_wednesday);
        thursdayEditText = (EditText) findViewById(R.id.activity_create_account_thursday);
        fridayEditText = (EditText) findViewById(R.id.activity_create_account_friday);
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
                if(isChecked){
                    carLayout.setVisibility(View.VISIBLE);
                }else{
                    carLayout.setVisibility(View.GONE);
                }
            }
        });

        mondayEditText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar mcurrentTime = Calendar.getInstance();
                int hour = mcurrentTime.get(Calendar.HOUR_OF_DAY);
                final int minute = mcurrentTime.get(Calendar.MINUTE);
                final TimePickerDialog mTimePicker;
                mTimePicker = new TimePickerDialog(ActivityCreateAccount.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
                        mondayEditText.setText(selectedHour + " : " + selectedMinute);
                    }
                }, hour, minute, false);
                mTimePicker.setTitle("Seleccionar hora");
                mTimePicker.show();

            }
        });

        tuesdayEditText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar mcurrentTime = Calendar.getInstance();
                int hour = mcurrentTime.get(Calendar.HOUR_OF_DAY);
                final int minute = mcurrentTime.get(Calendar.MINUTE);
                final TimePickerDialog mTimePicker;
                mTimePicker = new TimePickerDialog(ActivityCreateAccount.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
                        tuesdayEditText.setText(selectedHour + " : " + selectedMinute);
                    }
                }, hour, minute, false);
                mTimePicker.setTitle("Seleccionar hora");
                mTimePicker.show();

            }
        });

        wednesdayEditText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar mcurrentTime = Calendar.getInstance();
                int hour = mcurrentTime.get(Calendar.HOUR_OF_DAY);
                final int minute = mcurrentTime.get(Calendar.MINUTE);
                final TimePickerDialog mTimePicker;
                mTimePicker = new TimePickerDialog(ActivityCreateAccount.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
                        wednesdayEditText.setText(selectedHour + " : " + selectedMinute);
                    }
                }, hour, minute, false);
                mTimePicker.setTitle("Seleccionar hora");
                mTimePicker.show();

            }
        });

        thursdayEditText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar mcurrentTime = Calendar.getInstance();
                int hour = mcurrentTime.get(Calendar.HOUR_OF_DAY);
                final int minute = mcurrentTime.get(Calendar.MINUTE);
                final TimePickerDialog mTimePicker;
                mTimePicker = new TimePickerDialog(ActivityCreateAccount.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
                        thursdayEditText.setText(selectedHour + " : " + selectedMinute);
                    }
                }, hour, minute, false);
                mTimePicker.setTitle("Seleccionar hora");
                mTimePicker.show();

            }
        });

        fridayEditText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar mcurrentTime = Calendar.getInstance();
                int hour = mcurrentTime.get(Calendar.HOUR_OF_DAY);
                final int minute = mcurrentTime.get(Calendar.MINUTE);
                final TimePickerDialog mTimePicker;
                mTimePicker = new TimePickerDialog(ActivityCreateAccount.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
                        fridayEditText.setText(selectedHour + " : " + selectedMinute);
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
                UserWCar user;

                monday = mondayEditText.getText().toString();
                tuesday = tuesdayEditText.getText().toString();
                wednesday = wednesdayEditText.getText().toString();
                thursday = thursdayEditText.getText().toString();
                friday = fridayEditText.getText().toString();
                car = carEditText.getText().toString();
                carColor = carColorEditText.getText().toString();
                carCapacity = carCapacityEditText.getText().toString();


                if(monday.equals("") || tuesday.equals("") || wednesday.equals("") || thursday.equals("") ||
                        friday.equals("") || (car.equals("") && carToggle.isChecked()) ||
                        (carColor.equals("") && carToggle.isChecked()) || (carCapacity.equals("") && carToggle.isChecked())){
                    Toast.makeText(ActivityCreateAccount.this, "Debe llenar todos los campos", Toast.LENGTH_LONG).show();
                }else{
                        user = new UserWCar();
                        user.setUserName(userName);
                        user.setName(name);
                        user.setPassword(password);
                        user.setMondayHour(monday);
                        user.setTuesdayHour(tuesday);
                        user.setWednesdayHour(wednesday);
                        user.setThursdayHour(thursday);
                        user.setFridayHour(friday);

                        if(carToggle.isChecked()){
                            user.setCar(car);
                            user.setCarColor(carColor);
                            user.setCarCapacity(Integer.parseInt(carCapacity));
                            user.setAvailable(availableToggle.isChecked());

                            if(userControl.addUserWithCar(user, dh) == -1){
                                Toast.makeText(ActivityCreateAccount.this, "Usuario inválido", Toast.LENGTH_LONG).show();
                            }else{
                                Intent intent = new Intent(ActivityCreateAccount.this, ActivityLogin.class);
                                startActivity(intent);
                            }
                        }else{
                            if(userControl.addUserWithOutCar((UserWOCar)user, dh) == -1){
                                Toast.makeText(ActivityCreateAccount.this, "Usuario inválido", Toast.LENGTH_LONG).show();
                            }else{
                                Intent intent = new Intent(ActivityCreateAccount.this, ActivityLogin.class);
                                startActivity(intent);
                            }
                        }

                }
            }
        });
    }
}
