package com.solvd.universitymanager.core;

import com.solvd.universitymanager.courses.Course;
import com.solvd.universitymanager.people.Instructor;

import java.util.ArrayList;
import java.util.List;

public class Department {

    private final String name;
    private final List<Course> courses;
    private final List<Instructor> instructors;

    public Department(String name) {
        this.name = name;
        this.courses = new ArrayList<>();
        this.instructors = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public List<Instructor> getInstructors() {
        return instructors;
    }

    public void addStuffMembers(Instructor instructor) {
        instructors.add(instructor);
    }

    public void addCourses(Course course) {
        courses.add(course);
    }

    @Override
    public String toString() {
        return "Department name: " + name + "\n"
                + "List of courses: " + courses + "\n"
                + "List of instructors: " + instructors;
    }
}
