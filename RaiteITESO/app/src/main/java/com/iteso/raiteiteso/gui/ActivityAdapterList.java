package com.iteso.raiteiteso.gui;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by houstonsalgado on 10/11/15.
 */
public class ActivityAdapterList extends BaseAdapter implements ListAdapter{
    private ArrayList<String> pointsInteres = new ArrayList<String>();
    private Context context;

    public ActivityAdapterList(ArrayList<String>pointsInteres, Context context){
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
        //return pointsInteres.get(position).getId();
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
        nameTxt.setText(pointsInteres.get(position));

        TextView finalPointTxt = (TextView)view.findViewById(R.id.activity_item_final_point);
        finalPointTxt.setText(pointsInteres.get(position));

        Button cancelBtn = (Button)view.findViewById(R.id.activity_item_cancel);

      /*  CheckBox c = new CheckBox(context);
        c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(c.isChecked()){

                }
            }
        });*/

        cancelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Falta definir que se hara en este caso.
                pointsInteres.remove(position);
                notifyDataSetChanged();
            }
        });

        return view;
    }
}
