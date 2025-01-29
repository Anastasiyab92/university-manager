package com.solvd.universitymanager.persistence;

import com.solvd.universitymanager.domain.courses.Course;

import java.util.List;

public interface CourseRepository {

    void create(Course course, Integer departmentId);

    Course findById(Integer id);

    List<Course> findAll();

    List<Course> findAllWithGrades();

    void update(Course course);

    void delete(Integer id);

}
