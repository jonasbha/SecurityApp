package com.example.core.model;

import java.util.ArrayList;
import java.util.List;

public class Course {
    private String courseCode;
    private int PIN;
    private List<Dialog> dialogs = new ArrayList<>();

    public Course(String courseCode, int PIN) {
        this.courseCode = courseCode;
        this.PIN = PIN;
    }

    public void addDialog(Dialog dialog) {
        dialogs.add(dialog);
    }

    public List<Dialog> getDialogs() {
        return dialogs;
    }
}
