package com.example.core.model.account;

import com.example.core.model.account.RegisteredUser;

public class Student extends RegisteredUser {
    String studium;
    int yearOfClass;

    public Student(String name, String email, String password, String studium, int yearOfClass) {
        super(name, email, password);
        this.studium = studium;
        this.yearOfClass = yearOfClass;
    }

    public String getStudium() {
        return studium;
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
