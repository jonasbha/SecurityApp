package com.example.core.model;

import java.util.ArrayList;
import java.util.List;

public class Course {
    private String courseCode;
    private int PIN;
    private List<Message> messages = new ArrayList<>();

    public Course(String courseCode, int PIN) {
        this.courseCode = courseCode;
        this.PIN = PIN;
    }

    public void addMessage(Message msg) {
        messages.add(msg);
    }

    public List<Message> getMessages() {
        return messages;
    }
}
