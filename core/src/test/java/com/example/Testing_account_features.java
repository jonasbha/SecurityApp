package com.example;

import com.example.core.model.user.Student;

import org.junit.Test;
import static org.junit.Assert.*;


public class Testing_account_features {

    @Test
    public void registeringNewStudentAccountSucceeds() {
        Student student = new Student();
        student.registerAccount("Datasikkerhet", 2020);

        assertNotNull(student.getAccount());
    }

    @Test
    public void studentCanLoggInn() {
        Student student = new Student();
        //student.registerAccount();
    }

}
