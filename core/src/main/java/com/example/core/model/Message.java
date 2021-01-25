package com.example.core.model;

import com.example.core.model.user.RegisteredUser;

public class Message {
    RegisteredUser sender;
    Course receiver;

    public Message(RegisteredUser sender, Course receiver) {
        this.sender = sender;
        this.receiver = receiver;
    }
}
