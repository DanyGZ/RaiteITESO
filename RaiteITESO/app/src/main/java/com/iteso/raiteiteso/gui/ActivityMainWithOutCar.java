package com.iteso.raiteiteso.gui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.TextView;

import com.iteso.raiteiteso.beans.UserWCar;
import com.iteso.raiteiteso.beans.UserWOCar;
import com.iteso.raiteiteso.database.DatabaseHandler;
import com.iteso.raiteiteso.database.UserControl;
import com.iteso.raiteiteso.utils.Constants;

import java.util.ArrayList;
import java.util.Calendar;

/**
 * Created by Daniel on 29/10/2015.
 */
public class ActivityMainWithOutCar extends Activity{
    TextView noRaite;
    ListView listView;
    UserWOCar userWOCarc = new UserWOCar();
    Calendar calendar = Calendar.getInstance();
    ArrayList<UserWCar> points;
    ArrayList<UserWCar> usersWithCar;
    ImageView refresh;
    Switch aSwitch;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_without_car);

        noRaite = (TextView) findViewById(R.id.activity_main_without_car_no_raite);
        listView = (ListView)findViewById(R.id.activity_main_without_car_list);
        refresh = (ImageView)findViewById(R.id.activity_main_without_car_refresh);
        aSwitch = (Switch)findViewById(R.id.activity_main_without_car_visible);

        DatabaseHandler dh = DatabaseHandler.getInstance(this);
        UserControl userControl = new UserControl(this);

        String userName = getIntent().getStringExtra(Constants.USER_EXTRA);
        userWOCarc = userControl.getUserWithOuthCarByUserName(userName, dh);
        points = new ArrayList<>();

        int day = calendar.get(Calendar.DAY_OF_WEEK);

        if(day != Calendar.SATURDAY && day != Calendar.SUNDAY) {
        usersWithCar = userControl.getRides(dh, day, getHora());

        for(int i=0; i<usersWithCar.size(); i++){
            if(usersWithCar.get(i).getUserWOCars().size() < usersWithCar.get(i).getCarCapacity()){
                points.add(usersWithCar.get(i));
            }
        }


            if (points.size() == 0) {
                noRaite.setVisibility(View.VISIBLE);
                listView.setVisibility(View.GONE);
            } else {
                noRaite.setVisibility(View.GONE);
                listView.setVisibility(View.VISIBLE);
                AdapterListWithoutCar raite = new AdapterListWithoutCar(points, this);
                listView.setAdapter(raite);
            }

            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Intent intent = new Intent(ActivityMainWithOutCar.this, ActivityRaiteDetail.class);
                    intent.putExtra(Constants.USER_WITH_CAR_EXTRA, points.get(position).getUserName());
                    intent.putExtra(Constants.USER_EXTRA, userWOCarc.getUserName());
                    startActivity(intent);
                }
            });
        }

        aSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){

                }else{

                }
            }
        });

        refresh.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                startActivity(getIntent());
            }
        });
    }

    public String getHora(){
        String hora = " ";
        switch (calendar.get(Calendar.DAY_OF_WEEK)){
            case Calendar.MONDAY:
                hora = userWOCarc.getMondayHour();
                break;
            case Calendar.THURSDAY:
                hora = userWOCarc.getThursdayHour();
                break;
            case Calendar.WEDNESDAY:
                hora = userWOCarc.getWednesdayHour();
                break;
            case Calendar.TUESDAY:
                hora = userWOCarc.getTuesdayHour();
                break;
            case Calendar.FRIDAY:
                hora = userWOCarc.getFridayHour();
                break;
        }

        return hora;
    }
}
