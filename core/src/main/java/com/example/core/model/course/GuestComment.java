package com.example.core.model.course;

public class GuestComment extends Comment {
    public GuestComment(String text, Message msg) {
        super(text, msg);
        this.text = "Guest: " + text;
    }
}
