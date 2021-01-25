package com.example.core.model.account;

import com.example.core.model.Message;
import com.example.core.model.user.Student;

import java.util.List;

public class StudentAccount implements IAccount, ICommunication {
    String name;
    String email;
    String studium;
    int yearOfClass;

    public StudentAccount(String name, String email, String studium, int yearOfClass) {
        this.name = name;
        this.email = email;
        this.studium = studium;
        this.yearOfClass = yearOfClass;
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
    public Message sendMessage() {
        return null;
    }

    @Override
    public List<Message> openReceivedMessage() {
        return null;
    }
}
