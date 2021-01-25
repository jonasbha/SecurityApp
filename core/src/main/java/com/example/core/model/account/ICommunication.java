package com.example.core.model.account;

import com.example.core.model.Message;

import java.util.List;

public interface ICommunication {
    void sendMessage(Message message);
    List<Message> openReceivedMessage();
}
