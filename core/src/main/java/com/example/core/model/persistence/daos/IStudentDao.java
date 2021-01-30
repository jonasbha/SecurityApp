package com.example.core.model.persistence.daos;

import com.example.core.model.user_account.Student;

public interface IStudentDao {
    //crud
    void create(Student student);

    Student read(Student student);
}
