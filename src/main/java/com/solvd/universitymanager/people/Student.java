package com.solvd.universitymanager.people;

import com.solvd.universitymanager.courses.Course;

import java.time.LocalDate;
import java.util.Objects;

public class Student extends Person {

    private final LocalDate yearOfReceipt;
    private final String major;
    private final Course course;

    public Student(String name, int id, String email, LocalDate yearOfReceipt, String major, Course course) {
        super(name, id, email);
        this.yearOfReceipt = yearOfReceipt;
        this.major = major;
        this.course = course;
    }

    public LocalDate getYearOfReceipt() {
        return yearOfReceipt;
    }

    public String getMajor() {
        return major;
    }

    public Course getCourse() {
        return course;
    }

    @Override
    public String getRoll() {
        return "Student";
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Student student = (Student) o;
        return Objects.equals(yearOfReceipt, student.yearOfReceipt) && Objects.equals(major, student.major) && Objects.equals(course, student.course);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), yearOfReceipt, major, course);
    }
}
