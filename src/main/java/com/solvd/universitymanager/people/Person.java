package com.solvd.universitymanager.people;

import java.util.Objects;

public abstract class Person {

    private final String name;
    private final int id;
    private final String email;

    protected Person(String name, int id, String email) {
        this.name = name;
        this.id = id;
        this.email = email;
    }

    public String getContactInfo() {
        return name + " (" + email + ")";
    }

    public abstract String getRoll();

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return id == person.id && Objects.equals(email, person.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, email);
    }
}
