package com.solvd.universitymanager.domain.courses;

import com.solvd.universitymanager.domain.people.Instructor;
import com.solvd.universitymanager.domain.people.Student;

import java.util.List;

public class Course {

    private Integer id;
    private Integer code;
    private String name;
    private Grade grade;
    private List<Instructor> instructors;
    private List<Schedule> schedules;
    private List<Student> students;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
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

    public Grade getGrade() {
        return grade;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Course information:" +
                " ID: " + code + "," +
                " name: " + name + "," +
                " list of grade: " + grade;
    }
}
