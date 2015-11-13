package com.iteso.raiteiteso.gui;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by Daniel on 29/10/2015.
 */
public class ActivityMainWithOutCar extends Activity{
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_without_car);

        ArrayList<String> points =new ArrayList<String>();
        points.add("Prueba 1");
        points.add("Prueba 2");
        points.add("Prueba 3");
        points.add("Prueba 4");
        points.add("Prueba 5");
        points.add("Prueba 6");
        points.add("Prueba 7");
        points.add("Prueba 8");

        ActivityAdapterWithoutCar raite = new ActivityAdapterWithoutCar(points,this);
        ListView listView = (ListView)findViewById(R.id.activity_main_without_car_list);
        listView.setAdapter(raite);
    }
}
