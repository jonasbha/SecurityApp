package com.example.core.model.user;

public abstract class RegisteredUser {
    String password;
    String name;
    String email;

    public RegisteredUser(String password, String name, String email) {
        this.password = password;
        this.name = name;
        this.email = email;
    }
}
