package com.example.core;

import com.example.core.model.Course;
import com.example.core.model.Dialogue;
import com.example.core.model.Message;
import com.example.core.model.user.Student;
import com.example.core.model.user.Teacher;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertNull;

/** En student skal kunne sende melding ang. ønsket emne/fag, men forbli anonym
 * En student skal se evt. svar fra forelesere på tidligere sendte meldinger (trenger ikke håndtere lest/ulest)
 * En foreleser skal kunne lese meldinger fra studenter i emner(/et) man selv underviser
 * En foreleser skal kunne svare på meldinger fra studenter (kun ett svar pr. melding)
 * */

public class Testing_communication_between_registered_users {

    private Teacher teacher;
    private Student student;
    private Course course;
    private Dialogue dialogue;

    @Before
    public void initialize_constant_fake_variables() {
        teacher = new Teacher("Gunnar", null, null, null);
        student = new Student("Geir", null, null, null, 2020);
        course = new Course("ITF123456", 123);
        dialogue = new Dialogue(student, teacher, course,1);
    }

    @Test
    public void student_can_send_message() {
        Message msg = new Message("Hello", dialogue, false);
        student.sendMessage(msg);

        assertEquals(msg.getSender(), student);
    }

    @Test
    public void student_can_send_message_anonymously() {
        Message msg = new Message("Hello", dialogue, true);
        student.sendMessage(msg);

        assertNull(msg.getSender());
    }

    @Test
    public void teacher_can_not_send_message_anonymously() {
        Message msg = new Message("Hello", dialogue, true);
        teacher.sendMessage(msg);

        assertEquals(msg.getSender(), teacher);
    }

    @Test
    public void messages_are_stored_in_a_dialog() {
        Message msg = new Message("Hello", dialogue, true);
        student.sendMessage(msg);

        assertEquals("Hello", dialogue.getMessage(msg).getText());
    }

    @Test
    public void dialogs_are_stored_in_a_course() {
        Message msg = new Message("Hello", dialogue, true);

        student.sendMessage(msg);
        int lastDialog = course.getDialogues().size()-1;

        assertEquals(dialogue, course.getDialogues().get(lastDialog));
    }

    @Test
    public void student_can_see_response_on_message_from_teacher() {
        Message msg = new Message("Im a teacher and this is my answer", dialogue);
        teacher.sendMessage(msg);

        assertEquals("Im a teacher and this is my answer", dialogue.getMessage(msg).getText());
    }

    @Test
    public void student_can_not_read_dialog_of_another_student() {
        Message msg = new Message("Hello", dialogue, true);
        student.sendMessage(msg);
        Student fakeStudent = new Student("Ole", null, null, null, 2020);

        assertFalse(fakeStudent.openDialog(dialogue));
    }

    @Test
    public void teacher_can_open_messages_of_involved_courses() {
        assertTrue(teacher.openDialog(dialogue));
    }

    @Test
    public void teacher_can_not_open_messages_of_courses_when_not_involved() {
        Teacher fakeTeacher = new Teacher("Ole", null, null, null);
        assertFalse(fakeTeacher.openDialog(dialogue));
    }

    @Test
    public void teacher_can_respond_to_messages_by_students() {
        Message studMsg = new Message("Hello teacher", dialogue, true);
        student.sendMessage(studMsg);
        Message teachMsg = new Message("Hello student", dialogue);
        teacher.sendMessage(teachMsg);

        assertEquals("Hello teacher", dialogue.getMessage(studMsg).getText());
        assertEquals("Hello student", dialogue.getMessages().peek().getText());
    }

    @Test
    public void teacher_can_respond_one_time_each_message() {
        Message studMsg = new Message("Hello teacher", dialogue, true);
        student.sendMessage(studMsg);
        Message teachMsg = new Message("Hello student", dialogue);
        teacher.sendMessage(teachMsg);
        Message teachMsg2 = new Message("Hello again student", dialogue);

        assertFalse(teacher.sendMessage(teachMsg2));
    }

    @Test
    public void teacher_can_respond_multiple_times_in_one_dialog() {
        Message studMsg = new Message("Hello teacher", dialogue, true);
        student.sendMessage(studMsg);
        Message teachMsg = new Message("Hello student", dialogue);
        teacher.sendMessage(teachMsg);
        Message studMsg2 = new Message("Hello again teacher", dialogue, true);
        student.sendMessage(studMsg2);
        Message teachMsg2 = new Message("Hello again student", dialogue);

        assertTrue(teacher.sendMessage(teachMsg2));
    }
}
