package com.solvd.universitymanager.domain.core;

import com.solvd.universitymanager.domain.courses.Course;
import com.solvd.universitymanager.domain.courses.Grade;
import com.solvd.universitymanager.domain.people.Student;

import java.util.List;

public class MathematicalInstituteUniversityFactory implements UniversityFactory {

    @Override
    public Faculty createFaculty(String name, List<Department> departments) {
        return UniversityFactoryHelper.createFaculty(name, departments);
    }

    @Override
    public Department createDepartment(String name, List<Course> courses) {
        return UniversityFactoryHelper.createDepartment(name, courses);
    }

    @Override
    public Course createCourse(Integer code, String name, Grade grade, List<Student> students) {
        return UniversityFactoryHelper.createCourse(code, name, grade, students);
    }
}
