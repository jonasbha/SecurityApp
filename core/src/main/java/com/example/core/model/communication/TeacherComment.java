package com.example.core.model.communication;

import com.example.core.model.user_account.Teacher;

public class TeacherComment extends Comment {
    Teacher sender;

    public TeacherComment(String text, Message msg, Teacher sender) {
        super(text, msg);
        this.sender = sender;
        this.text = msg.getCourse().getTeacher().getName() + ": " + text;
    }

    public Teacher getSender() {
        return sender;
    }

    @Override
    public boolean send() {
        if (msg.hasBeenAnswered())
            return false;
        msg.getComments().add(this);
        msg.setHasBeenAnswered(true);
        return true;
    }
}
