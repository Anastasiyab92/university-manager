package com.solvd.universitymanager.domain.people;

public class Administrator implements Person {

    private final String firstName;
    private final String lastName;
    private final String email;
    private final String position;
    private final String qualification;
    private Long id;

    public Administrator(Builder builder) {
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.email = builder.email;
        this.position = builder.position;
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

    public String getPosition() {
        return position;
    }

    public String getQualification() {
        return qualification;
    }

    public static class Builder {

        private final String firstName;
        private final String lastName;
        private final String email;
        private String position;
        private String qualification;

        public Builder(String firstName, String lastName, String email) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.email = email;
        }

        public Builder setPosition(String position) {
            this.position = position;
            return this;
        }

        public Builder setQualification(String qualification) {
            this.qualification = qualification;
            return this;
        }

        public Administrator build() {
            return new Administrator(this);
        }
    }
}
