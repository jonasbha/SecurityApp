package com.example.core.model.user;

import com.example.core.model.Course;
import com.example.core.model.account.ITeacherAccount;

import java.util.List;

public class Teacher extends RegisteredUser implements ITeacherAccount {
    List<Course> courses;
    String img;

    public Teacher(String password, String name, String email, String img) {
        super(password, name, email);
        this.img = img;
    }

    @Override
    public List<Course> listCourses() {
        return null;
    }

    public void registerAccount(String name, String email, String img) {

    }
}