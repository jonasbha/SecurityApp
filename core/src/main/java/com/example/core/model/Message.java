package com.example.core.model;

import com.example.core.model.user.RegisteredUser;
import com.example.core.model.user.Teacher;

public class Message {
    private RegisteredUser sender;
    private String text;
    private Dialog dialog;
    private boolean anonymous;

    public Message(String text, Dialog dialog, boolean anonymous) {
        this.text = text;
        this.dialog = dialog;
        this.anonymous = anonymous;
    }

    public Message(String text, Dialog dialog) {
        this.text = text;
        this.dialog = dialog;
    }

    public void setSender(RegisteredUser sender) {
        this.sender = sender;
    }


    public RegisteredUser getSender() {
        if (sender.getClass() == Teacher.class)
            anonymous = false;

        if (anonymous)
            return null;
        return sender;
    }

    public String getText() {
        return text;
    }

    public Dialog getDialog() {
        return dialog;
    }
}
