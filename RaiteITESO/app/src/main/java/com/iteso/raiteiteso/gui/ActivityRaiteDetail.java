package com.iteso.raiteiteso.gui;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

import com.iteso.raiteiteso.beans.UserWCar;

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
    ListView listDetail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_raite_detail);
        listDetail = (ListView)findViewById(R.id.activity_raite_detail_list);

        detail = new ArrayList<>();
        interestPoints = new ArrayList<>();
        adapterArrayList = new ArrayList<>();

        UserWCar user = getIntent().getParcelableExtra("uwc");

        detail.add(user.getCar());
        detail.add(user.getCarColor());
        detail.add("Punto de reunion");

        interestPoints.add("Patria");
        interestPoints.add("Guadalupe");

        adapterArrayList = interestPoints;
        toggleButton = (ToggleButtonClass) findViewById(R.id.activity_raite_detail_toggle_button);
        toggleButton.setLeftButtonText("Puntos de interés", "Puntos de interés");
        toggleButton.setRithButtonText("Datos del raite", "Datos del raite");
        raiteDetail = new AdapterListRaiteDetail(adapterArrayList, this);
        listDetail.setAdapter(raiteDetail);

        toggleButton.setToggleButtonListener(new ToggleButtonClass.ToggleButtonListener() {
            @Override
            public void leftButtonClick() {
                raiteDetail = new AdapterListRaiteDetail(interestPoints, ActivityRaiteDetail.this);
                listDetail.deferNotifyDataSetChanged();
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
