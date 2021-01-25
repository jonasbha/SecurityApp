package com.example.core.model.user;

import com.example.core.model.Course;
import com.example.core.model.account.StudentAccount;

import java.util.List;

public class Student extends RegisteredUser {

    String studium;
    int yearOfClass;

    List<Course> courses;

    public Student(String password, String name, String email, String studium, int yearOfClass) {
        super(password, name, email);
        this.studium = studium;
        this.yearOfClass = yearOfClass;
    }

    public Student() {
        super();
    }

    public void registerAccount(String studium, int yearOfClass) {
        this.account = new StudentAccount(this.name, this.email, this.studium, this.yearOfClass);
    }
}
