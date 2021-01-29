package com.example.core;

import com.example.core.model.Course;
import com.example.core.model.repository.IRepository;
import com.example.core.model.user.Student;
import com.example.core.model.user.Teacher;
import com.example.support.FakeRepository;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/** Student skal kunne registrere seg (navn, e-post, studieretning, kull)
 * Foreleser skal kunne registrere seg (navn, e-post,  bilde)
 * Kunne logge inn
 * Kunne bytte passord
 * Utføre "glemt passord"
 * Foreleser skal kunne se emner som undervises.
 * */

public class Testing_account_features {
    protected IRepository repo;

    @Before
    public void initialize_repository() {
        repo = new FakeRepository();
    }

    @Test
    public void registering_student_account_succeeds() {
        Student student = new Student(null, null, null, "Informasjonsteknologi", 2020);
        assertEquals("Informasjonsteknologi", student.getStudium());
    }

    @Test
    public void registering_teacher_account_succeeds() {
        Teacher teacher = new Teacher("Gunnar", null, null, null);
        assertEquals("Gunnar", teacher.getName());
    }

    @Test
    public void authentication_succeeds_with_valid_credentials() {
        repo.addCredential("user", "password");
        assertTrue(repo.verifyCredentials("user", "password"));
    }

    @Test
    public void authentication_fails_with_invalid_credentials() {
        assertFalse(repo.verifyCredentials("non-existing user", "password"));
    }

    @Test
    public void registered_user_can_change_password() {
        Teacher teacher = new Teacher("Gunnar", null, "password", null);
        repo.addCredential("Gunnar", "password");

        String newPassword = "new password";
        teacher.changePassword(newPassword);
        repo.updatePassword(teacher.getName(), newPassword);

        assertTrue(repo.verifyCredentials("Gunnar", newPassword));
        assertFalse(repo.verifyCredentials("Gunnar", "password"));
    }

    @Test
    public void teacher_can_see_number_of_involved_courses() {
        Teacher teacher = new com.example.core.model.user.Teacher("Gunnar", null, "password", null);
        teacher.addCourse(new Course("ITF222222", 123));
        teacher.addCourse(new Course("ITF111111", 132));

        assertEquals(teacher.getCourses().size(), 2);
    }
}
