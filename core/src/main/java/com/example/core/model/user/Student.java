package com.example.core.model.user;

import com.example.core.model.Course;
import com.example.core.model.account.StudentAccount;

import java.util.List;

public class Student extends RegisteredUser implements StudentAccount {

    String studium;
    List<Course> courses;
    int yearOfClass;

    @Override
    public void register(String name, String email, String studium, int yearOfClass) {

    }
}
