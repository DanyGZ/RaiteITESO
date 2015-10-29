package com.iteso.raiteiteso.gui;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.iteso.raiteiteso.beans.User;

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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /*setContentView(R.layout.activity_login);

        userNameEdit = (EditText) findViewById(R.id.activity_login_user);
        passwordEdit = (EditText) findViewById(R.id.activity_login_password);
        login = (Button) findViewById(R.id.activity_login_login);
        create = (Button) findViewById(R.id.activity_login_create);*/

        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                User user = userValidation();
                if(user != null){
                   // Intent intent = new Intent(ActivityLogin.this, ActivityMain.class);
                    //startActivity(intent);
                }else{

                }
            }
        });
    }

    private User userValidation(){
        User user = null;

        return user;
    }
}
