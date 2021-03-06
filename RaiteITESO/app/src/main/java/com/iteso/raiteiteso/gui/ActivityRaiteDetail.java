package com.iteso.raiteiteso.gui;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
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
public class ActivityRaiteDetail extends Activity{
    ToggleButtonClass toggleButton;
    private AdapterListRaiteDetail raiteDetail;
    private  ArrayList<String> detail;
    private ArrayList<String> interestPoints;
    private ArrayList<String> adapterArrayList;
    private Button askForRide;
    private TextView noRaite;
    ListView listDetail;
    private DatabaseHandler dh;
    private UserControl userControl;
    private UserWCar user;
    private UserWOCar userWOCar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_raite_detail);
        listDetail = (ListView)findViewById(R.id.activity_raite_detail_list);
        toggleButton = (ToggleButtonClass) findViewById(R.id.activity_raite_detail_toggle_button);
        askForRide = (Button) findViewById(R.id.activity_raite_detail_buttom_raite);
        noRaite = (TextView) findViewById(R.id.activity_raite_detail_no_raite_detail);

        detail = new ArrayList<>();
        interestPoints = new ArrayList<>();
        adapterArrayList = new ArrayList<>();
        dh = DatabaseHandler.getInstance(this);
        userControl = new UserControl(this);

        String userName = getIntent().getStringExtra(Constants.USER_WITH_CAR_EXTRA);
        user = userControl.getUserWithCarByUserName(userName, dh);
        String name = getIntent().getStringExtra(Constants.USER_EXTRA);
        userWOCar = userControl.getUserWithOuthCarByUserName(name, dh);

        detail.add(user.getCar());
        detail.add(user.getCarColor());
        detail.add(userWOCar.getMeetingPoint());

        interestPoints = user.getInterestPoints();

        adapterArrayList = interestPoints;
        toggleButton.setLeftButtonText("Puntos de interés", "Puntos de interés");
        toggleButton.setRithButtonText("Datos del raite", "Datos del raite");
        raiteDetail = new AdapterListRaiteDetail(adapterArrayList, this);
        listDetail.setAdapter(raiteDetail);

        if(userWOCar.getRide().equals("")){
            askForRide.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (userWOCar.addRide(user)) {
                        Toast.makeText(ActivityRaiteDetail.this, "Solicitud de ride enviada", Toast.LENGTH_LONG).show();
                        userControl.updateUserWithCar(dh, user);
                    } else {
                        Toast.makeText(ActivityRaiteDetail.this, "Ya habías mandado solicitud a este usuario", Toast.LENGTH_LONG).show();
                    }
                }
            });
            noRaite.setVisibility(View.VISIBLE);
            listDetail.setVisibility(View.GONE);
        }else{
            askForRide.setVisibility(View.GONE);
        }

        toggleButton.setToggleButtonListener(new ToggleButtonClass.ToggleButtonListener() {
            @Override
            public void leftButtonClick() {
                raiteDetail = new AdapterListRaiteDetail(interestPoints, ActivityRaiteDetail.this);
                listDetail.setAdapter(raiteDetail);
            }

            @Override
            public void rightButtonClick() {
                raiteDetail = new AdapterListRaiteDetail(detail, ActivityRaiteDetail.this);
                listDetail.setAdapter(raiteDetail);
            }
        });

    }

}
