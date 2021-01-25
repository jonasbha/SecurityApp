package com.example.core.model;

import com.example.core.model.user.RegisteredUser;

import java.util.UUID;

public class Message {
    private boolean anonymous;
    private String text;
    private RegisteredUser sender;
    private Course receiver;

    public Message(String text, Course receiver, boolean anonymous) {
        this.text = text;
        this.receiver = receiver;
        this.anonymous = anonymous;
        addMessage();
    }

    public void setSender(RegisteredUser sender) {
        this.sender = sender;
    }

    private void addMessage() {
        receiver.addMessage(this);
    }

    public RegisteredUser getSender() {
        if (anonymous)
            return null;
        return sender;
    }
}
