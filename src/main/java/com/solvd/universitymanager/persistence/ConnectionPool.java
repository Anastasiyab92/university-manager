package com.solvd.universitymanager.persistence;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ConnectionPool {

    private static final Logger LOGGER = LogManager.getLogger(ConnectionPool.class);

    private static final String JDBC_URL;
    private static final String JDBC_USERNAME;
    private static final String JDBC_PASSWORD;
    private static final int POOL_SIZE;
    private static ConnectionPool instance;

    static {
        JDBC_URL = Config.get("url");
        JDBC_USERNAME = Config.get("username");
        JDBC_PASSWORD = Config.get("password");

        String poolSizeStr = Config.get("poolSize");
        if (poolSizeStr == null || poolSizeStr.isEmpty()) {
            throw new RuntimeException("Property 'poolSize' is missing or empty in config.properties");
        }

        try {
            POOL_SIZE = Integer.parseInt(poolSizeStr);
        } catch (NumberFormatException e) {
            throw new RuntimeException("Invalid value for 'poolSize' in config.properties. Must be an integer.", e);
        }
    }

    private final BlockingQueue<Connection> connectionBlockingQueue;

    public ConnectionPool() {
        connectionBlockingQueue = new ArrayBlockingQueue<>(POOL_SIZE);
        for (int i = 0; i < POOL_SIZE; i++) {
            try {
                connectionBlockingQueue.add(creatConnection());
            } catch (SQLException e) {
                throw new RuntimeException("Failed to create database connection", e);
            }

        }
    }

    public static synchronized ConnectionPool getInstance() {
        if (instance == null) {
            instance = new ConnectionPool();
        }
        return instance;
    }

    private Connection creatConnection() throws SQLException {
        return DriverManager.getConnection(JDBC_URL, JDBC_USERNAME, JDBC_PASSWORD);
    }

    public Connection getConnection() {
        try {
            return connectionBlockingQueue.take();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            LOGGER.error("Thread was interrupted while waiting for a connection: ", e);
        } catch (Exception e) {
            LOGGER.error("Unexpected error while getting a connection: ", e);
        }
        return null;
    }

    public void releaseConnection(Connection connection) {
            try {
                connectionBlockingQueue.put(connection);
            }catch (InterruptedException e){
                Thread.currentThread().interrupt();
            }
    }

    public void shutdown() throws SQLException {
        for (Connection connection : connectionBlockingQueue) {
            connection.close();
        }
    }
}

