package com.example.core;

import com.example.core.model.Course;
import com.example.core.model.Dialogue;
import com.example.core.model.Message;
import com.example.core.model.Report;
import com.example.core.model.repository.IRepository;
import com.example.core.model.user.Guest;
import com.example.core.model.user.Student;
import com.example.core.model.user.Teacher;
import com.example.support.FakeRepository;

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

    protected IRepository repo;
    private Guest guest;
    private Teacher teacher;
    private Student student;
    private Course course;
    private Dialogue dialogue;

    @Before
    public void initialize_repository() {
        repo = new FakeRepository();
    }

    @Before
    public void initialize_constant_fake_variables() {
        guest = new Guest();
        teacher = new Teacher("Gunnar", null, null, null);
        student = new Student("Geir", null, null, null, 2020);
        course = new Course("ITF123456", 123);
        dialogue = new Dialogue(student, teacher, course,1);
    }

    @Test
    public void guest_can_read_dialog_in_a_course_when_valid_PIN_is_given() throws Exception {
        Message studMsg = new Message("Hello from student", dialogue, false);
        student.sendMessage(studMsg);
        Message teachMsg = new Message("Hello from teacher", dialogue);
        student.sendMessage(teachMsg);

        assertEquals("Hello from student", guest.getCourse(course, 123).getDialogues().get(0).getMessages().get(0).getText());
        assertEquals("Hello from teacher", guest.getCourse(course, 123).getDialogues().get(0).getMessages().peek().getText());
    }

    @Test
    public void guest_can_not_access_course_when_invalid_PIN_is_given() {
        Throwable e = assertThrows(Exception.class, () -> guest.getCourse(course, 13));
        assertEquals("Wrong PIN-code.", e.getMessage());
    }

    @Test
    public void guest_can_report_inappropriate_messages_from_student() throws Exception {
        Message msg = new Message("You are fat.", dialogue, true);
        student.sendMessage(msg);

        Report report = guest.reportMessage(guest.getCourse(course, 123).getDialogues().get(0).getMessages().peek(),
                "rude");
        repo.addReport(report);

        assertEquals("rude", report.getIssue());
    }

    @Test
    public void guest_can_comment_on_messages_from_student() {
        Message msg = new Message("You are fat.", dialogue, true);
        student.sendMessage(msg);

        guest.comment(msg, "I am reporting this as we speak.");
        assertEquals("I am reporting this as we speak.", msg.getComments().get(0));
    }
}
