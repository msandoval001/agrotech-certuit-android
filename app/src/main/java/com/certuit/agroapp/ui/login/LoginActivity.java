package com.certuit.agroapp.ui.login;

import android.content.Intent;
import android.os.Bundle;

import com.certuit.agroapp.R;
import com.certuit.agroapp.ui.dashboard.MainActivity;
import com.certuit.agroapp.ui.sign_up.SignUpActivity;
import com.google.android.material.textfield.TextInputEditText;

import androidx.appcompat.app.AppCompatActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends AppCompatActivity {

    @BindView(R.id.email)
    protected TextInputEditText email;
    @BindView(R.id.password)
    protected TextInputEditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

    }


    @OnClick(R.id.login_ok)
    public void onLogin() {
        Intent loginIntent = new Intent(this, MainActivity.class);
        loginIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(loginIntent);
    }

    @OnClick(R.id.register)
    public void onRegister() {
        Intent signupIntent = new Intent(this, SignUpActivity.class);
        startActivity(signupIntent);
    }

    @OnClick(R.id.lostPassword)
    public void onLostPassword() {

    }
}
