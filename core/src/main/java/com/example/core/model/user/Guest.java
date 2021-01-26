package com.example.core.model.user;

import com.example.core.model.Course;
import com.example.core.model.Message;
import com.example.core.model.Report;

public class Guest {

    public Guest() {}

    void printCourseReport() {}

    public Report reportMessage(Message message, String issue) {
        return new Report(message, issue);
    }

    public void comment(Message message, String comment) {
        message.addComment(comment);
    }

    public Course getCourse(Course course, int PIN) throws Exception {
        if (course.getPIN() == PIN)
            return course;
        throw new Exception("Wrong PIN-code.");
    }
}
