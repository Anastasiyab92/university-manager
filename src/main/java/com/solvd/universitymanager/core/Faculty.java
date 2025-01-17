package com.solvd.universitymanager.core;

import java.util.ArrayList;
import java.util.List;

public class Faculty {

    private final String name;
    private final List<Department> departments = new ArrayList<>();

    public Faculty(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public List<Department> getDepartments() {
        return departments;
    }

    public void addDepartment(Department department) {
        departments.add(department);
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
