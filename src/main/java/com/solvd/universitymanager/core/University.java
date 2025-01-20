package com.solvd.universitymanager.core;

import java.util.ArrayList;
import java.util.List;

public class University {

    private final String name;
    private final String address;
    private final List<Faculty> faculties;

    public University(String name, String address) {
        this.name = name;
        this.address = address;
        this.faculties = new ArrayList<>();

    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public void addFaculty(Faculty faculty) {
        faculties.add(faculty);
    }

    public List<Faculty> getFaculties() {
        return faculties;
    }

    @Override
    public String toString() {
        return "University name: " + name + "\n"
                + "Address: " + address + "\n"
                + "List of faculties: " + faculties;
    }
}
