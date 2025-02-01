package com.solvd.universitymanager.domain.core;

import com.solvd.universitymanager.domain.people.Administrator;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElementWrapper;

import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
public class Faculty {

    private Integer id;
    private String name;

    @XmlElementWrapper(name = "departments")
    @XmlElement(name = "department")
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
        return "Faculty name: " + "\n" + name + "," +
                " list of departments: " + departments;
    }
}
