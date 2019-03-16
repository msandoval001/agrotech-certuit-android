package com.certuit.agroapp.util;

public class DateUtils {

    public static String getDateFormat(String date){

        String day = date.substring(0,2);
        String month = date.substring(3,5);
        String year = date.substring(6,10);

        return year + "-" + month + "-" + day;
    }
}
