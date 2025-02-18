package com.solvd.universitymanager.domain.core;

import com.solvd.universitymanager.domain.courses.Course;
import com.solvd.universitymanager.domain.courses.Grade;
import com.solvd.universitymanager.domain.people.Student;

import java.util.List;

public class UniversityFactoryHelper {

    public static Faculty createFaculty(String name, List<Department> departments) {
        Faculty faculty = new Faculty();
        faculty.setName(name);
        faculty.setDepartments(departments);
        return faculty;
    }

    public static Department createDepartment(String name, List<Course> courses) {
        Department department = new Department();
        department.setName(name);
        department.setCourses(courses);
        return department;
    }

    public static Course createCourse(Integer code, String name, Grade grade, List<Student> students) {
        Course course = new Course();
        course.setCode(code);
        course.setName(name);
        course.setGrade(grade);
        course.setStudents(students);
        return course;
    }

}
