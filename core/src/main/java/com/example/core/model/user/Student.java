package com.example.core.model.user;

import com.example.core.model.Course;

import java.util.List;

public class Student extends RegisteredUser {

    String studium;
    List<Course> courses;
    int yearOfClass;

    public Student(String password, String name, String email, String studium, int yearOfClass) {
        super(password, name, email);
        this.studium = studium;
        this.yearOfClass = yearOfClass;
    }


    public void registerAccount(String studium, int yearOfClass) {

    }
}
