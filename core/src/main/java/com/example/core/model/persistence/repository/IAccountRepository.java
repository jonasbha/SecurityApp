package com.example.core.model.persistence.repository;

import com.example.core.model.course.Course;
import com.example.core.model.user_account.Student;
import com.example.core.model.user_account.Teacher;
import com.example.core.model.course.Report;

import java.util.List;

public interface IAccountRepository {

    boolean verifyCredentials(String username, String password);

    void addCredential(String username, String password);

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
