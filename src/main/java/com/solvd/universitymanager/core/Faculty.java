package com.solvd.universitymanager.core;

import com.solvd.universitymanager.people.Administrator;

import java.util.List;

public class Faculty {

    private Integer id;
    private String name;
    private List<Department> departments;
    private List<Administrator> administrators;

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

    public List<Department> getDepartments() {
        return departments;
    }

    public void setDepartments(List<Department> departments) {
        this.departments = departments;
    }

    public List<Administrator> getAdministrators() {
        return administrators;
    }

    public void setAdministrators(List<Administrator> administrators) {
        this.administrators = administrators;
    }

    public Department getDepartmentByName(String name) {
        return departments.stream()
                .filter(department -> department.getName().equals(name))
                .findFirst()
                .orElse(null);
    }

    @Override
    public String toString() {
        return "Faculty name: " + name + "\n"
                + "List of departments: " + departments;
    }
}
