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
import static org.junit.Assert.assertNull;

/** En student skal kunne sende melding ang. ønsket emne/fag, men forbli anonym
 * En student skal se evt. svar fra forelesere på tidligere sendte meldinger (trenger ikke håndtere lest/ulest)
 * En foreleser skal kunne lese meldinger fra studenter i emner(/et) man selv underviser
 * En foreleser skal kunne svare på meldinger fra studenter (kun ett svar pr. melding)
 *
 * En gjestebruker (anonym/ikke innlogget) skal kunne se alle meldinger (og svar) for et valgt emne,
 * men kun de man kjenner en  firesifret PIN-kode til. Visningssiden skal inneholde emnekode,
 * slik at den lett kan printes for en "kursrapport".
 *
 * En gjestebruker (anonym/ikke innlogget) skal kunne rapportere en upassende melding fra studentene som de ikke er enige i
 * En gjestebruker (anonym/ikke innlogget) skal kunne legge inn en kommentar på meldinger fra studentene.
 * */

public class Testing_communication_features {

    protected IRepository repo;
    Teacher teacher;
    Student student;
    Course course;
    Dialog dialog;

    @Before
    public void initializeRepository() {
        repo = new FakeRepository();
    }

    @Before
    public void initializeConstantFakeVariables() {
        teacher = new com.example.core.model.user.Teacher("Gunnar", null, null, null);
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
    public void messagesAreStoredWithinEachDialog() {
        Message msg = new Message("Hello", dialog, true);
        student.sendMessage(msg);

        assertEquals("Hello", dialog.getMessage(msg).getText());
    }

    @Test
    public void dialogsAreStoredWithinEachCourse() {
        Message msg = new Message("Hello", dialog, true);

        student.sendMessage(msg);
        int lastDialog = course.getDialogs().size()-1;

        assertEquals(dialog, course.getDialogs().get(lastDialog));
    }

    //En student skal se evt. svar fra forelesere på tidligere sendte meldinger (trenger ikke håndtere lest/ulest)
    @Test
    public void studentCanSeeResponseOnMessageFromTeacher() {


    }
}
