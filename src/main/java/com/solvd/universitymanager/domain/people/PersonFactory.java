package com.solvd.universitymanager.domain.people;

public interface PersonFactory {

    Person createPerson(String firstName, String lastName, String email);
}
