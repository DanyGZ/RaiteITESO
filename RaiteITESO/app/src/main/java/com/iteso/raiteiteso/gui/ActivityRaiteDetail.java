package com.iteso.raiteiteso.gui;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by Daniel on 29/10/2015.
 */
public class ActivityRaiteDetail extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_raite_list);

        ArrayList<String> detail = new ArrayList<>();

        AdapterListRaiteDetail raiteDetail = new AdapterListRaiteDetail(detail, this);
        ListView listDetail = (ListView)findViewById(R.id.activity_raite_detail_list);
        listDetail.setAdapter(raiteDetail);

    }

}
