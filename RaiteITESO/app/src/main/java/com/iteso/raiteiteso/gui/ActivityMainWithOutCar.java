package com.iteso.raiteiteso.gui;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.iteso.raiteiteso.beans.UserWCar;
import com.iteso.raiteiteso.database.DatabaseHandler;
import com.iteso.raiteiteso.database.UserControl;
import com.iteso.raiteiteso.utils.Constants;

import java.util.ArrayList;

/**
 * Created by Daniel on 29/10/2015.
 */
public class ActivityMainWithOutCar extends Activity{
    TextView noRaite;
    ListView listView;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_without_car);

        noRaite = (TextView) findViewById(R.id.activity_main_without_car_no_raite);
        listView = (ListView)findViewById(R.id.activity_main_without_car_list);

        DatabaseHandler dh = DatabaseHandler.getInstance(this);
        UserControl userControl = new UserControl(this);

        ArrayList<UserWCar> points = userControl.getRides(dh, Constants.MONDAY, "1");

        if(points.size() == 0){
            noRaite.setVisibility(View.VISIBLE);
            listView.setVisibility(View.GONE);
        }else{
            noRaite.setVisibility(View.GONE);
            listView.setVisibility(View.VISIBLE);
            AdapterListWithoutCar raite = new AdapterListWithoutCar(points,this);
            listView.setAdapter(raite);
        }
    }
}
