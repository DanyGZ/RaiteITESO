package com.iteso.raiteiteso.gui;

import com.iteso.raiteiteso.database.DatabaseHandler;
import com.iteso.raiteiteso.database.UserControl;

/**
 * Created by Daniel on 23/11/2015.
 */
public interface Observer{
    void update(DatabaseHandler dh, UserControl userControl, String userWCName, String meetingPoint);
}
