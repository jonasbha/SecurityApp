package com.example.core.model.course;

import com.example.core.model.user_account.Student;

import java.util.ArrayList;
import java.util.List;

public class Message {
    private final Student sender;
    private String text;
    private final boolean anonymous;
    private boolean hasBeenAnswered;
    private final Course course;
    private final List<com.example.core.model.course.Comment> comments = new ArrayList<>();
    int id;

    public Message(Student sender, Course course, String text, boolean anonymous) {
        this.sender = sender;
        this.text = text;
        this.course = course;
        this.anonymous = anonymous;
    }

    public void send() {
        course.getMessages().add(this);
    }

    public String getSender() {
        if (anonymous)
            return "Anonymous";
        return sender.getName();
    }

    public String getText() {
        return text;
    }

    public Course getCourse() {
        return course;
    }

    public List<com.example.core.model.course.Comment> getComments() {
        return comments;
    }

    public com.example.core.model.course.Comment getComment(Comment comment) {
        for (int i = 0; i < comments.size(); i++) {
            if (comments.get(i) == comment)
                return comment;
        }
        return null;
    }

    public boolean hasBeenAnswered() {
        return hasBeenAnswered;
    }

    public void setHasBeenAnswered(boolean hasBeenAnswered) {
        this.hasBeenAnswered = hasBeenAnswered;
    }
}
