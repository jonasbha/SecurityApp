package com.example.core.model;

import com.example.core.model.communication.Message;
import com.example.core.model.user.Teacher;

import java.util.ArrayList;
import java.util.List;


public class Course {
    private String courseCode;
    private int PIN;
    Teacher teacher;
    List<Message> messages = new ArrayList<>();

    public Course(String courseCode, int PIN) {
        this.courseCode = courseCode;
        this.PIN = PIN;
    }

    public int getPIN() {
        return PIN;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public Message getMessage(Message msg) {
        for (int i = 0; i < messages.size(); i++) {
            if (messages.get(i) == msg)
                return msg;
        }
        return null;
    }

    public Teacher getTeacher() {
        return teacher;
    }
}
