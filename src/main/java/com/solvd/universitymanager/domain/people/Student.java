package com.solvd.universitymanager.domain.people;

import java.time.LocalDate;

public class Student extends Person {

    private Long id;
    private LocalDate yearOfReceipt;
    private String major;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getYearOfReceipt() {
        return yearOfReceipt;
    }

    public void setYearOfReceipt(LocalDate yearOfReceipt) {
        this.yearOfReceipt = yearOfReceipt;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    @Override
    public String getRole() {
        return "Student";
    }
}
