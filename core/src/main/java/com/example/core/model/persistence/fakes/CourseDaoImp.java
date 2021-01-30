package com.example.core.model.persistence.fakes;

import com.example.core.model.Course;
import com.example.core.model.persistence.daos.ICourseDao;

import java.util.ArrayList;
import java.util.List;

public class CourseDaoImp implements ICourseDao {

    ArrayList<Course> courses = new ArrayList<>();

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
