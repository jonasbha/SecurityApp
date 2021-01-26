package com.example.core.model;

import com.example.core.model.user.RegisteredUser;

import java.util.Stack;

public class Dialog {
    private Stack<Message> messages = new Stack<>();
    private RegisteredUser student, teacher;
    private Course course;
    private int id;

    public Dialog(RegisteredUser student, RegisteredUser teacher, Course course, int id) {
        this.student = student;
        this.teacher = teacher;
        this.id = id;
        this.course = course;
        course.addDialog(this);
    }

    public void addMessage(Message msg) {
        messages.push(msg);
    }

    public Message getMessage(Message msg) {
        return msg;
    }

    public Stack<Message> getMessages() {
        return messages;
    }
}
