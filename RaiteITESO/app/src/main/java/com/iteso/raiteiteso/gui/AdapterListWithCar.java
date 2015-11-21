package com.iteso.raiteiteso.gui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.TextView;

import com.iteso.raiteiteso.beans.UserWOCar;

import java.util.ArrayList;

/**
 * Created by houstonsalgado on 10/11/15.
 */
public class AdapterListWithCar extends BaseAdapter implements ListAdapter{
    private ArrayList<UserWOCar> pointsInteres = new ArrayList<>();
    private Context context;

    public AdapterListWithCar(ArrayList<UserWOCar> pointsInteres, Context context){
        this.pointsInteres = pointsInteres;
        this.context=context;
    }

    @Override
    public int getCount() {
        return pointsInteres.size();
    }

    @Override
    public Object getItem(int position) {
        return pointsInteres.get(position);
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
            view = inflater.inflate(R.layout.activity_item, null);
        }

        TextView nameTxt = (TextView)view.findViewById(R.id.activity_item_name);
        nameTxt.setText(pointsInteres.get(position).getName());

        TextView finalPointTxt = (TextView)view.findViewById(R.id.activity_item_final_point);
        finalPointTxt.setText(pointsInteres.get(position).getFridayHour());
        //Falta agregar el punto

      /*  CheckBox c = new CheckBox(context);
        c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(c.isChecked()){

                }
            }
        });*/

        return view;
    }
}
