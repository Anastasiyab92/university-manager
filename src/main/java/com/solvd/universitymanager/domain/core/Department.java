package com.solvd.universitymanager.domain.core;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.solvd.universitymanager.domain.courses.Course;
import com.solvd.universitymanager.domain.people.Instructor;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElementWrapper;

import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
public class Department {

    @JsonIgnore
    private Integer id;
    @JsonProperty("name")
    private String name;

    @XmlElementWrapper(name = "courses")
    @XmlElement(name = "course")
    @JsonProperty("courses")
    private List<Course> courses;
    @JsonIgnore
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
        return "Department name: " + "\n" + name + "," +
                "list of courses: " + courses;
    }
}
