package com.example.core.model.persistence.fakes;

import com.example.core.model.user_account.Teacher;
import com.example.core.model.persistence.daos.ITeacherDao;

import java.util.ArrayList;

public class TeacherDaoImp implements ITeacherDao {

    ArrayList<Teacher> teachers = new ArrayList<>();

    @Override
    public void create(Teacher teacher) {
        teachers.add(teacher);
    }

    @Override
    public Teacher read(Teacher teacher) {
        for (int i = 0; i < teachers.size(); i++)
            if (teachers.get(i) == teacher)
                return teacher;
        return null;
    }
}
