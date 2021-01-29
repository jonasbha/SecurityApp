package com.example.core.model.persistence.temp;

import com.example.core.model.account.Course;
import com.example.core.model.communication.Report;
import com.example.core.model.persistence.IAccountRepository;
import com.example.core.model.account.Student;
import com.example.core.model.account.Teacher;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AccountRepository implements IAccountRepository {

    HashMap<String, String> credentials = new HashMap<>();
    ArrayList<Report> reports = new ArrayList<>();
    ArrayList<Student> students = new ArrayList<>();
    ArrayList<Teacher> teachers = new ArrayList<>();
    ArrayList<Course> courses = new ArrayList<>();

    @Override
    public boolean verifyCredentials(String username, String password) {

        for (Map.Entry<String, String> set : credentials.entrySet())
            if (set.getKey().equals(username) && set.getValue().equals(password))
                return true;
        return false;
    }

    @Override
    public void addCredential(String username, String password) {
        credentials.put(username, password);
    }

    @Override
    public void updatePassword(String username, String password) {
        for (Map.Entry<String, String> set : credentials.entrySet()) {
            if (set.getKey().equals(username))
                set.setValue(password);
        }
    }

    @Override
    public void updateUsername(String username) {
        for (Map.Entry<String, String> set : credentials.entrySet()) {
            if (set.getKey().equals(username)) {
                String password = set.getValue();
                credentials.remove(username);
                credentials.put(username, password);
            }

        }
    }

    @Override
    public void registerStudent(Student student) {
        students.add(student);
    }

    @Override
    public Student getStudent(Student student) {
        for (int i = 0; i < students.size(); i++)
            if (students.get(i) == student)
                return student;
        return null;
    }

    @Override
    public void registerTeacher(Teacher teacher) {
        teachers.add(teacher);
    }

    @Override
    public Teacher getTeacher(Teacher teacher) {
        for (int i = 0; i < teachers.size(); i++)
            if (teachers.get(i) == teacher)
                return teacher;
        return null;
    }

    @Override
    public List<Course> getCourses() {
        return courses;
    }

    @Override
    public void addCourse(Course course) {
        courses.add(course);
    }

    @Override
    public Course getCourse(Course course) {
        return course;
    }

    @Override
    public void addReport(Report report) {
        reports.add(report);
    }

    @Override
    public Report getReport(Report report) {
        return report;
    }

}
