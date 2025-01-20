package com.solvd.universitymanager.people;

import java.time.LocalDate;
import java.util.Objects;

public class Student extends Person {

    private final LocalDate yearOfReceipt;
    private final String major;

    public Student(String name, int id, String email, LocalDate yearOfReceipt, String major) {
        super(name, id, email);
        this.yearOfReceipt = yearOfReceipt;
        this.major = major;
    }

    public LocalDate getYearOfReceipt() {
        return yearOfReceipt;
    }

    public String getMajor() {
        return major;
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
        return Objects.equals(yearOfReceipt, student.yearOfReceipt) && Objects.equals(major, student.major);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), yearOfReceipt, major);
    }
}
