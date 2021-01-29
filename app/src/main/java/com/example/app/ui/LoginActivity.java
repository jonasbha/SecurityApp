package com.example.app.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.app.R;
import com.example.app.controller.LoginController;
import com.example.core.model.persistence.temp.AccountRepository;

public class LoginActivity extends AppCompatActivity {

    LoginController loginController;

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

        login.setOnClickListener(v -> loginController.login(username.getText().toString(), password.getText().toString()));
        register.setOnClickListener(v -> startActivity(new Intent(LoginActivity.this, RegisterActivity.class)));
        guestLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    public void initializeVariables() {
        login = findViewById(R.id.loginBtn);
        guestLogin = findViewById(R.id.loginGuestBtn);
        register = findViewById(R.id.registerBtn);

        username = findViewById(R.id.etUsername);
        password = findViewById(R.id.etPassword);
        loginController = new LoginController(new AccountRepository());
        loginController.getContext(getApplication());
    }
}