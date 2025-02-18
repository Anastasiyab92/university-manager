package com.solvd.universitymanager.domain.courses;

import com.solvd.universitymanager.domain.people.Student;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class EnrollmentLogger implements EnrollmentListener {

    private static final Logger LOGGER = LogManager.getLogger(EnrollmentLogger.class);

    @Override
    public void oneStudentEnrolled(Student student, Course course) {
        LOGGER.info("Student {} enrolled in {}", student.getFirstName(), course.getName());
    }
}
