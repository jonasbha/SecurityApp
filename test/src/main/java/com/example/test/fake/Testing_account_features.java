package com.example.test.fake;

import com.example.core.model.course.Course;
import com.example.core.model.persistence.repository.IAccountRepository;
import com.example.core.model.user_account.Student;
import com.example.core.model.user_account.Teacher;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class Testing_account_features {

    protected PersistenceSupport persistenceSupport;

    @Before
    public void initialize_repository() {
        persistenceSupport = new PersistenceSupport();
    }

    public IAccountRepository repo() {
        return persistenceSupport.getAccountRepository();
    }

    @Test
    public void registering_student_account_succeeds() {
        Student student = new Student(null, null, null, "Informasjonsteknologi", 2020);
        repo().registerStudent(student);

        assertEquals("Informasjonsteknologi", repo().getStudent(student).getStudium());
    }

    @Test
    public void registering_teacher_account_succeeds() {
        Teacher teacher = new Teacher("Gunnar", null, null, null);
        repo().registerTeacher(teacher);

        assertEquals("Gunnar", repo().getTeacher(teacher).getName());
    }

    @Test
    public void authentication_succeeds_with_valid_credentials() {
        repo().addCredential("user", "password");
        assertTrue(repo().verifyCredentials("user", "password"));
    }

    @Test
    public void authentication_fails_with_invalid_credentials() {
        assertFalse(repo().verifyCredentials("non-existing user", "password"));
    }

    @Test
    public void teacher_can_see_number_of_involved_courses() {
        Teacher teacher = new Teacher("Gunnar", null, "password", null);
        Course course1 = new Course("ITF222222", 123, teacher);
        Course course2 = new Course("ITF111111", 132, teacher);
        repo().addCourse(course1);
        repo().addCourse(course2);

        assertEquals(repo().getCourses().size(), 4);
    }
}
