package com.iteso.raiteiteso.gui;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.iteso.raiteiteso.beans.UserWCar;
import com.iteso.raiteiteso.beans.UserWOCar;
import com.iteso.raiteiteso.database.DatabaseHandler;
import com.iteso.raiteiteso.database.UserControl;
import com.iteso.raiteiteso.utils.Constants;

import java.util.ArrayList;

/**
 * Created by Daniel on 29/10/2015.
 */
public class ActivityMainWithCar extends Activity{
    private DatabaseHandler dh;
    private UserControl userControl;
    private AdapterListWithCar adapterList;
    private ListView listView;
    private Switch visibility;
    private TextView rideRequestText;
    private TextView noticeMessage;
    private EditText meetingPoint;
    private Button confirm;
    private Button cancel;
    private ImageView refresh;
    private ImageView edit;
    private ArrayList<UserWOCar> rideRequest;
    private ArrayList<Integer> acceptedUsers;
    private UserWCar userWCar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_with_car);

        listView =(ListView)findViewById(R.id.activity_main_with_car_points_interest);
        visibility = (Switch) findViewById(R.id.activity_main_with_car_visible);
        rideRequestText = (TextView) findViewById(R.id.activity_main_with_car_pending_ride_request);
        noticeMessage = (TextView) findViewById(R.id.activity_main_with_car_message_aviso);
        meetingPoint = (EditText) findViewById(R.id.activity_main_with_car_message_confirm);
        confirm = (Button) findViewById(R.id.activity_main_with_car_confirm_button);
        cancel = (Button) findViewById(R.id.activity_main_with_car_cancel_button);
        refresh = (ImageView) findViewById(R.id.activity_main_with_car_refresh);
        edit = (ImageView) findViewById(R.id.activity_main_with_car_image_edit);

        dh = DatabaseHandler.getInstance(this);
        userControl = new UserControl(this);

        String userName = getIntent().getStringExtra(Constants.USER_EXTRA);
        userWCar = userControl.getUserWithCarByUserName(userName, dh);

        if(userWCar.getUserWOCars().size() == 0){
            rideRequestText.setVisibility(View.VISIBLE);
            noticeMessage.setVisibility(View.INVISIBLE);
            meetingPoint.setVisibility(View.GONE);
            confirm.setVisibility(View.INVISIBLE);
            listView.setVisibility(View.INVISIBLE);
        }else{
            rideRequest = new ArrayList<>();
            for(int i=0; i<userWCar.getUserWOCars().size(); i++){
                if(userWCar.getUserWOCars().get(i).getRide().equals("")){
                    rideRequest.add(userWCar.getUserWOCars().get(i));
                }
            }

            if(rideRequest.size() == 0){
                rideRequestText.setText("No tienes solicitudes sin responder");
                rideRequestText.setVisibility(View.VISIBLE);
                noticeMessage.setVisibility(View.GONE);
                meetingPoint.setVisibility(View.GONE);
                confirm.setVisibility(View.GONE);
                listView.setVisibility(View.GONE);
            }

            adapterList = new AdapterListWithCar(rideRequest, this);
            listView.setAdapter(adapterList);

            confirm.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ArrayList<Boolean> checkedUsers = adapterList.getCheckedItems();
                    acceptedUsers = new ArrayList<>();

                    for (int i = 0; i < checkedUsers.size(); i++) {
                        if (checkedUsers.get(i)) {
                            acceptedUsers.add(i);
                        }
                    }

                    if (acceptedUsers.size() == 0) {
                        Toast.makeText(ActivityMainWithCar.this, "No has seleccionado a nadie para darle ride",
                                Toast.LENGTH_LONG).show();
                    } else {
                        if (meetingPoint.getText().toString().equals("")) {
                            Toast.makeText(ActivityMainWithCar.this, "Debes escribir un mensaje con el" +
                                    "punto de reunión", Toast.LENGTH_LONG).show();
                        } else {
                            ArrayList<UserWOCar> finalRideRequest = new ArrayList<>();
                            for (int i = 0; i < acceptedUsers.size(); i++) {
                                finalRideRequest.add(rideRequest.get(acceptedUsers.get(i)));
                                rideRequest.remove(acceptedUsers.get(i));
                            }
                            userWCar.setUserWOCars(finalRideRequest);
                            userWCar.notifyObservers(dh, meetingPoint.getText().toString(), userControl, userWCar.getUserName());
                            userControl.updateUserWithCar(dh, userWCar);
                            Toast.makeText(ActivityMainWithCar.this, "Has aceptado las solicitudes", Toast.LENGTH_LONG).show();
                            finish();
                            startActivity(getIntent());
                        }
                    }

                }
            });

            cancel.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    userWCar.notifyObservers(dh, "", userControl, "");
                    userWCar.setUserWOCars(new ArrayList<UserWOCar>());
                    userControl.updateUserWithCar(dh, userWCar);
                    finish();
                    startActivity(getIntent());
                }
            });

            refresh.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    finish();
                    startActivity(getIntent());
                }
            });

            edit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });

        }
        
    }

}
