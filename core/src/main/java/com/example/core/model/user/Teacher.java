package com.example.core.model.user;

import com.example.core.model.Course;
import com.example.core.model.account.TeacherAccount;

import java.util.List;

public class Teacher extends RegisteredUser implements TeacherAccount {
    List<Course> courses;
    String img;

    @Override
    public List<Course> listCourses() {
        return null;
    }

    @Override
    public void register(String name, String email, String img) {

    }
}
