package com.iteso.raiteiteso.gui;

import com.iteso.raiteiteso.beans.UserWOCar;
import com.iteso.raiteiteso.database.DatabaseHandler;
import com.iteso.raiteiteso.database.UserControl;

/**
 * Created by Daniel on 23/11/2015.
 */
public interface Subject {
    boolean registerObserver(UserWOCar observer);
    void notifyObservers(DatabaseHandler dh, String meetingPoint, UserControl userControl, String userName);
    void removeObserver(UserWOCar observer);
}
