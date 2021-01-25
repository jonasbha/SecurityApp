package com.example.core;

import com.example.core.model.repository.IRepository;
import com.example.core.model.user.Student;
import com.example.core.model.user.Teacher;
import com.example.support.FakeRepository;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

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


    public void initialize_persistence() {
        repo = new FakeRepository();
    }

    @Test
    public void registeringStudentAccountSucceeds() {
        Student student = new Student(null, null, null, "Informasjonsteknologi", 2020);
        assertEquals("Informasjonsteknologi", student.getStudium());
    }

    @Test
    public void registeringTeacherAccountSucceeds() {
        Teacher teacher = new Teacher("Gunnar", null, null, null);
        assertEquals("Gunnar", teacher.getName());
    }

    @Test
    public void autheticationSucceedsWithValidCredentials() {
        repo = new FakeRepository();
        repo.addCredential("user", "password");

        assertTrue(repo.verifyCredentials("user", "password"));
    }

    @Test
    public void autheticationFailsWithInvalidCredentials() {
        repo = new FakeRepository();

        assertFalse(repo.verifyCredentials("non-existing user", "password"));
    }

    @Test
    public void registeredUserCanChangePassword() {
        repo = new FakeRepository();
        Teacher teacher = new Teacher("Gunnar", null, "password", null);
        repo.addCredential("Gunnar", "password");

        String password = "new password";
        teacher.changePassword(password);
        repo.updatePassword(teacher.getName(), password);

        assertTrue(repo.verifyCredentials("Gunnar", password));
        assertFalse(repo.verifyCredentials("Gunnar", "password"));
    }

    @Test
    public void teacherCanAccessAllInvolvedCourses() {

    }
}
