package com.solvd.universitymanager.people;

import java.util.Objects;

public class Instructor extends Person {

    private String qualification;

    public Instructor(String name, int id, String email, String qualification) {
        super(name, id, email);
        this.qualification = qualification;
    }

    public String getQualification() {
        return qualification;
    }

    @Override
    public String getRoll() {
        return "Instructor";
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Instructor that = (Instructor) o;
        return Objects.equals(qualification, that.qualification);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), qualification);
    }
}
