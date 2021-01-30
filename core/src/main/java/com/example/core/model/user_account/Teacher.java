package com.example.core.model.user_account;

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
