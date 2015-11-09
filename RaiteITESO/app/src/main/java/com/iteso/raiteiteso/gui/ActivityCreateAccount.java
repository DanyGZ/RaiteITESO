package com.iteso.raiteiteso.gui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.iteso.raiteiteso.beans.UserWCar;
import com.iteso.raiteiteso.beans.UserWOCar;
import com.iteso.raiteiteso.database.DatabaseHandler;
import com.iteso.raiteiteso.database.UserControl;

/**
 * Created by Daniel on 25/10/2015.
 */
public class ActivityCreateAccount extends Activity {
    private EditText userNameEditText;
    private EditText nameEditText;
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

        createActount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UserWCar user;

                String userName = userNameEditText.getText().toString();
                String name = nameEditText.getText().toString();
                String password = passwordEditText.getText().toString();
                String repeatedPassword = repeatEditText.getText().toString();
                String monday = mondayEditText.getText().toString();
                String tuesday = tuesdayEditText.getText().toString();
                String wednesday = wednesdayEditText.getText().toString();
                String thursday = thursdayEditText.getText().toString();
                String friday = fridayEditText.getText().toString();
                String car = carEditText.getText().toString();
                String carColor = carColorEditText.getText().toString();
                String carCapacity = carCapacityEditText.getText().toString();


                if(userName.equals("") || name.equals("") || password.equals("") || repeatedPassword.equals("") ||
                        monday.equals("") || tuesday.equals("") || wednesday.equals("") || thursday.equals("") ||
                        friday.equals("") || (car.equals("") && carToggle.isChecked()) ||
                        (carColor.equals("") && carToggle.isChecked()) || (carCapacity.equals("") && carToggle.isChecked())){
                    Toast.makeText(ActivityCreateAccount.this, "Debe llenar todos los campos", Toast.LENGTH_LONG).show();
                }else{
                    if(password.equals(repeatedPassword)){
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

                    }else{
                        Toast.makeText(ActivityCreateAccount.this, "Las contraseñas no coinciden", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });
    }
}
