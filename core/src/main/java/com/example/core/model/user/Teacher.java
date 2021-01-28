package com.example.core.model.user;

import com.example.core.model.Course;
import com.example.core.model.Dialogue;
import com.example.core.model.Message;
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
    public boolean openDialog(Dialogue dialogue) {
        return this == dialogue.getTeacher();
    }

    @Override
    public boolean sendMessage(Message msg) {
        if (msg.getDialogue().getMessages().size() != 0)
            if (msg.getDialogue().getMessages().peek().getSender() == this)
                return false;
        msg.setSender(this);
        msg.getDialogue().addMessage(msg);
        return true;
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
