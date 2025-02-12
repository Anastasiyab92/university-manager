package com.solvd.universitymanager.persistence.impl;

import com.solvd.universitymanager.domain.courses.Course;
import com.solvd.universitymanager.persistence.CourseRepository;
import com.solvd.universitymanager.persistence.MybatisSessionHolder;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class CourseMapperImpl implements CourseRepository {

    @Override
    public void create(Course course, Integer departmentId) {
        try (SqlSession session = MybatisSessionHolder.getSqlSessionFactory().openSession(true)) {
            CourseRepository courseRepository = session.getMapper(CourseRepository.class);
            courseRepository.create(course, departmentId);
        }
    }

    @Override
    public Course findById(Integer id) {
        Course course;
        try (SqlSession session = MybatisSessionHolder.getSqlSessionFactory().openSession(true)) {
            CourseRepository courseRepository = session.getMapper(CourseRepository.class);
            course = courseRepository.findById(id);
        }
        return course;
    }

    @Override
    public List<Course> findAll() {
        List<Course> courseList;
        try (SqlSession session = MybatisSessionHolder.getSqlSessionFactory().openSession(true)) {
            CourseRepository courseRepository = session.getMapper(CourseRepository.class);
            courseList = courseRepository.findAll();
        }
        return courseList;
    }

    @Override
    public List<Course> findAllWithGrade() {
        List<Course> courseList;
        try (SqlSession session = MybatisSessionHolder.getSqlSessionFactory().openSession(true)) {
            CourseRepository courseRepository = session.getMapper(CourseRepository.class);
            courseList = courseRepository.findAllWithGrade();
        }
        return courseList;
    }

    @Override
    public void update(Course course) {
        try (SqlSession session = MybatisSessionHolder.getSqlSessionFactory().openSession(true)) {
            CourseRepository courseRepository = session.getMapper(CourseRepository.class);
            courseRepository.update(course);
        }
    }

    @Override
    public void delete(Integer id) {
        try (SqlSession session = MybatisSessionHolder.getSqlSessionFactory().openSession(true)) {
            CourseRepository courseRepository = session.getMapper(CourseRepository.class);
            courseRepository.delete(id);
        }
    }
}
