package com.example.core.model.account;

import com.example.core.model.communication.Message;
import com.example.core.model.account.Teacher;

import java.util.ArrayList;
import java.util.List;


public class Course {
    private String courseCode;
    private int PIN;
    Teacher teacher;
    List<Message> messages = new ArrayList<>();

    public Course(String courseCode, int PIN, Teacher teacher) {
        this.courseCode = courseCode;
        this.PIN = PIN;
        this.teacher = teacher;
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
