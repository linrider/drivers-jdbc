package ua.example.dao.impl;

import ua.example.dao.CrudDAO;
import ua.example.dao.DbConnector;
import ua.example.entity.Driver;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class DriverDaoImpl implements CrudDAO<Driver> {

    @Override
    public void save(Driver driver) {
        String sqlQuery = "INSERT INTO drivers (first_name, last_name, age, qualification) VALUES (?, ?, ?, ?)";

        try (Connection connection = DbConnector.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery)) {
            preparedStatement.setString(1, driver.getFirstName());
            preparedStatement.setString(2, driver.getLastName());
            preparedStatement.setInt(3, driver.getAge());
            preparedStatement.setString(4, String.valueOf(driver.getQualification()));
            preparedStatement.execute();
        } catch (SQLException e) {
            System.out.println("Failed db connection");
        }
    }

    public void setTruckToDriverById(int driverId, int truckId) {
        String sqlQuery = "UPDATE trucks SET fk_driver_id = ? WHERE driver_id = ?";

        try (Connection connection = DbConnector.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery)) {
                    preparedStatement.setInt(1, driverId);
                    preparedStatement.setInt(2, truckId);
                    preparedStatement.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Failed db connection");
        }
    }

    // @Override
    // public void update(Driver driver) {
    //
    // }
    //
    // @Override
    // public void deleteById(int id) {
    //
    // }

    // @Override
    // public Driver findById(int id) {
    // return null;
    // }

    // @Override
    // public List<Driver> findAll() {
    // return List.of();
    // }
}
