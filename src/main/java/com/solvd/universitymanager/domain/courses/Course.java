package com.solvd.universitymanager.domain.courses;

import com.solvd.universitymanager.domain.people.Instructor;
import com.solvd.universitymanager.domain.people.Student;

import java.util.List;

public class Course {

    private Integer id;
    private Integer code;
    private String name;
    private List<Grade> grades;
    private List<Instructor> instructors;
    private List<Schedule> schedules;
    private List<Student> students;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Instructor> getInstructors() {
        return instructors;
    }

    public void setInstructor(List<Instructor> instructors) {
        this.instructors = instructors;
    }

    public List<Schedule> getSchedules() {
        return schedules;
    }

    public void setSchedules(List<Schedule> schedules) {
        this.schedules = schedules;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public List<Grade> getGrades() {
        return grades;
    }

    public void setGrades(List<Grade> grades) {
        this.grades = grades;
    }

    @Override
    public String toString() {
        return "Course information:" +
                " ID: " + code + "," +
                " name: " + name + "," +
                " list of grades: " + grades;
    }
}
