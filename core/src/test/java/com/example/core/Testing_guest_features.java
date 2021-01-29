package com.example.core;

import com.example.core.model.account.Course;
import com.example.core.model.communication.GuestComment;
import com.example.core.model.communication.Message;
import com.example.core.model.communication.Report;
import com.example.core.model.persistence.IAccountRepository;
import com.example.core.model.guest.Guest;
import com.example.core.model.account.Student;
import com.example.core.model.account.Teacher;
import com.example.support.FakeAccountRepository;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertNull;

/**
 * En gjestebruker (anonym/ikke innlogget) skal kunne se alle meldinger (og svar) for et valgt emne,
 * men kun de man kjenner en  firesifret PIN-kode til.
 *
 * En gjestebruker (anonym/ikke innlogget) skal kunne rapportere en upassende melding fra studentene som de ikke er enige i
 * En gjestebruker (anonym/ikke innlogget) skal kunne legge inn en kommentar på meldinger fra studentene.
 * */

public class Testing_guest_features {

    protected IAccountRepository accRepo;
    private Guest guest;
    private Teacher teacher;
    private Student student;
    private Course course;

    @Before
    public void initialize_repository() {
        accRepo = new FakeAccountRepository();
    }

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
        accRepo.addReport(report);

        assertEquals("rude", accRepo.getReport(report).getIssue());
    }

    @Test
    public void guest_can_comment_on_messages_from_student() {
        Message msg = new Message(student, course,"Hello", false);
        msg.send();

        GuestComment comment = new GuestComment("Hello to you too", msg);
        guest.comment(msg, comment);

        assertEquals("Hello to you too", accRepo.getCourse(course).getMessage(msg).getComment(comment).getText());
    }
}
