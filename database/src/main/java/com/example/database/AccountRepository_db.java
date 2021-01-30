package com.example.database;

import com.example.core.model.Course;
import com.example.core.model.persistence.daos.ICourseDao;
import com.example.core.model.persistence.daos.IReportDao;
import com.example.core.model.persistence.daos.IStudentDao;
import com.example.core.model.persistence.daos.ITeacherDao;
import com.example.core.model.persistence.fakes.CourseDaoImp;
import com.example.core.model.persistence.fakes.ReportDaoImp;
import com.example.core.model.persistence.fakes.StudentDaoImp;
import com.example.core.model.persistence.fakes.TeacherDaoImp;
import com.example.core.model.user_account.Student;
import com.example.core.model.user_account.Teacher;
import com.example.core.model.Report;
import com.example.core.model.persistence.repository.IAccountRepository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class AccountRepository_db implements IAccountRepository {

    ICourseDao courseDao = new CourseDaoImp_db();
    IReportDao reportDao = new ReportDaoImp_db();
    ITeacherDao teacherDao = new TeacherDaoImp_db();
    IStudentDao studentDao = new StudentDaoImp_db();

    Connection connect() {
        try {
            String url = "jdbc:mysql://158.39.188.206/";
            String userName = "datasikkerhet";
            String password = "/xu6U@$WN";

            return DriverManager.getConnection(url, userName, password);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
/*
    public boolean verifyCredentials(String username, String password) {

        for (Map.Entry<String, String> set : credentials.entrySet())
            if (set.getKey().equals(username) && set.getValue().equals(password))
                return true;
        return false;
    }
*/
    @Override
    public boolean verifyCredentials(String username, String password) {
        return false;
    }

    @Override
    public void addCredential(String username, String password) {

    }

    @Override
    public void registerStudent(Student student) {
        studentDao.create(student);
    }

    @Override
    public Student getStudent(Student student) {
        return studentDao.read(student);
    }

    @Override
    public void registerTeacher(Teacher teacher) {
        teacherDao.create(teacher);
    }

    @Override
    public Teacher getTeacher(Teacher teacher) {
        return teacherDao.read(teacher);
    }

    @Override
    public List<Course> getCourses() {
        return courseDao.readAll();
    }

    @Override
    public void addCourse(Course course) {
        courseDao.create(course);
    }

    @Override
    public Course getCourse(Course course) {
        return courseDao.read(course);
    }

    @Override
    public void addReport(Report report) {
        reportDao.create(report);
    }

    @Override
    public Report getReport(Report report) {
        return reportDao.read(report);
    }
}