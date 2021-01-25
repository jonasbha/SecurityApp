package com.example.core.model.account;

public interface Account {

    boolean loggInn();

    boolean changePassword(String password);

    String recoverPassword();
}
