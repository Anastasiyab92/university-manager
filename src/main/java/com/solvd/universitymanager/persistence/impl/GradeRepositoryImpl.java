package com.solvd.universitymanager.persistence.impl;

import com.solvd.universitymanager.domain.courses.Grade;
import com.solvd.universitymanager.persistence.ConnectionPool;
import com.solvd.universitymanager.persistence.GradeRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GradeRepositoryImpl implements GradeRepository {

    private static final Logger LOGGER = LogManager.getLogger(GradeRepositoryImpl.class);
    private static final ConnectionPool CONNECTION_POOL = ConnectionPool.getInstance();

    private static final String INSERT_SQL = "INSERT INTO grades (value) VALUES (?)";
    private static final String SELECT_BY_ID = "SELECT g.id AS grade_id, g.value AS grade_value FROM grades WHERE id = ?";
    private static final String SELECT_ALL = "SELECT g.id AS grade_id, g.value AS grade_value FROM grades";
    private static final String UPDATE_SQL = "UPDATE grades SET value = ?, WHERE id = ?";
    private static final String DELETE_SQL = "DELETE FROM grades WHERE id = ?";


    @Override
    public void create(Grade grade) {
        Connection connection = CONNECTION_POOL.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(INSERT_SQL, Statement.RETURN_GENERATED_KEYS)) {
            ps.setDouble(1, grade.getGradeValue());
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                grade.setId(rs.getLong(1));
            }
        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
        }finally {
            CONNECTION_POOL.releaseConnection(connection);
        }
    }

    @Override
    public Grade findById(Long id) {
        Grade grade = null;
        Connection connection = CONNECTION_POOL.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(SELECT_BY_ID)) {
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                grade = new Grade();
                grade.setId(rs.getLong("id"));
                grade.setGradeValue(rs.getDouble("value"));
            }
        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
        }finally {
            CONNECTION_POOL.releaseConnection(connection);
        }
        return grade;
    }

    @Override
    public List<Grade> findAll() {
        List<Grade> grades = new ArrayList<>();
        Connection connection = CONNECTION_POOL.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(SELECT_ALL)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Grade grade = new Grade();
                grade.setId(rs.getLong("id"));
                grade.setGradeValue(rs.getDouble("value"));
                grades.add(grade);
            }
        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
        }finally {
            CONNECTION_POOL.releaseConnection(connection);
        }
        return grades;
    }

    @Override
    public void update(Grade grade) {
        Connection connection = CONNECTION_POOL.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(UPDATE_SQL)) {
            ps.setLong(1, grade.getId());
            ps.setDouble(2, grade.getGradeValue());
            ps.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
        }finally {
            CONNECTION_POOL.releaseConnection(connection);
        }
    }

    @Override
    public void delete(Long id) {
        Connection connection = CONNECTION_POOL.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(DELETE_SQL)) {
            ps.setLong(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
        }finally {
            CONNECTION_POOL.releaseConnection(connection);
        }
    }
}

