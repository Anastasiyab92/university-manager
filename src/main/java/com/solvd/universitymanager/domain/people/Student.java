package com.solvd.universitymanager.domain.people;

import java.time.LocalDate;

public class Student {

    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private LocalDate yearOfReceipt;
    private String major;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
}
