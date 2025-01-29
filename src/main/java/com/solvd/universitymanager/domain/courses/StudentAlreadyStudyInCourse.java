package com.solvd.universitymanager.domain.courses;

public class StudentAlreadyStudyInCourse extends RuntimeException {

    public StudentAlreadyStudyInCourse(String message) {
        super(message);
    }
}
