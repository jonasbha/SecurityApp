package com.example.test.fake;

import com.example.core.model.course.Course;
import com.example.core.model.course.Message;
import com.example.core.model.course.TeacherComment;
import com.example.core.model.persistence.repository.IAccountRepository;
import com.example.core.model.user_account.Student;
import com.example.core.model.user_account.Teacher;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;

public class Testing_communication_between_registered_users {


    protected PersistenceSupport persistenceSupport;

    @Before
    public void initialize_repository() {
        persistenceSupport = new PersistenceSupport();
    }

    public IAccountRepository repo() {
        return persistenceSupport.getAccountRepository();
    }

    private Teacher teacher;
    private Student student;
    private Course course;

    @Before
    public void initialize_constant_fake_variables() {
        teacher = new Teacher("Gunnar", null, null, null);
        student = new Student("Geir", null, null, null, 2020);
        course = new Course("ITF123456", 123, teacher);
    }

    @Test
    public void student_can_send_message() {
        Message msg = new Message(student, course,"Hello", false);
        msg.send();

        assertEquals("Geir", repo().getCourse(course).getMessage(msg).getSender());
    }

    @Test
    public void student_can_send_message_anonymously() {
        Message msg = new Message(student, course,"Hello", true);
        msg.send();

        assertEquals("Anonymous", repo().getCourse(course).getMessage(msg).getSender());
    }

    @Test
    public void messages_are_stored_in_course() {
        Message msg = new Message(student, course,"Hello", false);
        msg.send();

        assertEquals("Hello", repo().getCourse(course).getMessage(msg).getText());
    }

    @Test
    public void student_can_see_response_on_message_from_teacher() {
        Message msg = new Message(student, course,"Hello", false);
        msg.send();

        TeacherComment response = new TeacherComment("Im a teacher and this is my answer", msg, teacher);
        response.send();
        assertEquals("Gunnar: Im a teacher and this is my answer", repo().getCourse(course).getMessage(msg).getComment(response).getText());
    }

    @Test
    public void teacher_can_read_messages_of_involved_course() {
        Message msg = new Message(student, course,"Hello", false);
        msg.send();
        assertEquals("Hello", repo().getCourse(course).getMessage(msg).getText());
    }

    @Test
    public void teacher_can_respond_to_messages_by_students() {
        Message msg = new Message(student, course,"Hello", false);
        msg.send();

        TeacherComment response = new TeacherComment("Im a teacher and this is my answer", msg, teacher);
        response.send();

        assertEquals("Gunnar: Im a teacher and this is my answer", repo().getCourse(course).getMessage(msg).getComment(response).getText());
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
