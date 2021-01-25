package com.example;

import com.example.core.model.user.Student;
import com.example.core.model.user.Teacher;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


public class Testing_account_features {

    /** Kunne registrere seg (navn, e-post, studieretning, kull)
     * Kunne logge inn
     * Kunne bytte passord
     * Utføre "glemt passord"*/

    @Test
    public void registeringStudentAccountSucceeds() {
        Student student = new Student(null, null, null, "Informasjonsteknologi", 2020);
        assertEquals(student.getStudium(), "Informasjonsteknologi");
    }

    @Test
    public void registeringTeacherAccountSucceeds() {
        Teacher teacher = new Teacher("Gunnar", null, null, null);

        assertEquals(teacher.getName(), "Gunnar");
    }

}
