package com.example.app;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.app.controller.LoginController;
import com.example.core.model.repository.FakeRepo;

public class MainActivity extends AppCompatActivity {

    LoginController loginController;

    private EditText username;
    private EditText password;
    private Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loginController = new LoginController(new FakeRepo());

        username = findViewById(R.id.etUsername);
        password = findViewById(R.id.etPassword);
        login = findViewById(R.id.loginBtn);

        login.setOnClickListener(v -> loginController.login(username.getText().toString(), password.getText().toString()));
    }
}