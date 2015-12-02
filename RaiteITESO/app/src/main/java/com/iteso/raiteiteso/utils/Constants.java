package com.iteso.raiteiteso.utils;

import java.util.ArrayList;

/**
 * Created by Daniel on 13/11/2015.
 */
public class Constants {
    public static final String USER_EXTRA = "UserExtra";
    public static final String USER_WITH_CAR_EXTRA = "UserWCExtra";
    public static final String USER_EXTRA_NAME = "UserExtraName";
    public static final String USER_EXTRA_HAS_CAR = "HasCar";
    public static ArrayList<String> interestPoints;
    public static final String SHARED_PREFERENCES = "SharedPreferences";

    public static void fillInterestPoints(){
        interestPoints = new ArrayList<>();
        interestPoints.add("Patria");
        interestPoints.add("Colón");
        interestPoints.add("Guadalupe");
        interestPoints.add("López Mateos");
    }
}
