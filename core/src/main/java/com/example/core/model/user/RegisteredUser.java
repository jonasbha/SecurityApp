package com.example.core.model.user;

import com.example.core.model.account.Account;

public abstract class RegisteredUser {
    String password;
    String name;
    String email;
    Account account;

    public RegisteredUser(String password, String name, String email) {
        this.password = password;
        this.name = name;
        this.email = email;
    }

    public RegisteredUser() {

    }

    public Account getAccount() {
        return account;
    }
}
