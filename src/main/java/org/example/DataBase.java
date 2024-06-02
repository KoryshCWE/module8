package org.example;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

class Database {
    private static Database instance;
    private Connection connection;
    HikariConfig config = new HikariConfig();
    HikariDataSource ds;


    private Database() {
        try {
            config.setJdbcUrl("jdbc:postgresql://localhost:5432/postgres");
            config.setUsername("postgres");
            config.setPassword("su");
            ds = new HikariDataSource(config);
            connection = ds.getConnection();


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public HikariDataSource getDs() {
        return ds;
    }

    public static synchronized Database getInstance() {
        if (instance == null) {
            instance = new Database();
        }
        return instance;
    }

    public Connection getConnection() {
        return connection;
    }
}
