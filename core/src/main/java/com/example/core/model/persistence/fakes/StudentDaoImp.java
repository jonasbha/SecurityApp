package com.example.core.model.persistence.fakes;

import com.example.core.model.user_account.Student;
import com.example.core.model.persistence.daos.IStudentDao;

import java.util.ArrayList;

public class StudentDaoImp implements IStudentDao {

    ArrayList<Student> students = new ArrayList<>();

    @Override
    public void create(Student student) {
        students.add(student);
    }

    @Override
    public Student read(Student student) {
        for (int i = 0; i < students.size(); i++)
            if (students.get(i) == student)
                return student;
        return null;
    }
}
