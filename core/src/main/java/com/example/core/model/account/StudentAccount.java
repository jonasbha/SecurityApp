package com.example.core.model.account;

import com.example.core.model.Message;
import com.example.core.model.user.Student;

import java.util.List;

public class StudentAccount extends Account {
    String studium;
    int yearOfClass;

    public StudentAccount(String name, String email, String studium, int yearOfClass) {
        super(name, email);
        this.studium = studium;
        this.yearOfClass = yearOfClass;
    }

}
