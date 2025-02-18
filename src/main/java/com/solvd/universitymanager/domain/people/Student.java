package com.solvd.universitymanager.domain.people;

import java.time.LocalDate;

public class Student implements Person {

    private final String firstName;
    private final String lastName;
    private final String email;
    private final LocalDate yearOfReceipt;
    private final String major;
    private Long id;

    public Student(Builder builder) {
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.email = builder.email;
        this.yearOfReceipt = builder.yearOfReceipt;
        this.major = builder.major;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String getFirstName() {
        return firstName;
    }

    @Override
    public String getLastName() {
        return lastName;
    }

    @Override
    public String getEmail() {
        return email;
    }

    public LocalDate getYearOfReceipt() {
        return yearOfReceipt;
    }

    public String getMajor() {
        return major;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", yearOfReceipt=" + yearOfReceipt +
                ", major='" + major + '\'' +
                '}';
    }

    public static class Builder {

        private final String firstName;
        private final String lastName;
        private final String email;
        private LocalDate yearOfReceipt;
        private String major;

        public Builder(String firstName, String lastName, String email) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.email = email;
        }

        public Builder setYearOfReceipt(LocalDate yearOfReceipt) {
            this.yearOfReceipt = yearOfReceipt;
            return this;
        }

        public Builder setMajor(String major) {
            this.major = major;
            return this;
        }

        public Student build() {
            return new Student(this);
        }
    }
}
