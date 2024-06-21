package ua.example.dao;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@FieldDefaults(level = AccessLevel.PUBLIC)
public class DbConnector {
    static final String URL = "jdbc:mysql://localhost:3306/drivers";
    static final String USERNAME = "root";
    static final String PASSWORD = "123";
    static Connection connection;

    public static Connection getConnection() throws SQLException {
        if (connection == null) {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        }
        return connection;
    }
}
