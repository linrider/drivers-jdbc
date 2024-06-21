package ua.example.dao.impl;

import ua.example.dao.CrudDAO;
import ua.example.dao.DbConnector;
import ua.example.entity.Truck;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class TruckDaoImpl implements CrudDAO<Truck> {
    @Override
    public void save(Truck truck) {
        String sqlQuery = "INSERT INTO trucks (model, model_year) VALUES (?, ?)";
        try (Connection connection = DbConnector.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery)) {
            preparedStatement.setString(1, truck.getModel());
            preparedStatement.setInt(2, truck.getModelYear());
            preparedStatement.execute();
        } catch (
                SQLException e) {
            System.out.println("Failed db connection");
        }
    }

    @Override
    public void setTruckToDriverById(int driverId, int truckId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setTruckToDriverById'");
    }

//    @Override
//    public void update(Truck truck) {
//
//    }
//
//    @Override
//    public void deleteById(int id) {
//
//    }

//    @Override
//    public Truck findById(int id) {
//        return null;
//    }

//    @Override
//    public List<Truck> findAll() {
//        return List.of();
//    }
}
