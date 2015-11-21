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
                    UserWCar userWCar = (UserWCar) userValidation();
                    if(userWCar != null){
                        if(userWCar.getPassword().equals(password)){
                            if(userWCar.getCar() != null){
                                intent = new Intent(ActivityLogin.this, ActivityMainWithCar.class);
                            }else{
                                intent = new Intent(ActivityLogin.this, ActivityMainWithOutCar.class);
                            }
                            intent.putExtra(Constants.USER_EXTRA, userWCar);
                            startActivity(intent);
                        }else{
                            Toast.makeText(ActivityLogin.this, "Contraseña incorrecta", Toast.LENGTH_LONG).show();
                        }
                    }else{
                        Toast.makeText(ActivityLogin.this, "Usuario incorrecto", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });
    }

    private UserWOCar userValidation(){
        UserWOCar userWOCar = null;

        userControl = new UserControl(this);

        userWOCar = userControl.getUserWithOuthCarByUserName(userName, dh);

        if(userWOCar == null){
            userWOCar = userControl.getUserWithCarByUserName(userName, dh);
        }

        return userWOCar;
    }
}
