package com.solvd.universitymanager.courses;

import com.solvd.universitymanager.people.Instructor;
import com.solvd.universitymanager.people.Student;

import java.util.HashSet;
import java.util.Set;

public class Course {

    private final String name;
    private final int code;
    private final Instructor instructor;
    private final Set<Student> students = new HashSet<>();

    public Course(String name, int code, Instructor instructor) {
        this.name = name;
        this.code = code;
        this.instructor = instructor;
    }

    public String getName() {
        return name;
    }

    public int getCode() {
        return code;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public void addStudent(Student student) {
        if (students.contains(student)) {
            throw new StudentAlreadyStudyInCourse("This student is exist!");
        }
        students.add(student);
    }

    @Override
    public String toString() {
        return "Course information:" + "\n"
                + "ID: " + code + "\n"
                + "Name: " + name + "\n"
                + "Instructor of course: " + instructor + "\n"
                + "Count of student in the course: " + students.size();
    }
}
