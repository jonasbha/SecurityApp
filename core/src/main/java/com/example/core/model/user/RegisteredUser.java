package com.example.core.model.user;

import com.example.core.model.Dialogue;
import com.example.core.model.Message;
import com.example.core.model.account.IAccount;
import com.example.core.model.account.ICommunication;

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
    public void requestNewPasswordLink(String email) {}

    @Override
    public boolean changePassword(String password) {
        setPassword(password);
        return true;
    }

    @Override
    public boolean sendMessage(Message msg) {
        msg.setSender(this);
        msg.getDialogue().addMessage(msg);
        return true;
    }

    @Override
    public List<Dialogue> listAllDialogs() {
        return null;
    }


    public String getName() {
        return name;
    }

    private void setPassword(String password) {
        this.password = password;
    }
}
