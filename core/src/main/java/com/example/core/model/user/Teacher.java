package com.example.core.model.user;

import com.example.core.model.Course;
import com.example.core.model.account.ITeacherAccount;

import java.util.List;

public class Teacher extends RegisteredUser implements ITeacherAccount {
    String img;
    List<Course> courses;

    public Teacher(String name, String email, String password, String img) {
        super(name, email, password);
        this.img = img;
    }

    @Override
    public List<Course> listCourses() {
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
