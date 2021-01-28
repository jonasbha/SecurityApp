package com.example.core.model.account;

import com.example.core.model.Course;

import java.util.List;

public interface TeacherAccount {

    List<Course> getCourses();

    void addCourse(Course course);

    Course getCourse(Course course);
}
