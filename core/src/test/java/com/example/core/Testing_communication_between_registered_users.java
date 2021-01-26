package com.example.core;

import com.example.core.model.Course;
import com.example.core.model.Dialog;
import com.example.core.model.Message;
import com.example.core.model.repository.IRepository;
import com.example.core.model.user.Student;
import com.example.core.model.user.Teacher;
import com.example.support.FakeRepository;

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

    protected IRepository repo;
    private Teacher teacher;
    private Student student;
    private Course course;
    private Dialog dialog;

    @Before
    public void initializeRepository() {
        repo = new FakeRepository();
    }

    @Before
    public void initializeConstantFakeVariables() {
        teacher = new Teacher("Gunnar", null, null, null);
        student = new Student("Geir", null, null, null, 2020);
        course = new Course("ITF123456", 123);
        dialog = new Dialog(student, teacher, course,1);
    }

    @Test
    public void studentCanSendMessage() {
        Message msg = new Message("Hello", dialog, false);
        student.sendMessage(msg);

        assertEquals(msg.getSender(), student);
    }

    @Test
    public void studentCanSendMessageAnonymously() {
        Message msg = new Message("Hello", dialog, true);
        student.sendMessage(msg);

        assertNull(msg.getSender());
    }

    @Test
    public void teacherCanNotSendMessageAnonymously() {
        Message msg = new Message("Hello", dialog, true);
        teacher.sendMessage(msg);

        assertEquals(msg.getSender(), teacher);
    }

    @Test
    public void messagesAreStoredInADialog() {
        Message msg = new Message("Hello", dialog, true);
        student.sendMessage(msg);

        assertEquals("Hello", dialog.getMessage(msg).getText());
    }

    @Test
    public void dialogsAreStoredInACourse() {
        Message msg = new Message("Hello", dialog, true);

        student.sendMessage(msg);
        int lastDialog = course.getDialogs().size()-1;

        assertEquals(dialog, course.getDialogs().get(lastDialog));
    }

    @Test
    public void studentCanSeeResponseOnMessageFromTeacher() {
        Message msg = new Message("Im a teacher and this is my answer", dialog);
        teacher.sendMessage(msg);

        assertEquals("Im a teacher and this is my answer", dialog.getMessage(msg).getText());
    }

    @Test
    public void studentCanNotReadDialogOfAnotherStudent() {
        Message msg = new Message("Hello", dialog, true);
        student.sendMessage(msg);
        Student fakeStudent = new Student("Ole", null, null, null, 2020);

        assertFalse(fakeStudent.openDialog(dialog));
    }

    @Test
    public void teacherCanOpenMessagesOfInvolvedCourses() {
        assertTrue(teacher.openDialog(dialog));
    }

    @Test
    public void teacherCanNotOpenMessagesOfCoursesWhenNotInvolved() {
        Teacher fakeTeacher = new Teacher("Ole", null, null, null);
        assertFalse(fakeTeacher.openDialog(dialog));
    }

    @Test
    public void teacherCanRespondToMessagesByStudents() {
        Message studMsg = new Message("Hello teacher", dialog, true);
        student.sendMessage(studMsg);
        Message teachMsg = new Message("Hello student", dialog);
        teacher.sendMessage(teachMsg);

        assertEquals("Hello teacher", dialog.getMessage(studMsg).getText());
        assertEquals("Hello student", dialog.getMessages().peek().getText());
    }

    @Test
    public void teacherCanRespondOneTimeEachMessage() {
        Message studMsg = new Message("Hello teacher", dialog, true);
        student.sendMessage(studMsg);
        Message teachMsg = new Message("Hello student", dialog);
        teacher.sendMessage(teachMsg);
        Message teachMsg2 = new Message("Hello again student", dialog);

        assertFalse(teacher.sendMessage(teachMsg2));
    }
}
