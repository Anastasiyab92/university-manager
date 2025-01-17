package com.solvd.universitymanager.people;

import com.solvd.universitymanager.core.Department;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Objects;


public class Administrator extends Person {

    private static final Logger LOGGER = LogManager.getLogger(Administrator.class);
    private final String position;
    private final Department department;

    public Administrator(String name, int id, String email, String position, Department department) {
        super(name, id, email);
        this.position = position;
        this.department = department;
    }

    public String getPosition() {
        return position;
    }

    public Department getDepartment() {
        return department;
    }

    public void manageDepartment(Department department) {
        LOGGER.info("Managing department: {}", department.getName());
    }

    @Override
    public String getRoll() {
        return "Administrator";
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Administrator that = (Administrator) o;
        return Objects.equals(position, that.position) && Objects.equals(department, that.department);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), position, department);
    }
}
