package com.example.core.model;

import com.example.core.model.user.RegisteredUser;
import com.example.core.model.user.Teacher;

import java.util.ArrayList;
import java.util.List;

public class Message {
    private RegisteredUser sender;
    private String text;
    private Dialog dialog;
    private boolean anonymous;
    private List<String> comments = new ArrayList<>();

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

    public void addComment(String comment) {
        comments.add(comment);
    }

    public List<String> getComments() {
        return comments;
    }
}
