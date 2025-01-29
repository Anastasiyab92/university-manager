package com.solvd.universitymanager.persistence.impl;

import com.solvd.universitymanager.domain.core.Department;
import com.solvd.universitymanager.domain.courses.Course;
import com.solvd.universitymanager.persistence.ConnectionPool;
import com.solvd.universitymanager.persistence.DepartmentRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DepartmentRepositoryImpl implements DepartmentRepository {

    private static final Logger LOGGER = LogManager.getLogger(DepartmentRepositoryImpl.class);
    private static final ConnectionPool CONNECTION_POOL = ConnectionPool.getInstance();

    private static final String INSERT_SQL = "INSERT INTO departments (name, faculty_id) VALUES (?, ?)";
    private static final String SELECT_BY_ID = "SELECT d.id AS department_id, d.name AS department_name FROM departments WHERE id = ?";
    private static final String SELECT_ALL = "SELECT d.id AS department_id, d.name AS department_name * FROM departments";
    private static final String SELECT_WITH_JOIN =
            "SELECT d.id AS department_id, d.name AS department_name" +
                    "c.id AS course_id, c.code AS course_code, c.name AS course_name" +
                    "FORM departments d " +
                    "LEFT JOIN courses c ON d.id = c.department_id";
    private static final String UPDATE_SQL = "UPDATE departments SET name = ?, WHERE id = ?";
    private static final String DELETE_SQL = "DELETE FROM departments WHERE id = ?";

    @Override
    public void create(Department department, Integer facultyId) {
        Connection connection = CONNECTION_POOL.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(INSERT_SQL, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, department.getName());
            ps.setInt(2, facultyId);
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            if(rs.next()) {
                department.setId(rs.getInt(1));
            }
        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
        }finally {
            CONNECTION_POOL.releaseConnection(connection);
        }
    }

    @Override
    public Department findById(Integer id) {
        Department department = null;
        Connection connection = CONNECTION_POOL.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(SELECT_BY_ID)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                department = new Department();
                department.setId(rs.getInt("id"));
                department.setName(rs.getString("name"));
            }
        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
        }finally {
            CONNECTION_POOL.releaseConnection(connection);
        }
        return department;
    }

    @Override
    public List<Department> findAll() {
        List<Department> departments = new ArrayList<>();
        Connection connection = CONNECTION_POOL.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(SELECT_ALL)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Department department = new Department();
                department.setId(rs.getInt("id"));
                department.setName(rs.getString("name"));
                departments.add(department);
            }
        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
        }finally {
            CONNECTION_POOL.releaseConnection(connection);
        }
        return departments;
    }

    @Override
    public List<Department> findAllWithCourses() {
        List<Department> departments = new ArrayList<>();
        Connection connection = CONNECTION_POOL.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(SELECT_WITH_JOIN)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Department department = new Department();
                department.setId(rs.getInt("department_id"));
                department.setName(rs.getString("department_name"));

                Course course = new Course();
                course.setId(rs.getInt("course_id"));
                course.setCode(rs.getInt("course_code"));
                course.setName(rs.getString("course_name"));

                if (department.getCourses() == null) {
                    department.setCourses(new ArrayList<>());
                }
                department.getCourses().add(course);
                departments.add(department);
            }
        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
        }finally {
            CONNECTION_POOL.releaseConnection(connection);
        }
        return departments;
    }

    @Override
    public void update(Department department) {
        Connection connection = CONNECTION_POOL.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(UPDATE_SQL)) {
            ps.setInt(1, department.getId());
            ps.setString(2, department.getName());
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
