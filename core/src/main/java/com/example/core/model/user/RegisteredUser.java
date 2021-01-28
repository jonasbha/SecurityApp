package com.example.core.model.user;

import com.example.core.model.account.Account;

public abstract class RegisteredUser implements Account {
    String name;
    String email;
    String password;

    public RegisteredUser(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    @Override
    public boolean loggInn(String username, String password) {
        return false;
    }

    @Override
    public void requestNewPasswordLink(String email) {}

    @Override
    public boolean changePassword(String password) {
        setPassword(password);
        return true;
    }

    public String getName() {
        return name;
    }

    private void setPassword(String password) {
        this.password = password;
    }
}
