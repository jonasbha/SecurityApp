package com.example.core;

import com.example.core.model.account.Course;
import com.example.core.model.persistence.IAccountRepository;
import com.example.core.model.account.Student;
import com.example.core.model.account.Teacher;
import com.example.support.FakeAccountRepository;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/** Student skal kunne registrere seg (navn, e-post, studieretning, kull)
 * Foreleser skal kunne registrere seg (navn, e-post,  bilde)
 * Kunne logge inn
 * Foreleser skal kunne se emner som undervises.
 * */

public class Testing_account_features {
    protected IAccountRepository accRepo;

    @Before
    public void initialize_repository() {
        accRepo = new FakeAccountRepository();
    }

    @Test
    public void registering_student_account_succeeds() {
        Student student = new Student(null, null, null, "Informasjonsteknologi", 2020);
        accRepo.registerStudent(student);

        assertEquals("Informasjonsteknologi", accRepo.getStudent(student).getStudium());
    }

    @Test
    public void registering_teacher_account_succeeds() {
        Teacher teacher = new Teacher("Gunnar", null, null, null);
        accRepo.registerTeacher(teacher);

        assertEquals("Gunnar", accRepo.getTeacher(teacher).getName());
    }

    @Test
    public void authentication_succeeds_with_valid_credentials() {
        accRepo.addCredential("user", "password");
        assertTrue(accRepo.verifyCredentials("user", "password"));
    }

    @Test
    public void authentication_fails_with_invalid_credentials() {
        assertFalse(accRepo.verifyCredentials("non-existing user", "password"));
    }

    @Test
    public void teacher_can_see_number_of_involved_courses() {
        Teacher teacher = new Teacher("Gunnar", null, "password", null);
        Course course1 = new Course("ITF222222", 123, teacher);
        Course course2 = new Course("ITF111111", 132, teacher);
        accRepo.addCourse(course1);
        accRepo.addCourse(course2);

        assertEquals(accRepo.getCourses().size(), 2);
    }
}
