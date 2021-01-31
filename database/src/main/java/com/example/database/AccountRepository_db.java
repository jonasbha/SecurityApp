package com.example.database;

import com.example.core.model.course.Course;
import com.example.core.model.persistence.daos.ICourseDao;
import com.example.core.model.persistence.daos.IReportDao;
import com.example.core.model.persistence.daos.IStudentDao;
import com.example.core.model.persistence.daos.ITeacherDao;
import com.example.core.model.user_account.Student;
import com.example.core.model.user_account.Teacher;
import com.example.core.model.course.Report;
import com.example.core.model.persistence.repository.IAccountRepository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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

    @Override
    public boolean verifyCredentials(String username, String password) {
        Connection conn = connect();

        // hvorfor ikke ha egen credential tabell med email som pk?

        String studentCredentials = "SELECT email, password FROM Student;";
        String teacherCredentials = "SELECT email, password FROM Teacher;";
        try {
            Statement statement = conn.createStatement();
            ResultSet set1 = statement.executeQuery(studentCredentials);
            ResultSet set2 = statement.executeQuery(teacherCredentials);

            while (set1.next()) {
                if (set1.getString("email").equals(username) && set1.getString("password").equals(password))
                    return true;
            }
            while (set2.next()) {
                if (set2.getString("email").equals(username) && set2.getString("password").equals(password))
                    return true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    @Override
    public void addCredential(String username, String password) {
        Connection conn = connect();

        // does not work yet.
        String sqlQuery = "INSERT INTO ... (X, Y) VALUES (email, password)";
        try {
            conn.prepareStatement(sqlQuery).executeQuery(sqlQuery);

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
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