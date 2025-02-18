package com.solvd.universitymanager.domain.people;

public class AdministratorFactory {

    public static Person createAdministrator(String firstName, String lastName, String email, String position, String qualification) {
        return new Administrator.Builder(firstName, lastName, email)
                .setPosition(position)
                .setQualification(qualification)
                .build();
    }
}
