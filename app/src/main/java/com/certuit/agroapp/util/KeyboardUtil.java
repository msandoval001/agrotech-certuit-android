package com.certuit.agroapp.util;

import android.content.Context;
import android.view.inputmethod.InputMethodManager;

import androidx.appcompat.app.AppCompatActivity;

public class KeyboardUtil {

    private KeyboardUtil(){}

    public static void hideKeyboard(AppCompatActivity activity){
        InputMethodManager inputMethodManager =
                (InputMethodManager) activity.getSystemService(Context.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(activity.getWindow().getDecorView().getWindowToken(),0);
    }
}
