package com.example.core;

import com.example.core.model.Course;
import com.example.core.model.Message;
import com.example.core.model.repository.IRepository;
import com.example.core.model.user.Student;
import com.example.core.model.user.Teacher;
import com.example.support.FakeRepository;

import org.junit.Before;
import org.junit.BeforeClass;
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

    @Before
    public void initializeRepository() {
        repo = new FakeRepository();
    }

    @Before
    public void initializeConstantFakeVariables() {
        teacher = new Teacher("Gunnar", null, null, null);
        student = new Student("Geir", null, null, null, 2020);
        course = new Course("ITF123456", 123);
    }

    @Test
    public void studentCanSendMessage() {
        Message msg = new Message("Hello", course, false);
        student.sendMessage(msg);

        assertEquals(msg.getSender(), student);
    }

    @Test
    public void studentCanSendMessageAnonymously() {
        Message msg = new Message("Hello", course, true);
        student.sendMessage(msg);

        assertNull(msg.getSender());
    }

    @Test
    public void teacherCanNotSendMessageAnonymously() {
        Message msg = new Message("Hello", course, true);
        teacher.sendMessage(msg);

        assertEquals(msg.getSender(), teacher);
    }

    @Test
    public void messagesAreStoredWithinEachCourse() {
        Message msg = new Message("Hello", course, true);
        student.sendMessage(msg);

        assertEquals("Hello", course.getMessages().get(0).getText());
    }

    //En student skal se evt. svar fra forelesere på tidligere sendte meldinger (trenger ikke håndtere lest/ulest)
    @Test
    public void studentCanSeeResponseOnMessageFromTeacher() {
        Message msg = new Message("Hello student", course);
        teacher.sendMessage(msg);
        student.openMessage(msg);

    }
}
