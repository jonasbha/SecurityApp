package com.example.core.model.persistence.fakes;

import com.example.core.model.Course;
import com.example.core.model.Report;
import com.example.core.model.persistence.daos.ICourseDao;
import com.example.core.model.persistence.daos.IReportDao;
import com.example.core.model.persistence.daos.ITeacherDao;
import com.example.core.model.persistence.repository.IAccountRepository;
import com.example.core.model.user_account.Student;
import com.example.core.model.user_account.Teacher;
import com.example.core.model.persistence.daos.IStudentDao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FakeAccountRepository implements IAccountRepository {

    HashMap<String, String> credentials = new HashMap<>();
    IReportDao reportDao = new ReportDaoImp();
    ITeacherDao teacherDao = new TeacherDaoImp();
    ICourseDao courseDao = new CourseDaoImp();
    IStudentDao studentDao = new StudentDaoImp();

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
