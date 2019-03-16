package com.certuit.agroapp.ui.splash_screen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.certuit.agroapp.R;
import com.certuit.agroapp.ui.dashboard.MainActivity;
import com.certuit.agroapp.ui.login.LoginActivity;
import com.certuit.agroapp.util.SharedPreferencesConnector;

public class SplashScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SharedPreferencesConnector connector = SharedPreferencesConnector.getInstance(this);

        if (connector.readBoolean(String.valueOf(R.string.login))){
            startActivity(new Intent(this, MainActivity.class));
        }else {
            startActivity(new Intent(this, LoginActivity.class));
        }

    }
}
