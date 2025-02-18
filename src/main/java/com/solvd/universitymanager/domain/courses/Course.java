package com.solvd.universitymanager.domain.courses;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.solvd.universitymanager.domain.people.Instructor;
import com.solvd.universitymanager.domain.people.Student;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElementWrapper;

import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
public class Course {

    @JsonIgnore
    private Integer id;
    @JsonProperty("code")
    private Integer code;
    @JsonProperty("name")
    private String name;

    @XmlElement(name = "grade")
    @JsonProperty("grade")
    private Grade grade;
    @JsonIgnore
    private List<Instructor> instructors;

    @XmlElementWrapper(name = "schedules")
    @XmlElement(name = "schedule")
    @JsonProperty("schedules")
    private List<Schedule> schedules;
    @JsonIgnore
    private List<Student> students;
    private EnrollmentNotifier notifier;


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

    public Grade getGrade() {
        return grade;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
    }

    public List<Instructor> getInstructors() {
        return instructors;
    }

    public void setInstructors(List<Instructor> instructors) {
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

    public void enrollStudent(Student student) {
        students.add(student);
        notifier.notifyStudentEnrolled(student, this);
    }

    public EnrollmentNotifier getNotifier() {
        return notifier;
    }

    public void setNotifier(EnrollmentNotifier notifier) {
        this.notifier = notifier;
    }


    @Override
    public String toString() {
        return "Course information:" + "\n" +
                "ID: " + code + "," +
                " name: " + name + "," +
                " Grade: " + grade +
                " List of schedules: " + "\n" + schedules;
    }
}
