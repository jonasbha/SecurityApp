package com.example.core.model;

import com.example.core.model.user.RegisteredUser;
import com.example.core.model.user.Teacher;

import java.util.ArrayList;
import java.util.List;

public class Message {
    private RegisteredUser sender;
    private String text;
    private Dialogue dialogue;
    private boolean anonymous;
    private List<String> comments = new ArrayList<>();
    int id;

    public Message(String text, Dialogue dialogue, boolean anonymous) {
        this.text = text;
        this.dialogue = dialogue;
        this.anonymous = anonymous;
    }

    public Message(String text, Dialogue dialogue) {
        this.text = text;
        this.dialogue = dialogue;
    }

    public void setSender(RegisteredUser sender) {
        this.sender = sender;
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

    public Dialogue getDialogue() {
        return dialogue;
    }

    public void addComment(String comment) {
        comments.add(comment);
    }

    public List<String> getComments() {
        return comments;
    }
}
