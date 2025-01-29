package com.solvd.universitymanager.domain.core;

import java.util.List;

public class University {

    private Integer id;
    private String name;
    private String address;
    private List<Faculty> faculties;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Faculty> getFaculties() {
        return faculties;
    }

    public void setFaculties(List<Faculty> faculties) {
        this.faculties = faculties;
    }

    @Override
    public String toString() {
        return "University name: " + name + "\n"
                + "Address: " + address + "\n"
                + "List of faculties: " + faculties;
    }
}
