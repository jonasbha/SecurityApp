package com.example.core;

import com.example.core.model.Course;
import com.example.core.model.communication.Message;
import com.example.core.model.communication.TeacherComment;
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

    @Before
    public void initialize_constant_fake_variables() {
        teacher = new Teacher("Gunnar", null, null, null);
        student = new Student("Geir", null, null, null, 2020);
        course = new Course("ITF123456", 123);
        teacher.addCourse(course);
    }

    @Test
    public void student_can_send_message() {
        Message msg = new Message(student, course,"Hello", false);
        msg.send();

        assertEquals(msg.getSender(), student);
    }

    @Test
    public void student_can_send_message_anonymously() {
        Message msg = new Message(student, course,"Hello", true);
        msg.send();

        assertNull(msg.getSender());
    }

    @Test
    public void messages_are_stored_in_course() {
        Message msg = new Message(student, course,"Hello", false);
        msg.send();

        assertEquals("Hello", course.getMessage(msg).getText());
    }

    @Test
    public void student_can_see_response_on_message_from_teacher() {
        Message msg = new Message(student, course,"Hello", false);
        msg.send();

        TeacherComment response = new TeacherComment("Im a teacher and this is my answer", msg, teacher);
        response.send();
        assertEquals("Im a teacher and this is my answer", msg.getComment(response).getText());
    }

    @Test
    public void teacher_can_read_messages_of_involved_course() {
        Message msg = new Message(student, course,"Hello", false);
        msg.send();
        assertEquals("Hello", teacher.getCourse(course).getMessage(msg).getText());
    }

    @Test
    public void teacher_can_respond_to_messages_by_students() {
        Message msg = new Message(student, course,"Hello", false);
        msg.send();

        TeacherComment response = new TeacherComment("Im a teacher and this is my answer", msg, teacher);
        response.send();

        assertEquals("Hello", response.getSender().getCourse(course).getMessage(msg).getText());
    }

    @Test
    public void teacher_can_respond_one_time_each_message() {
        Message msg = new Message(student, course,"Hello", false);
        msg.send();
        TeacherComment response = new TeacherComment("Im a teacher and this is my answer", msg, teacher);
        response.send();
        TeacherComment response2 = new TeacherComment("Im a teacher and this is my second answer", msg, teacher);
        response2.send();

        assertFalse(response2.send());
    }

}
