package com.example.core.model;

import com.example.core.model.user.RegisteredUser;
import com.example.core.model.user.Teacher;

public class Message {
    private boolean anonymous;
    private String text;
    private RegisteredUser sender;
    private Course course;

    public Message(String text, Course course, boolean anonymous) {
        this.text = text;
        this.course = course;
        this.anonymous = anonymous;
        addMessage();
    }

    public Message(String text, Course course) {
        this.text = text;
        this.course = course;
        addMessage();
    }

    public void setSender(RegisteredUser sender) {
        this.sender = sender;
    }

    private void addMessage() {
        course.addMessage(this);
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
}
