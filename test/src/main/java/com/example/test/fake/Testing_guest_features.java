package com.example.test.fake;

import com.example.core.model.Course;
import com.example.core.model.Report;
import com.example.core.model.communication.GuestComment;
import com.example.core.model.communication.Message;
import com.example.core.model.guest.Guest;
import com.example.core.model.persistence.repository.IAccountRepository;
import com.example.core.model.user_account.Student;
import com.example.core.model.user_account.Teacher;
import com.example.test.fake.PersistenceSupport;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class Testing_guest_features {

    protected PersistenceSupport persistenceSupport;

    @Before
    public void initialize_repository() {
        persistenceSupport = new PersistenceSupport();
    }

    public IAccountRepository repo() {
        return persistenceSupport.getAccountRepository();
    }

    private Guest guest;
    private Teacher teacher;
    private Student student;
    private Course course;

    @Before
    public void initialize_constant_fake_variables() {
        guest = new Guest();
        teacher = new Teacher("Gunnar", null, null, null);
        student = new Student("Geir", null, null, null, 2020);
        course = new Course("ITF123456", 123, teacher);
    }

    @Test
    public void guest_can_access_messages_in_a_course_when_valid_PIN_is_given() throws Exception {
        Message msg = new Message(student, course,"Hello", false);
        msg.send();

        assertEquals("Hello", guest.getCourse(course, 123).getMessage(msg).getText());
    }

    @Test
    public void guest_can_not_access_course_when_invalid_PIN_is_given() {
        Throwable e = assertThrows(Exception.class, () -> guest.getCourse(course, 13));
        assertEquals("Wrong PIN-code.", e.getMessage());
    }

    @Test
    public void guest_can_report_inappropriate_messages_from_student() throws Exception {
        Message msg = new Message(student, course,"Inappropriate content", true);
        msg.send();

        Report report = guest.reportMessage(guest.getCourse(course, 123).getMessage(msg),"rude");
        repo().addReport(report);

        assertEquals("rude", repo().getReport(report).getIssue());
    }

    @Test
    public void guest_can_comment_on_messages_from_student() {
        Message msg = new Message(student, course,"Hello", false);
        msg.send();

        GuestComment comment = new GuestComment("Hello to you too", msg);
        guest.comment(msg, comment);

        assertEquals("Hello to you too", repo().getCourse(course).getMessage(msg).getComment(comment).getText());
    }
}
