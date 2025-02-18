package com.solvd.universitymanager.domain.people;

import java.time.LocalDate;

public class StudentFactory {

    public static Person createStudent(String firstName, String lastName, String email, LocalDate yearOfReceipt, String major) {
        return new Student.Builder(firstName, lastName, email).
                setYearOfReceipt(yearOfReceipt)
                .setMajor(major)
                .build();
    }
}
