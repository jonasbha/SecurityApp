package com.example.core.model;

import java.util.ArrayList;
import java.util.List;

public class Course {
    private String courseCode;
    private int PIN;
    private List<Dialogue> dialogues = new ArrayList<>();

    public Course(String courseCode, int PIN) {
        this.courseCode = courseCode;
        this.PIN = PIN;
    }

    public void addDialogue(Dialogue dialogue) {
        dialogues.add(dialogue);
    }

    public List<Dialogue> getDialogues() {
        return dialogues;
    }

    public int getPIN() {
        return PIN;
    }
}
