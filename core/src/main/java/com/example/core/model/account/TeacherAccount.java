package com.example.core.model.account;

import com.example.core.model.Course;

import java.util.List;

public class TeacherAccount extends Account implements ITeacherAccount {
    String img;

    public TeacherAccount(String name, String email, String img) {
        super(name, email);
        this.img = img;
    }

    @Override
    public List<Course> listCourses() {
        return null;
    }

}
