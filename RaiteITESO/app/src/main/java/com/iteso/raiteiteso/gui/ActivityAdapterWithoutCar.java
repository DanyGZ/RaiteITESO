package com.iteso.raiteiteso.gui;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;

import java.util.ArrayList;

/**
 * Created by houstonsalgado on 13/11/15.
 */
public class ActivityAdapterWithoutCar extends BaseAdapter implements ListAdapter {

    private ArrayList<String> pointsInteres = new ArrayList<String>();
    private Context context;

    public ActivityAdapterWithoutCar(ArrayList<String>pointsInteres, Context context){
        this.pointsInteres = pointsInteres;
        this.context=context;
    }
    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return null;
    }
}
