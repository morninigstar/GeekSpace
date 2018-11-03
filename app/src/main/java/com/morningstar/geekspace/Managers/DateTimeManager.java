/*
 * Created by Sujoy Datta. Copyright (c) 2018. All rights reserved.
 *
 * To the person who is reading this..
 * When you finally understand how this works, please do explain it to me too at sujoydatta26@gmail.com
 * P.S.: In case you are planning to use this without mentioning me, you will be met with mean judgemental looks and sarcastic comments.
 */

package com.morningstar.geekspace.Managers;

import android.annotation.SuppressLint;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Class created on 04/11/2018
 */

public class DateTimeManager {
    //Return today's date in Date format
    public static Date getCurrentDate() {
        return new Date();
    }

    /*
        This method returns 3 int values in an array.
        The first value is today's date
        The second value is this month's value
        The third value is this year's value
     */
    public static int[] getDateValuesAsInt() {
        int values[] = new int[3];
        Calendar calendar = Calendar.getInstance();
        values[0] = calendar.get(Calendar.DAY_OF_MONTH);
        values[1] = calendar.get(Calendar.MONTH) + 1;
        values[2] = calendar.get(Calendar.YEAR);
        return values;
    }

    /**
     * This method takes in integer value for month and returns the string value for it
     * 0 - January, 1 - February
     *
     * @param month_value - value of month to be converted to string
     * @return string
     */
    public static String getStringNameForMonthValue(int month_value) {
        switch (month_value) {
            case 1:
                return "January";
            case 2:
                return "February";
            case 3:
                return "March";
            case 4:
                return "April";
            case 5:
                return "May";
            case 6:
                return "June";
            case 7:
                return "July";
            case 8:
                return "August";
            case 9:
                return "September";
            case 10:
                return "October";
            case 11:
                return "November";
            case 12:
                return "December";
            default:
                return "Please select a proper value";
        }
    }

    /**
     * This method takes in an int value and converts them to suitable day name.
     * For example: 1 = Sunday, 2 = Monday
     */
    public static String getDayNameForIntValue(int value) {
        switch (value) {
            case 1:
                return "Sunday";
            case 2:
                return "Monday";
            case 3:
                return "Tuesday";
            case 4:
                return "Wednesday";
            case 5:
                return "Thursday";
            case 6:
                return "Friday";
            case 7:
                return "Saturday";
            default:
                return "Please choose appropriate value";
        }
    }

    /**
     * This method takes in a date object and returns a string with the name of day
     */
    public static String getDayNameForDate(Date date) {
        @SuppressLint("SimpleDateFormat") SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEEE");
        return simpleDateFormat.format(date);
    }
}
