package com.example.core.model;

import java.util.List;

public class Course {
    String courseCode;
    int PIN;
    List<Message> messages;

    public Course(String courseCode, int PIN) {
        this.courseCode = courseCode;
        this.PIN = PIN;
    }

    private void addMessage(Message msg) {
        messages.add(msg);
    }
}
