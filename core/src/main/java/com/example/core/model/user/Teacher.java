package com.example.core.model.user;

import com.example.core.model.Course;
import com.example.core.model.account.TeacherAccount;

import java.util.ArrayList;
import java.util.List;

public class Teacher extends RegisteredUser implements TeacherAccount {
    String img;
    List<Course> courses = new ArrayList<>();

    public Teacher(String name, String email, String password, String img) {
        super(name, email, password);
        this.img = img;
    }

    @Override
    public List<Course> getCourses() {
        return courses;
    }

    @Override
    public void addCourse(Course course) {
        courses.add(course);
        course.setTeacher(this);
    }

    @Override
    public Course getCourse(Course course) {
        for (int i = 0; i < courses.size(); i++) {
            if (courses.get(i) == course)
                return course;
        }
        return null;
    }

    @Override
    public String toString() {
        return "TeacherAccount{" +
                "img='" + img + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
