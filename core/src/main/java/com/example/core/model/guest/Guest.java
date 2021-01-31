package com.example.core.model.guest;

import com.example.core.model.course.Course;
import com.example.core.model.course.GuestComment;
import com.example.core.model.course.Message;
import com.example.core.model.course.Report;

public class Guest {

    public Guest() {}

    void printCourseReport() {}

    public Report reportMessage(Message message, String issue) {
        return new Report(message, issue);
    }

    public void comment(Message message, GuestComment guestComment) {
        message.getComments().add(guestComment);
    }

    public Course getCourse(Course course, int PIN) throws Exception {
        if (course.getPIN() == PIN)
            return course;
        throw new Exception("Wrong PIN-code.");
    }
}
