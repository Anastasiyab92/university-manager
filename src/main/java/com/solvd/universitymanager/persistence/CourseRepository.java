package com.solvd.universitymanager.persistence;

import com.solvd.universitymanager.domain.courses.Course;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CourseRepository {

    void create(@Param("course") Course course, @Param("departmentId") Integer departmentId);

    Course findById(Integer id);

    List<Course> findAll();

    List<Course> findAllWithGrade();

    void update(Course course);

    void delete(Integer id);

}
