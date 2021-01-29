package com.example.core.model.account;

import com.example.core.model.account.RegisteredUser;

public class Teacher extends RegisteredUser {
    String img;


    public Teacher(String name, String email, String password, String img) {
        super(name, email, password);
        this.img = img;
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
