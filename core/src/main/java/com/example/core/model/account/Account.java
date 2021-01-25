package com.example.core.model.account;

import com.example.core.model.Message;

import java.util.List;

public abstract class Account implements IAccount, ICommunication {
    String name;
    String email;

    public Account(String name, String email) {
        this.name = name;
        this.email = email;
    }

    @Override
    public boolean loggInn() {
        return false;
    }

    @Override
    public boolean changePassword(String password) {
        return false;
    }

    @Override
    public String recoverPassword() {
        return null;
    }

    @Override
    public Message sendMessage() {
        return null;
    }

    @Override
    public List<Message> openReceivedMessage() {
        return null;
    }
}
