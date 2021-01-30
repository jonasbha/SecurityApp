package com.example.core.model.persistence.daos;

import com.example.core.model.Course;

import java.util.List;

public interface ICourseDao {

    void create(Course course);

    Course read(Course course);

    List<Course> readAll();
}
