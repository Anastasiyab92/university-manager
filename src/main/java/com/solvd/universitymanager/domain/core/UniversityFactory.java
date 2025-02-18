package com.solvd.universitymanager.domain.core;

import com.solvd.universitymanager.domain.courses.Course;
import com.solvd.universitymanager.domain.courses.Grade;
import com.solvd.universitymanager.domain.people.Student;

import java.util.List;

public interface UniversityFactory {

    Faculty createFaculty(String name, List<Department> departments);

    Department createDepartment(String name, List<Course> courses);

    Course createCourse(Integer code, String name, Grade grade, List<Student> students);

}
