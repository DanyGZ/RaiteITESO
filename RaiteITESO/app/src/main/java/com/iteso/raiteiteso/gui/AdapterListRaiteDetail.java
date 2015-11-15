package com.iteso.raiteiteso.gui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by houstonsalgado on 15/11/15.
 */
public class AdapterListRaiteDetail extends BaseAdapter implements ListAdapter {
    private ArrayList<String> details = new ArrayList<>();
    private Context context;

    public AdapterListRaiteDetail(ArrayList<String> details, Context context){
        this.details = details;
        this.context = context;
    }



    @Override
    public int getCount() {
        return details.size();
    }

    @Override
    public Object getItem(int position) {
        return details.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if(view ==null){
            LayoutInflater inflater= (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.item_list_detail, null);
        }
        TextView detail = (TextView)view.findViewById(R.id.item_list_details_text);
        detail.setText(details.get(position));

        return view;
    }
}
