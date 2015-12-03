package com.iteso.raiteiteso.gui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.iteso.raiteiteso.beans.UserWCar;
import com.iteso.raiteiteso.beans.UserWOCar;
import com.iteso.raiteiteso.database.DatabaseHandler;
import com.iteso.raiteiteso.database.UserControl;
import com.iteso.raiteiteso.utils.Constants;

/**
 * Created by Daniel on 18/10/2015.
 */
public class ActivityLogin extends Activity {
    private String userName;
    private String password;
    private EditText userNameEdit;
    private EditText passwordEdit;
    private Button login;
    private Button create;
    private DatabaseHandler dh;
    private UserControl userControl;
    private Intent intent;
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        dh = DatabaseHandler.getInstance(this);
        userControl = new UserControl(this);

        sharedPreferences = getSharedPreferences(Constants.SHARED_PREFERENCES, Context.MODE_PRIVATE);
        if(sharedPreferences.contains(Constants.OPEN_PROFILE)){
            Intent intent;
            String userName = sharedPreferences.getString(Constants.OPEN_PROFILE, "");
            int type = sharedPreferences.getInt(Constants.PROFILE_TYPE, 0);

            if(type == Constants.WITCHCAR){
                UserWCar userWCar = userControl.getUserWithCarByUserName(userName, dh);
                intent = new Intent(ActivityLogin.this, ActivityMainWithCar.class);
            }else{
                UserWOCar userWOCar = userControl.getUserWithOuthCarByUserName(userName, dh);
                if(userWOCar.getRide().equals("")) {
                    intent = new Intent(ActivityLogin.this, ActivityMainWithOutCar.class);
                }else{
                    intent = new Intent(ActivityLogin.this, ActivityRaiteDetail.class);
                    intent.putExtra(Constants.USER_WITH_CAR_EXTRA, userWOCar.getRide());
                }
            }

            intent.putExtra(Constants.USER_EXTRA, userName);
            startActivity(intent);

        }else{
            userNameEdit = (EditText) findViewById(R.id.activity_login_user);
            passwordEdit = (EditText) findViewById(R.id.activity_login_password);
            login = (Button) findViewById(R.id.activity_login_login);
            create = (Button) findViewById(R.id.activity_login_create);

            create.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    intent = new Intent(ActivityLogin.this, ActivityCreateAccount.class);
                    startActivity(intent);
                }
            });

            login.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    userName = userNameEdit.getText().toString();
                    password = passwordEdit.getText().toString();

                    if(userName.equals("") || userName.equals(" ") || password.equals("") || password.equals(" ")){
                        Toast.makeText(ActivityLogin.this, "Debe llenar todos los campos", Toast.LENGTH_LONG).show();
                    }else if(userName.contains("'")){
                        Toast.makeText(ActivityLogin.this, "Caracteres inválidos", Toast.LENGTH_LONG).show();
                    }else{
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        UserWOCar userWOCar = userWOCarValidation();
                        if(userWOCar != null){
                            if(userWOCar.getPassword().equals(password)){
                                if (userWOCar.getRide().equals("")){
                                    intent = new Intent(ActivityLogin.this, ActivityMainWithOutCar.class);
                                }else{
                                    intent = new Intent(ActivityLogin.this, ActivityRaiteDetail.class);
                                    intent.putExtra(Constants.USER_WITH_CAR_EXTRA,
                                            userControl.getUserWithCarByUserName(userWOCar.getRide(), dh).getUserName());
                                }
                                editor.putString(Constants.OPEN_PROFILE, userName);
                                editor.putInt(Constants.PROFILE_TYPE, Constants.WITHOUTCAR);
                                editor.commit();
                                finish();
                                intent.putExtra(Constants.USER_EXTRA, userWOCar.getUserName());
                                startActivity(intent);

                            }else{
                                Toast.makeText(ActivityLogin.this, "Contraseña incorrecta", Toast.LENGTH_LONG).show();
                            }
                        }else{
                            UserWCar userWCar = userWCarValidation();
                            if(userWCar != null){
                                if(userWCar.getPassword().equals(password)){
                                    intent = new Intent(ActivityLogin.this, ActivityMainWithCar.class);
                                    editor.putString(Constants.OPEN_PROFILE, userName);
                                    editor.putInt(Constants.PROFILE_TYPE, Constants.WITCHCAR);
                                    editor.commit();
                                    finish();
                                    intent.putExtra(Constants.USER_EXTRA, userWCar.getUserName());
                                    startActivity(intent);
                                }else{
                                    Toast.makeText(ActivityLogin.this, "Contraseña incorrecta", Toast.LENGTH_LONG).show();
                                }
                            }else{
                                Toast.makeText(ActivityLogin.this, "Usuario incorrecto", Toast.LENGTH_LONG).show();
                            }
                        }
                    }
                }
            });
        }
    }

    private UserWOCar userWOCarValidation(){
        UserWOCar userWOCar = userControl.getUserWithOuthCarByUserName(userName, dh);

        return  userWOCar;
    }

    private UserWCar userWCarValidation(){
        UserWCar userWCar = userControl.getUserWithCarByUserName(userName, dh);

        return userWCar;
    }
}
