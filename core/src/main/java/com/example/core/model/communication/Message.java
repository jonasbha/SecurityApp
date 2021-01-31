package com.example.core.model.communication;

import com.example.core.model.Course;
import com.example.core.model.user_account.Student;

import java.util.ArrayList;
import java.util.List;

public class Message {
    private final Student sender;
    private String text;
    private final boolean anonymous;
    private boolean hasBeenAnswered;
    private final Course course;
    private final List<Comment> comments = new ArrayList<>();
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

    public List<Comment> getComments() {
        return comments;
    }

    public Comment getComment(Comment comment) {
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
