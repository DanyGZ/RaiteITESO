package com.iteso.raiteiteso.database;

import android.provider.BaseColumns;

/**
 * Created by salvadorbeltran on 12/2/2015.
 */
public class DBContract {
    public static final class USERS_WITH_CAR implements BaseColumns {
        public static final String table_name = "USERS_WITH_CAR";

        public static final String column_users_with_car_user_name = "USERS_WITH_CAR_USER_NAME";
        public static final String column_users_with_car_password = "USERS_WITH_CAR_PASSWORD";
        public static final String column_users_with_car_name = "USERS_WITH_CAR_NAME";
        public static final String column_users_with_car_car = "USERS_WITH_CAR_CAR";
        public static final String column_users_with_car_car_color = "USERS_WITH_CAR_CAR_COLOR";
        public static final String column_users_with_car_capacity = "USERS_WITH_CAR_CAPACITY";
        public static final String column_users_with_car_monday_hour = "USERS_WITH_CAR_MONDAY_HOUR";
        public static final String column_users_with_car_tuesday_hour = "USERS_WITH_CAR_TUESDAY_HOUR";
        public static final String column_users_with_car_wednesday_hour = "USERS_WITH_CAR_WEDNESDAY_HOUR";
        public static final String column_users_with_car_thursday_hour = "USERS_WITH_CAR_THURSDAY_HOUR";
        public static final String column_users_with_car_friday_hour = "USERS_WITH_CAR_FRIDAY_HOUR";
        public static final String column_users_with_car_aviable = "USERS_WITH_CAR_AVIABLE";
        public static final String column_users_with_car_interest_point = "USERS_WITH_CAR_INTEREST_POINT";
        public static final String column_users_with_car_ride_request = "USERS_WITH_CAR_RIDE_REQUEST";
    }

    public static final class USERS_WITHOUT_CAR implements BaseColumns {
        public static final String table_name = "USERS_WITHOUT_CAR";

        public static final String column_users_without_car_user_name = "USERS_WITHOUT_CAR_USER_NAME";
        public static final String column_users_without_car_password = "USERS_WITHOUT_CAR_PASSWORD";
        public static final String column_users_without_car_name = "USERS_WITHOUT_CAR_NAME";
        public static final String column_users_without_car_monday_hour = "USERS_WITHOUT_CAR_MONDAY_HOUR";
        public static final String column_users_without_car_tuesday_hour = "USERS_WITHOUT_CAR_TUESDAY_HOUR";
        public static final String column_users_without_car_wednesday_hour = "USERS_WITHOUT_CAR_WEDNESDAY_HOUR";
        public static final String column_users_without_car_thursday_hour = "USERS_WITHOUT_CAR_THURSDAY_HOUR";
        public static final String column_users_without_car_friday_hour = "USERS_WITHOUT_CAR_FRIDAY_HOUR";
        public static final String column_users_without_car_interest_point = "USERS_WITHOUT_CAR_INTEREST_POINT";
        public static final String column_users_without_car_ride_user = "USERS_WITHOUT_CAR_RIDE_USER";
        public static final String column_users_without_car_meeting_point = "USERS_WITHOUT_CAR_MEETING_POINT";
    }
}
