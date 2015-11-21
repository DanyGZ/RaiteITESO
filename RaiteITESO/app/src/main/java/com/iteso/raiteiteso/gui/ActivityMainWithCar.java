package com.iteso.raiteiteso.gui;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.TextView;

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

        dh = DatabaseHandler.getInstance(this);
        userControl = new UserControl(this);

        UserWCar userWCar = getIntent().getParcelableExtra(Constants.USER_EXTRA);

        if(userWCar.getUserWOCars().size() == 0){
            rideRequestText.setVisibility(View.VISIBLE);
            noticeMessage.setVisibility(View.GONE);
            meetingPoint.setVisibility(View.GONE);
            confirm.setVisibility(View.GONE);
            listView.setVisibility(View.GONE);
        }else{
            ArrayList<UserWOCar> rideRequest = userControl.getRidesRequest(dh, userWCar);
            adapterList = new AdapterListWithCar(rideRequest, this);
            listView.setAdapter(adapterList);
        }
        
    }

}
