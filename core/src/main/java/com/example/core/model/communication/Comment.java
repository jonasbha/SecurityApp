package com.example.core.model.communication;

public abstract class Comment {
    String text;
    Message msg;

    public Comment(String text, Message msg) {
        this.text = text;
        this.msg = msg;
    }

    public boolean send() {
        msg.getComments().add(this);
        return true;
    }

    public String getText() {
        return text;
    }
}
