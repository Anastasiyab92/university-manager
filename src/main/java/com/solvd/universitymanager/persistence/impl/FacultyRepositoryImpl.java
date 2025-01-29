package com.solvd.universitymanager.persistence.impl;

import com.solvd.universitymanager.domain.core.Department;
import com.solvd.universitymanager.domain.core.Faculty;
import com.solvd.universitymanager.persistence.ConnectionPool;
import com.solvd.universitymanager.persistence.FacultyRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FacultyRepositoryImpl implements FacultyRepository {

    private static final Logger LOGGER = LogManager.getLogger(FacultyRepositoryImpl.class);
    private static final ConnectionPool CONNECTION_POOL = ConnectionPool.getInstance();

    private static final String INSERT_SQL = "INSERT INTO faculties (name, university_id) VALUES (?, ?)";
    private static final String SELECT_BY_ID = "SELECT f.id AS faculty_id, f.name AS faculty_name FROM faculties WHERE id = ?";
    private static final String SELECT_ALL = "SELECT f.id AS faculty_id, f.name AS faculty_name FROM faculties";
    private static final String SELECT_WITH_JOIN =
            "SELECT f.id AS faculty_id, f.name AS faculty_name" +
                    "d.id AS department_id, d.name AS department_name" +
                    "FROM faculties f" +
                    "LEFT JOIN departments d ON f.id = d.faculty_id";
    private static final String UPDATE_SQL = "UPDATE faculties SET name = ?, WHERE id = ?";
    private static final String DELETE_SQL = "DELETE FROM faculties WHERE id = ?";


    @Override
    public void create(Faculty faculty, Integer universityId) {
        Connection connection = CONNECTION_POOL.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(INSERT_SQL, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, faculty.getName());
            ps.setInt(2, universityId);
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            if(rs.next()) {
                faculty.setId(rs.getInt(1));
            }
        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
        }finally {
            CONNECTION_POOL.releaseConnection(connection);
        }
    }

    @Override
    public Faculty findById(Integer id) {
        Faculty faculty = null;
        Connection connection = CONNECTION_POOL.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(SELECT_BY_ID)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                faculty = new Faculty();
                faculty.setId(rs.getInt("id"));
                faculty.setName(rs.getString("name"));
            }
        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
        }finally {
            CONNECTION_POOL.releaseConnection(connection);
        }
        return faculty;
    }

    @Override
    public List<Faculty> findAll() {
        List<Faculty> faculties = new ArrayList<>();
        Connection connection = CONNECTION_POOL.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(SELECT_ALL)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Faculty faculty = new Faculty();
                faculty.setId(rs.getInt("id"));
                faculty.setName(rs.getString("name"));
                faculties.add(faculty);
            }
        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
        }finally {
            CONNECTION_POOL.releaseConnection(connection);
        }
        return faculties;
    }

    @Override
    public List<Faculty> findAllWithDepartments() {
        List<Faculty> faculties = new ArrayList<>();
        Connection connection = CONNECTION_POOL.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(SELECT_WITH_JOIN)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Faculty faculty = new Faculty();
                faculty.setId(rs.getInt("faculty_id"));
                faculty.setName(rs.getString("faculty_name"));

                Department department = new Department();
                department.setId(rs.getInt("department_id"));
                department.setName(rs.getString("department_name"));

                if (faculty.getDepartments() == null) {
                    faculty.setDepartments(new ArrayList<>());
                }
                faculty.getDepartments().add(department);
                faculties.add(faculty);
            }
        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
        }finally {
            CONNECTION_POOL.releaseConnection(connection);
        }
        return faculties;
    }

    @Override
    public void update(Faculty faculty) {
        Connection connection = CONNECTION_POOL.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(UPDATE_SQL)) {
            ps.setInt(1, faculty.getId());
            ps.setString(2, faculty.getName());
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
