package com.example.core.model.account;

public interface IAccount {

    boolean loggInn();

    boolean changePassword(String password);

    String recoverPassword();

}
