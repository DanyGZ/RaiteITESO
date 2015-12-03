package com.iteso.raiteiteso.gui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Daniel on 20/11/2015.
 */
public class AdapterInterestPoints extends BaseAdapter {
    private ArrayList<String> interestPoints;
    private ArrayList<Boolean> checkedPoints;
    private Context context;
    private LayoutInflater inflater = null;

    static class PointHolder{
        TextView place;
        CheckBox checkBox;
    }

    public AdapterInterestPoints(Context context, ArrayList<String> interestPoints){
        this.context = context;
        this.interestPoints = interestPoints;
        this.inflater =  LayoutInflater.from(context);
        checkedPoints = new ArrayList<>();

        for(int i=0; i<interestPoints.size(); i++){
            checkedPoints.add(false);
        }

    }

    public AdapterInterestPoints(Context context, ArrayList<String> interestPoints, ArrayList<String> checked){
        this.context = context;
        this.interestPoints = interestPoints;
        this.inflater =  LayoutInflater.from(context);
        checkedPoints = new ArrayList<>();

        for(int i=0; i<interestPoints.size(); i++){
            boolean flag = false;
            for(int j=0; j<checked.size(); j++){
                if(checked.get(j).contains(interestPoints.get(i))){
                    flag = true;
                    break;
                }
            }
            checkedPoints.add(flag);
        }

    }

    public ArrayList<Boolean> getCheckedPoints(){
        return checkedPoints;
    }

    @Override
    public int getCount() {
        return interestPoints.size();
    }

    @Override
    public Object getItem(int position) {
        return interestPoints.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        final PointHolder pointHolder;

        if(convertView == null){
            convertView = inflater.inflate(R.layout.item_interest_points, null);
            pointHolder = new PointHolder();
            pointHolder.place = (TextView) convertView.findViewById(R.id.item_interest_points_place);
            pointHolder.checkBox = (CheckBox) convertView.findViewById(R.id.item_interest_points_check_box);
            convertView.setTag(pointHolder);
        }else{
            pointHolder = (PointHolder) convertView.getTag();
        }

        pointHolder.checkBox.setChecked(checkedPoints.get(position));
        pointHolder.place.setText(interestPoints.get(position));
        pointHolder.checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    checkedPoints.set(position, true);
                    pointHolder.checkBox.setBackgroundColor(context.getResources().getColor(R.color.AzulIteso));
                }else{
                    checkedPoints.set(position, false);
                }
            }
        });

        return convertView;
    }

}
