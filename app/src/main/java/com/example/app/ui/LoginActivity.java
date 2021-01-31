package com.example.app.ui;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.app.R;
import com.example.app.controller.AccountController;
import com.example.core.model.persistence.fakes.FakeAccountRepository;

public class LoginActivity extends AppCompatActivity {

    AccountController accountController;

    private EditText username;
    private EditText password;
    Button login;
    Button guestLogin;
    Button register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeVariables();

        login.setOnClickListener(v -> accountController.login(username.getText().toString(), password.getText().toString()));
        register.setOnClickListener(v -> startActivity(new Intent(LoginActivity.this, RegisterActivity.class)));
        guestLogin.setOnClickListener(v -> startActivity(new Intent(LoginActivity.this, GuestLandingActivity.class)));
   }

    public void initializeVariables() {
        login = findViewById(R.id.loginBtn);
        guestLogin = findViewById(R.id.loginGuestBtn);
        register = findViewById(R.id.registerBtn);

        username = findViewById(R.id.etUsername);
        password = findViewById(R.id.etPassword);
        accountController = new AccountController(new FakeAccountRepository());
        accountController.getContext(getApplication());
    }
}