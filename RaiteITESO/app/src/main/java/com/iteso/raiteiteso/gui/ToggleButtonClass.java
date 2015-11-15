package com.iteso.raiteiteso.gui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ToggleButton;

/**
 * Created by Daniel on 15/11/2015.
 */
public class ToggleButtonClass extends RelativeLayout{
    ToggleButton leftButton;
    ToggleButton rightButton;
    private ToggleButtonListener toggleButtonListener;
    private Context context;

    public interface ToggleButtonListener{
        void leftButtonClick();
        void rightButtonClick();
    }

    public void setLeftButtonText(String onText, String offText){
        leftButton.setTextOn(onText);
        leftButton.setTextOff(offText);
        leftButton.setText(onText);
    }

    public void setRithButtonText(String onText, String offText){
        rightButton.setTextOn(onText);
        rightButton.setTextOff(offText);
        rightButton.setText(offText);
    }

    public void setToggleButtonListener(ToggleButtonListener toggleButtonListener){
        this.toggleButtonListener = toggleButtonListener;
    }

    public ToggleButtonClass(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        toggleButtonListener = null;

        try{
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            inflater.inflate(R.layout.toggle_button, this, true);
            LinearLayout linearLayout = (LinearLayout) getChildAt(0);
            leftButton = (ToggleButton) linearLayout.getChildAt(0);
            rightButton = (ToggleButton) linearLayout.getChildAt(1);
        }catch(Exception e){}

        leftButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if(leftButton.isChecked() && toggleButtonListener != null){
                    toggleButtonListener.leftButtonClick();
                }
                leftButton.setChecked(true);
                rightButton.setChecked(false);
            }
        });

        rightButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if(rightButton.isChecked() && toggleButtonListener != null){
                    toggleButtonListener.rightButtonClick();
                }
                rightButton.setChecked(true);
                leftButton.setChecked(false);
            }
        });
    }
}
