package com.example.core.model.user;

import com.example.core.model.Course;
import com.example.core.model.Dialog;
import com.example.core.model.Message;

import java.util.List;

public class Student extends RegisteredUser {
    String studium;
    int yearOfClass;
    List<Course> courses;

    public Student(String name, String email, String password, String studium, int yearOfClass) {
        super(name, email, password);
        this.studium = studium;
        this.yearOfClass = yearOfClass;
    }

    public String getStudium() {
        return studium;
    }

    public void setStudium(String studium) {
        this.studium = studium;
    }

    public int getYearOfClass() {
        return yearOfClass;
    }

    public void setYearOfClass(int yearOfClass) {
        this.yearOfClass = yearOfClass;
    }

    @Override
    public boolean openDialog(Dialog dialog) {
        return this == dialog.getStudent();
    }

    @Override
    public boolean sendMessage(Message msg) {
        msg.setSender(this);
        msg.getDialog().addMessage(msg);
        return true;
    }

    @Override
    public String toString() {
        return "StudentAccount{" +
                "studium='" + studium + '\'' +
                ", yearOfClass=" + yearOfClass +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
