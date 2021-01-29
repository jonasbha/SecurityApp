package com.example.app.controller;

import android.content.Context;
import android.widget.Toast;

import com.example.core.model.repository.IAccountRepository;

public class LoginController {

    IAccountRepository repo;

    public LoginController(IAccountRepository repo) {
        this.repo = repo;
    }

    Context ctx;

    public void login(String username, String password) {

        if (repo.verifyCredentials(username, password))
            Toast.makeText(ctx, "U logged in succesfully", Toast.LENGTH_LONG).show();
        else
            Toast.makeText(ctx, "Ur out", Toast.LENGTH_LONG).show();
    }

    public void getContext(Context ctx) {
        this.ctx = ctx;
    }
}
