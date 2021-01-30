package com.example.core.model.persistence.daos;

import com.example.core.model.user_account.Teacher;

public interface ITeacherDao {

    void create(Teacher teacher);

    Teacher read(Teacher teacher);
}
