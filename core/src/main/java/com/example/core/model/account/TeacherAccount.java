package com.example.core.model.account;

import com.example.core.model.Course;
import com.example.core.model.Message;
import com.example.core.model.user.Teacher;

import java.util.List;

public class TeacherAccount implements ITeacherAccount, IAccount, ICommunication {
    String name;
    String email;
    String img;

    public TeacherAccount(String name, String email, String img) {
        this.name = name;
        this.email = email;
        this.img = img;
    }

    @Override
    public boolean loggInn() {
        return false;
    }

    @Override
    public boolean changePassword(String password) {
        return false;
    }

    @Override
    public String recoverPassword() {
        return null;
    }

    @Override
    public List<Course> listCourses() {
        return null;
    }

    @Override
    public Message sendMessage() {
        return null;
    }

    @Override
    public List<Message> openReceivedMessage() {
        return null;
    }
}
