package com.certuit.agroapp.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailUtils {

    private EmailUtils() {}

    public static boolean isValidEmail(String email){
        String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
        Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
}
