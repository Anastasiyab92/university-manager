package com.solvd.universitymanager.service;

import com.solvd.universitymanager.domain.courses.Course;

import java.util.List;

public interface CourseService {

    Course addCourse(Course course, Integer departmentId);

    List<Course> listCourses();

    Course findCourseById(Integer id);

    void modifyCourse(Integer id, Integer code, String newName);

    void removeCourse(Integer id);
}
