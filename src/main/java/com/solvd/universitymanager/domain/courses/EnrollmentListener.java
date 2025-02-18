package com.solvd.universitymanager.domain.courses;

import com.solvd.universitymanager.domain.people.Student;

public interface EnrollmentListener {

    void oneStudentEnrolled(Student student, Course course);
}
