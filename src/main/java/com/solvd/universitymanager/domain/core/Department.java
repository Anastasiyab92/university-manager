package com.solvd.universitymanager.domain.core;

import com.solvd.universitymanager.domain.courses.Course;
import com.solvd.universitymanager.domain.people.Instructor;

import java.util.List;

public class Department {

    private Integer id;
    private String name;
    private List<Course> courses;
    private List<Instructor> instructors;

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

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public List<Instructor> getInstructors() {
        return instructors;
    }

    public void setInstructors(List<Instructor> instructors) {
        this.instructors = instructors;
    }

    @Override
    public String toString() {
        return "Department name: " + name + "," +
                "list of courses: " + courses;
    }
}
