package com.example.core.model.account;

public abstract class RegisteredUser {
    String name;
    String email;
    String password;

    public RegisteredUser(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    private void setPassword(String password) {
        this.password = password;
    }
}
