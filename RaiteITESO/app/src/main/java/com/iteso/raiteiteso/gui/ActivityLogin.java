package com.iteso.raiteiteso.gui;

import android.app.Activity;
import android.content.Intent;
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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        dh = DatabaseHandler.getInstance(this);

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

    private UserWOCar userWOCarValidation(){
        userControl = new UserControl(this);
        UserWOCar userWOCar = userControl.getUserWithOuthCarByUserName(userName, dh);

        return  userWOCar;
    }

    private UserWCar userWCarValidation(){
       userControl = new UserControl(this);
        UserWCar userWCar = userControl.getUserWithCarByUserName(userName, dh);

        return userWCar;
    }
}
