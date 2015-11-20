package com.iteso.raiteiteso.gui;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

import com.iteso.raiteiteso.beans.UserWOCar;

import java.util.ArrayList;

/**
 * Created by Daniel on 29/10/2015.
 */
public class ActivityMainWithCar extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_with_car);

        ArrayList<UserWOCar> points =new ArrayList<>();
       /* points.add("Prueba 1");
        points.add("Prueba 2");
        points.add("Prueba 3");
        points.add("Prueba 4");
        points.add("Prueba 5");
        points.add("Prueba 6");
        points.add("Prueba 7");
        points.add("Prueba 8");*/


        AdapterListWithCar adapterList = new AdapterListWithCar(points, this);

        ListView listView =(ListView)findViewById(R.id.activity_main_with_car_points_interest);
        listView.setAdapter(adapterList);
        
    }

}
