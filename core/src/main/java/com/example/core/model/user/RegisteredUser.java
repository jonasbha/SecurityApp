package com.example.core.model.user;

import com.example.core.model.Communication;
import com.example.core.model.Message;
import com.example.core.model.account.Account;

import java.util.List;

public abstract class RegisteredUser implements Account, Communication {
    String password;
    String name;
    String email;

    @Override
    public Message sendMessage() {
        return null;
    }

    @Override
    public List<Message> openReceivedMessage() {
        return null;
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
}
