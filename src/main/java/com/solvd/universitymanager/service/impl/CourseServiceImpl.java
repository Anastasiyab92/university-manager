package com.solvd.universitymanager.service.impl;

import com.solvd.universitymanager.domain.courses.Course;
import com.solvd.universitymanager.domain.courses.Grade;
import com.solvd.universitymanager.persistence.CourseRepository;
import com.solvd.universitymanager.persistence.impl.CourseRepositoryImpl;
import com.solvd.universitymanager.service.CourseService;
import com.solvd.universitymanager.service.GradeService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.stream.Collectors;

public class CourseServiceImpl implements CourseService {

    private static final Logger LOGGER = LogManager.getLogger(CourseServiceImpl.class);

    private final CourseRepository courseRepository;
    private final GradeService gradeService;

    public CourseServiceImpl() {
        this.courseRepository = new CourseRepositoryImpl();
        this.gradeService = new GradeServiceImpl();
    }

    @Override
    public Course addCourse(Course course, Integer departmentId) {
        course.setId(null);
        courseRepository.create(course,departmentId);

        if (course.getGrade() != null) {
            Grade grades = course.getGrade();
            course.setGrade(grades);
        }
        return course;
    }

    @Override
    public List<Course> listCourses() {
        return courseRepository.findAll();
    }

    @Override
    public Course findCourseById(Integer id) {
        return courseRepository.findById(id);
    }

    @Override
    public void modifyCourse(Integer id, Integer newCode, String newName) {
        Course course = courseRepository.findById(id);
        if (course != null) {
            course.setCode(newCode);
            course.setName(newName);
            courseRepository.update(course);
        } else {
            LOGGER.warn("Course with ID {} not found.", id);
        }

    }

    @Override
    public void removeCourse(Integer id) {
        courseRepository.delete(id);
    }
}
