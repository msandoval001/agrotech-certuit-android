package com.certuit.agroapp.util;

import android.text.TextUtils;
import android.util.Patterns;

import org.joda.time.Hours;
import org.joda.time.LocalDate;

import java.util.Calendar;

public class ValidatorUtil {
    private ValidatorUtil() {
    }

    public static final int VALID = 0;
    public static final int EMPTY_TEXT = 1;
    public static final int INVALID_EMAIL = 2;
    public static final int INVALID_CHARACTERS = 3;
    public static final int INVALID_LENGHT = 4;
    public static final int INVALID_PASSWORD = 5;
    public static final int PASSWORD_TOO_SHORT = 6;
    public static final int PASSWORD_NO_NUMBERS = 7;
    public static final int PASSWORD_NO_UPPER_LOWER_CASE = 8;
    public static final int PASSWORD_ONLY_NUMBERS = 9;
    public static final int INVALID_RFC_FORMAT = 10;

    public static int validatePassword(String password, String confirmation) {

        if (isEmpty(password)) {
            return EMPTY_TEXT;
        }


        if (password.length() < 8) {
            return PASSWORD_TOO_SHORT;
        }

        boolean allLetters = true;
        for (Character character : password.toCharArray()) {
            if (Character.isDigit(character)) {
                allLetters = false;
                break;
            }
        }

        if (allLetters) {
            return PASSWORD_NO_NUMBERS;
        }

        boolean allNumbers = true;
        for (Character character : password.toCharArray()) {
            if (Character.isAlphabetic(character)) {
                allNumbers = false;
                break;
            }
        }

        if (allNumbers) {
            return PASSWORD_ONLY_NUMBERS;
        }

        if (password.length() != confirmation.length()) {
            return INVALID_PASSWORD;
        }

        for (int i = 0; i < password.length(); i++) {
            if (password.charAt(i) != confirmation.charAt(i)) {
                return INVALID_PASSWORD;
            }
        }

        return VALID;
    }

    public static int validateName(String name) {
        if (isEmpty(name)) {
            return EMPTY_TEXT;
        }

        if (!checkAlpha(name)) {
            return INVALID_CHARACTERS;
        }

        return VALID;
    }

    public static int validateEmail(String email) {
        if (isEmpty(email)) {
            return EMPTY_TEXT;
        }

        if (!checkValidEmail(email)) {
            return INVALID_EMAIL;
        }

        return VALID;
    }

    public static int validatePhone(String phone) {
        if (isEmpty(phone)) {
            return EMPTY_TEXT;
        }

        if (!checkNumeric(phone)) {
            return INVALID_CHARACTERS;
        }

        if (phone.length() < 7) {
            return INVALID_LENGHT;
        }

        if (phone.length() > 7 && phone.length() < 10) {
            return INVALID_LENGHT;
        }

        if (phone.length() > 16) {
            return INVALID_LENGHT;
        }

        return VALID;
    }

    public static int validateRFC(String rfc) {
        if (isEmpty(rfc)) {
            return EMPTY_TEXT;
        }

        if (rfc.length() != 13) {
            return INVALID_LENGHT;
        }

        if (!checkRFC(rfc)) {
            return INVALID_RFC_FORMAT;
        }

        return VALID;
    }

    public static int validateStreet(String street) {
        if (isEmpty(street)) {
            return EMPTY_TEXT;
        }

        if (!checkAlphaNumericSpecial(street)) {
            return INVALID_CHARACTERS;
        }

        return VALID;
    }


    private static boolean isEmpty(String text) {
        return (TextUtils.isEmpty(text));
    }


    private static boolean checkAlpha(String text) {
        String toCheck = text.replaceAll(" ", "");
        for (int i = 0; i < toCheck.length(); i++) {
            char c = toCheck.charAt(i);
            if (!Character.isAlphabetic(c))
                return false;
        }
        return true;
    }

    public static boolean checkNumeric(String numbers) {
        for (int i = 0; i < numbers.length(); i++) {
            if (!Character.isDigit(numbers.charAt(i)))
                return false;
        }
        return true;
    }

    private static boolean checkRFC(String text) {
        for (int i = 0; i < text.length(); i++) {
            char letter = text.charAt(i);
            if ((i <= 3 && !Character.isAlphabetic(letter)) || (i > 3 && i <= 9 && !Character.isDigit(letter))) {
                return false;
            }
        }
        return true;
    }

    private static boolean checkAlphaNumericSpecial(String text) {
        for (int i = 0; i < text.length(); i++) {
            if (!Character.isAlphabetic(text.charAt(i)) && !Character.isDigit(text.charAt(i)) &&
                    text.charAt(i) != ' ' && text.charAt(i) != '.') {
                return false;
            }
        }
        return true;
    }

    private static boolean checkValidEmail(String email) {
        return (!TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches());
    }

    public static int getHoursDifference(Calendar begining, Calendar end) {
        LocalDate d1 = new LocalDate(begining.getTimeInMillis());
        LocalDate d2 = new LocalDate(end.getTimeInMillis());
        return Hours.hoursBetween(d1, d2).getHours();
    }
}
