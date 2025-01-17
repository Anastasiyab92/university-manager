package com.solvd.universitymanager.courses;

import com.solvd.universitymanager.people.Student;

public class Grade {

    private final Student student;
    private final Course course;
    private double gradeValue;

    public Grade(Student student, Course course) {
        this.student = student;
        this.course = course;
    }

    public Student getStudent() {
        return student;
    }

    public Course getCourse() {
        return course;
    }

    public double getGradeValue() {
        return gradeValue;
    }

    public void setGradeValue(int gradeValue) {
        this.gradeValue = gradeValue;
    }

    @Override
    public String toString() {
        return "Grade information: " + "\n"
                + "Student: " + student + "\n"
                + "Course: " + course + "\n"
                + "Value: " + gradeValue;
    }
}
