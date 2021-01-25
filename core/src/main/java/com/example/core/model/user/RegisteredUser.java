package com.example.core.model.user;

import com.example.core.model.Message;
import com.example.core.model.account.IAccount;
import com.example.core.model.account.ICommunication;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public abstract class RegisteredUser implements IAccount, ICommunication {
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
    public void requestNewPasswordLink(String email) {

    }

    @Override
    public boolean changePassword(String password) {
        setPassword(password);
        return true;
    }

    @Override
    public Message sendMessage() {
        return null;
    }

    @Override
    public List<Message> openReceivedMessage() {
        return null;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    private void setPassword(String password) {
        this.password = password;
    }
}
