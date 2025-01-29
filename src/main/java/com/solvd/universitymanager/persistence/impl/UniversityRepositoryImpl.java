package com.solvd.universitymanager.persistence.impl;

import com.solvd.universitymanager.domain.core.Department;
import com.solvd.universitymanager.domain.core.Faculty;
import com.solvd.universitymanager.domain.core.University;
import com.solvd.universitymanager.domain.courses.Course;
import com.solvd.universitymanager.persistence.ConnectionPool;
import com.solvd.universitymanager.persistence.UniversityRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UniversityRepositoryImpl implements UniversityRepository {

    private static final Logger LOGGER = LogManager.getLogger(UniversityRepositoryImpl.class);
    private static final ConnectionPool CONNECTION_POOL = ConnectionPool.getInstance();

    private static final String INSERT_SQL = "INSERT INTO universities (name, address) VALUES (?, ?)";
    private static final String SELECT_BY_ID = "SELECT u.id AS university_id, u.name AS university_name, " +
            "u.address AS university_address FROM universities WHERE id = ?";
    private static final String SELECT_ALL = "SELECT u.id AS university_id, u.name AS university_name, " +
            "u.address AS university_address FROM universities";
    private static final String SELECT_ALL_WITH_JOIN =
            "SELECT u.id AS university_id, u.name AS university_name, u.address AS university_address, " +
                    "f.id AS faculty_id, f.name AS faculty_name, " +
                    "d.id AS department_id, d.name AS department_name, " +
                    "c.id AS course_id, c.code AS course_code, c.name AS course_name " +
                    "FROM universities u " +
                    "LEFT JOIN faculties f ON u.id = f.university_id " +
                    "LEFT JOIN departments d ON f.id = d.faculty_id " +
                    "LEFT JOIN courses c ON d.id = c.department_id ";
    private static final String UPDATE_SQL = "UPDATE universities SET name = ?, address = ? WHERE id = ?";
    private static final String DELETE_SQL = "DELETE FROM universities WHERE id = ?";

    @Override
    public void create(University university) {
        Connection connection = CONNECTION_POOL.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(INSERT_SQL, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, university.getName());
            ps.setString(2, university.getAddress());
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                university.setId(rs.getInt(1));
            }
        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
        }finally {
            CONNECTION_POOL.releaseConnection(connection);
        }

    }

    @Override
    public University findById(Integer id) {
        University university = null;
        Connection connection = CONNECTION_POOL.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(SELECT_BY_ID)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                university = new University();
                university.setId(rs.getInt("id"));
                university.setName(rs.getString("name"));
                university.setAddress("address");
            }
        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
        }finally {
            CONNECTION_POOL.releaseConnection(connection);
        }
        return university;
    }

    @Override
    public List<University> findAll() {
        List<University> universities = new ArrayList<>();
        Connection connection = CONNECTION_POOL.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(SELECT_ALL)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                University university = new University();
                university.setId(rs.getInt("id"));
                university.setName(rs.getString("name"));
                university.setAddress("address");
                universities.add(university);
            }
        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
        }finally {
            CONNECTION_POOL.releaseConnection(connection);
        }
        return universities;
    }

    @Override
    public List<University> findAllWithFaculties() {
        List<University> universities = new ArrayList<>();
        Connection connection = CONNECTION_POOL.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(SELECT_ALL_WITH_JOIN)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                University university = new University();
                university.setId(rs.getInt("university_id"));
                university.setName(rs.getString("university_name"));
                university.setAddress(rs.getString("university_address"));

                Faculty faculty = new Faculty();
                faculty.setId(rs.getInt("faculty_id"));
                faculty.setName(rs.getString("faculty_name"));

                if (university.getFaculties() == null) {
                    university.setFaculties(new ArrayList<>());
                }

                Department department = new Department();
                department.setId(rs.getInt("department_id"));
                department.setName(rs.getString("department_name"));

                if (faculty.getDepartments() == null) {
                    faculty.setDepartments(new ArrayList<>());
                }

                Course course = new Course();
                course.setId(rs.getInt("course_id"));
                course.setCode(rs.getInt("course_code"));
                course.setName(rs.getString("course_name"));

                if (department.getCourses() == null) {
                    department.setCourses(new ArrayList<>());
                }

                department.getCourses().add(course);
                faculty.getDepartments().add(department);
                university.getFaculties().add(faculty);
                universities.add(university);
            }
        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
        }finally {
            CONNECTION_POOL.releaseConnection(connection);
        }
        return universities;
    }

    @Override
    public void update(University university) {
        Connection connection = CONNECTION_POOL.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(UPDATE_SQL)) {
            ps.setInt(1, university.getId());
            ps.setString(2, university.getName());
            ps.setString(3, university.getAddress());
            ps.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
        }finally{
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
