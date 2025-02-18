package com.solvd.universitymanager.domain.people;

public class InstructorFactory {

    public static Person createInstructor(String firstName, String lastName, String email, String qualification) {
        return new Instructor.Builder(firstName, lastName, email)
                .setQualification(qualification)
                .build();
    }
}
