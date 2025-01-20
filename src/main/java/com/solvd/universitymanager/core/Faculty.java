package com.solvd.universitymanager.core;

import com.solvd.universitymanager.people.Administrator;

import java.util.ArrayList;
import java.util.List;

public class Faculty {

    private final String name;
    private final List<Department> departments;
    private List<Administrator> administrators;

    public Faculty(String name) {
        this.name = name;
        this.departments = new ArrayList<>();
        this.administrators = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<Department> getDepartments() {
        return departments;
    }

    public List<Administrator> getAdministrator() {
        return administrators;
    }

    public void addDepartment(Department department) {
        departments.add(department);
    }

    public void addAdministrator(Administrator administrator) {
        administrators.add(administrator);
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
