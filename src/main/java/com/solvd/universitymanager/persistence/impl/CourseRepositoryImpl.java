package com.solvd.universitymanager.persistence.impl;

import com.solvd.universitymanager.domain.courses.Course;
import com.solvd.universitymanager.domain.courses.Grade;
import com.solvd.universitymanager.persistence.ConnectionPool;
import com.solvd.universitymanager.persistence.CourseRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CourseRepositoryImpl implements CourseRepository {

    private static final Logger LOGGER = LogManager.getLogger(CourseRepositoryImpl.class);
    private static final ConnectionPool CONNECTION_POOL = ConnectionPool.getInstance();

    private static final String INSERT_SQL = "INSERT INTO courses (name, code, department_id) VALUES (?, ?, ?)";
    private static final String SELECT_BY_ID = "SELECT c.id AS course_id, c.code AS course_code, c.name AS course_name FROM courses WHERE id = ?";
    private static final String SELECT_ALL = "SELECT c.id AS course_id, c.code AS course_code, c.name AS course_name FROM courses";
    private static final String SELECT_WITH_JOIN =
            "SELECT c.id AS course_id, c.code AS course_code, c.name AS course_name" +
                    "g.id AS grade_id, g.value AS grade_value" +
                    "FROM courses c " +
                    "LEFT JOIN grades g ON c.id = g.course_id";
    private static final String UPDATE_SQL = "UPDATE courses SET code = ?, name = ?, WHERE id = ?";
    private static final String DELETE_SQL = "DELETE FROM courses WHERE id = ?";


    @Override
    public void create(Course course, Integer departmentId) {
        Connection connection = CONNECTION_POOL.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(INSERT_SQL, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, course.getName());
            ps.setInt(2, course.getCode());
            ps.setInt(3, departmentId);
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            while (rs.next()) {
                course.setId(rs.getInt(1));
            }
        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
        }finally {
            CONNECTION_POOL.releaseConnection(connection);
        }
    }

    @Override
    public Course findById(Integer id) {
        Course course = null;
        Connection connection = CONNECTION_POOL.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(SELECT_BY_ID)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                course = new Course();
                course.setId(rs.getInt("id"));
                course.setCode(rs.getInt("code"));
                course.setName(rs.getString("name"));
            }
        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
        }finally {
            CONNECTION_POOL.releaseConnection(connection);
        }
        return course;
    }

    @Override
    public List<Course> findAll() {
        List<Course> courses = new ArrayList<>();
        try (Connection connection = CONNECTION_POOL.getConnection();
             PreparedStatement ps = connection.prepareStatement(SELECT_ALL)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Course course = new Course();
                course.setId(rs.getInt("id"));
                course.setCode(rs.getInt("code"));
                course.setName(rs.getString("name"));
                courses.add(course);
            }
        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
        }
        return courses;
    }

    @Override
    public List<Course> findAllWithGrades() {
        List<Course> courses = new ArrayList<>();
        Connection connection = CONNECTION_POOL.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(SELECT_WITH_JOIN)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Course course = new Course();
                course.setId(rs.getInt("course_id"));
                course.setCode(rs.getInt("course_code"));
                course.setName(rs.getString("course_name"));

                Grade grade = new Grade();
                grade.setId(rs.getLong("grade_id"));
                grade.setGradeValue(rs.getInt("grade_value"));

                course.setGrade(grade);
                courses.add(course);
            }

        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
        }finally {
            CONNECTION_POOL.releaseConnection(connection);
        }
        return courses;
    }

    @Override
    public void update(Course course) {
        Connection connection = CONNECTION_POOL.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(UPDATE_SQL)) {
            ps.setInt(1, course.getId());
            ps.setString(2, course.getName());
            ps.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
        }finally {
            CONNECTION_POOL.releaseConnection(connection);
        }
    }

    @Override
    public void delete(Integer id) {
        Connection connection = CONNECTION_POOL.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(DELETE_SQL)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
        }finally {
            CONNECTION_POOL.releaseConnection(connection);
        }
    }
}

