package com.solvd.universitymanager.domain.courses;

import com.solvd.universitymanager.domain.people.Student;

import java.util.ArrayList;
import java.util.List;

public class EnrollmentNotifier {

    private final List<EnrollmentListener> listeners = new ArrayList<>();

    public void addListener(EnrollmentListener listener) {
        listeners.add(listener);
    }

    public void removeListener(EnrollmentListener listener) {
        listeners.remove(listener);
    }

    public void notifyStudentEnrolled(Student student, Course course) {
        for (EnrollmentListener listener : listeners) {
            listener.oneStudentEnrolled(student, course);
        }
    }

}
