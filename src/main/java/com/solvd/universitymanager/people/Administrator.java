package com.solvd.universitymanager.people;

import java.util.Objects;


public class Administrator extends Person {

    private final String position;
    private String qualification;

    public Administrator(String name, int id, String email, String position, String qualification) {
        super(name, id, email);
        this.position = position;
        this.qualification = qualification;
    }

    public String getPosition() {
        return position;
    }

    public String getQualification() {
        return qualification;
    }

    @Override
    public String getRoll() {
        return "Faculty Administration.";
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Administrator that = (Administrator) o;
        return Objects.equals(position, that.position) && Objects.equals(qualification, that.qualification);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), position, qualification);
    }
}
