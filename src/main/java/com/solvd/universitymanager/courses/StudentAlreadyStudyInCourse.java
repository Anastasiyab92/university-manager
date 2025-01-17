package com.solvd.universitymanager.courses;

public class StudentAlreadyStudyInCourse extends RuntimeException {

    public StudentAlreadyStudyInCourse(String message) {
        super(message);
    }
}
