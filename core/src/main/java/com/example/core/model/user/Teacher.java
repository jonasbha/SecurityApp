package com.example.core.model.user;

import com.example.core.model.Course;
import com.example.core.model.account.ITeacherAccount;

import java.util.ArrayList;
import java.util.List;

public class Teacher extends RegisteredUser implements ITeacherAccount {
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
