package com.solvd.universitymanager.people;

import com.solvd.universitymanager.core.Department;
import com.solvd.universitymanager.courses.Course;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Instructor extends Person {

    private final Department department;
    private final List<Course> courses = new ArrayList<>();

    public Instructor(String name, int id, String email, Department department) {
        super(name, id, email);
        this.department = department;
    }

    public Department getDepartment() {
        return department;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void assignCourse(Course course) {
        courses.add(course);
    }

    @Override
    public String getRoll() {
        return "Instructor";
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Instructor that = (Instructor) o;
        return Objects.equals(department, that.department) && Objects.equals(courses, that.courses);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), department, courses);
    }
}
