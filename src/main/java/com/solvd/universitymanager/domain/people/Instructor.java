package com.solvd.universitymanager.domain.people;

public class Instructor implements Person {

    private final String firstName;
    private final String lastName;
    private final String email;
    private final String qualification;
    private Long id;

    public Instructor(Builder builder) {
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.email = builder.email;
        this.qualification = builder.qualification;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getQualification() {
        return qualification;
    }

    @Override
    public String toString() {
        return "Instructor{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", qualification='" + qualification + '\'' +
                '}';
    }

    public static class Builder {

        private final String firstName;
        private final String lastName;
        private final String email;
        private String qualification;

        public Builder(String firstName, String lastName, String email) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.email = email;
        }

        public Builder setQualification(String qualification) {
            this.qualification = qualification;
            return this;
        }

        public Instructor build() {
            return new Instructor(this);
        }
    }

}
