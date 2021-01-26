package com.example.core.model.account;

import com.example.core.model.Message;

import java.util.List;

public interface ICommunication {
    void sendMessage(Message msg);
    void openMessage(Message msg);
    List<Message> listAllDialogs();
}
