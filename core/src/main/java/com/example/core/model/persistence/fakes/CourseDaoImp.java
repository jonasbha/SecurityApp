package com.example.core.model.persistence.fakes;

import com.example.core.model.Course;
import com.example.core.model.communication.GuestComment;
import com.example.core.model.communication.Message;
import com.example.core.model.communication.TeacherComment;
import com.example.core.model.persistence.daos.ICourseDao;
import com.example.core.model.user_account.Student;
import com.example.core.model.user_account.Teacher;

import java.util.ArrayList;
import java.util.List;

public class CourseDaoImp implements ICourseDao {

    ArrayList<Course> courses = new ArrayList<>();

    public CourseDaoImp() {
        Teacher olav = new Teacher("Olav Lærer", null, null, null);
        Course course1 = new Course("ITF25019-1 21V", 123, olav);
        Message msg1 = new Message(new Student("Svein", null, null, null, 2020), course1, "Hei paa deg", false);
        TeacherComment teacherComment = new TeacherComment("Velkommen til faget", msg1, olav);
        course1.getMessages().add(msg1);
        GuestComment comment1 = new GuestComment("Dette er en kommentar.", msg1);
        GuestComment comment2 = new GuestComment("Dette er enda en kommentar til.", msg1);

        msg1.getComments().add(teacherComment);
        msg1.getComments().add(comment1);
        msg1.getComments().add(comment2);

        Course course2 = new Course("ITF12345-1 21V Filler Course", 456, null);
        courses.add(course1);
        courses.add(course2);
    }

    @Override
    public void create(Course course) {
        courses.add(course);
    }

    @Override
    public Course read(Course course) {
        return course;
    }

    @Override
    public List<Course> readAll() {
        return courses;
    }
}
