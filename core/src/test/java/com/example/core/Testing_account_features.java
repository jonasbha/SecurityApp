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
    public void registeringStudentAccountSucceeds() {
        Student student = new Student(null, null, null, "Informasjonsteknologi", 2020);
        assertEquals("Informasjonsteknologi", student.getStudium());
    }

    @Test
    public void registeringTeacherAccountSucceeds() {
        com.example.core.model.user.Teacher teacher = new com.example.core.model.user.Teacher("Gunnar", null, null, null);
        assertEquals("Gunnar", teacher.getName());
    }

    @Test
    public void autheticationSucceedsWithValidCredentials() {
        repo.addCredential("user", "password");
        assertTrue(repo.verifyCredentials("user", "password"));
    }

    @Test
    public void autheticationFailsWithInvalidCredentials() {
        assertFalse(repo.verifyCredentials("non-existing user", "password"));
    }

    @Test
    public void registeredUserCanChangePassword() {
        Teacher teacher = new Teacher("Gunnar", null, "password", null);
        repo.addCredential("Gunnar", "password");

        String newPassword = "new password";
        teacher.changePassword(newPassword);
        repo.updatePassword(teacher.getName(), newPassword);

        assertTrue(repo.verifyCredentials("Gunnar", newPassword));
        assertFalse(repo.verifyCredentials("Gunnar", "password"));
    }

    @Test
    public void teacherCanAccessAllInvolvedCourses() {
        com.example.core.model.user.Teacher teacher = new com.example.core.model.user.Teacher("Gunnar", null, "password", null);
        teacher.addCourse(new Course("ITF222222", 123));
        teacher.addCourse(new Course("ITF111111", 132));

        assertEquals(teacher.getCourses().size(), 2);
    }
}
