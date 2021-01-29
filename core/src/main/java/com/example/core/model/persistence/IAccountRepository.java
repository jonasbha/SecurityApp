package com.example.core.model.persistence;

import com.example.core.model.account.Course;
import com.example.core.model.account.Student;
import com.example.core.model.account.Teacher;
import com.example.core.model.communication.Report;

import java.util.List;

public interface IAccountRepository {

    boolean verifyCredentials(String username, String password);

    void addCredential(String username, String password);

    void updatePassword(String username, String password);

    void updateUsername(String username);

    void registerStudent(Student student);

    Student getStudent(Student student);

    void registerTeacher(Teacher teacher);

    Teacher getTeacher(Teacher teacher);

    List<Course> getCourses();

    void addCourse(Course course);

    Course getCourse(Course course);

    void addReport(Report report);

    Report getReport(Report report);
}
