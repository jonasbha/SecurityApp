package com.example.core.model.account;

import com.example.core.model.Course;

import java.util.List;

public interface TeacherAccount {

    List<Course> listCourses();

    void register(String name, String email, String img);
}
