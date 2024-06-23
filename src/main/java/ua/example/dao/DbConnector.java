package ua.example.dao;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@FieldDefaults(level = AccessLevel.PRIVATE)
public class DbConnector {
    final String URL = "jdbc:mysql://localhost:3306/drivers";
    final String USERNAME = "root";
    final String PASSWORD = "123";
    Connection connection;

    private DbConnector() {

        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            System.out.println("DB isn't accessable");
            e.printStackTrace();
        }
    }

    private static class DbConnectorHelper {
        private static final DbConnector INSTANCE = new DbConnector();
    }

    public static DbConnector getInstance() {
        return DbConnectorHelper.INSTANCE;
    }

    public Connection getConnection() {
        return connection;
    }
}
