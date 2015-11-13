package com.iteso.raiteiteso.gui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by houstonsalgado on 13/11/15.
 */
public class ActivityAdapterWithoutCar extends BaseAdapter implements ListAdapter {

    private ArrayList<String> infoRaite = new ArrayList<String>();
    private Context context;

    public ActivityAdapterWithoutCar(ArrayList<String>infoRaite, Context context){
        this.infoRaite = infoRaite;
        this.context=context;
    }

    @Override
    public int getCount() {
        return infoRaite.size();
    }

    @Override
    public Object getItem(int position) {
        return infoRaite.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if(view ==null){
            LayoutInflater inflater= (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.activity_item_without_car, null);
        }

        TextView nameTxt = (TextView)view.findViewById(R.id.activity_item_without_car_name);
        nameTxt.setText(infoRaite.get(position));

        TextView finalPoint = (TextView)view.findViewById(R.id.activity_item_without_car_final_point);
        finalPoint.setText(infoRaite.get(position));

        TextView timeTxt = (TextView)view.findViewById(R.id.activity_item_without_car_time);
        timeTxt.setText(infoRaite.get(position));

        ImageView info = (ImageView)view.findViewById(R.id.activity_item_without_car_imagen);

        info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                infoRaite.remove(position);
                notifyDataSetChanged();
            }
        });

        return view;
    }
}
