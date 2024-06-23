package ua.example.dao.impl;

import ua.example.dao.CrudDAO;
import ua.example.dao.DbConnector;
import ua.example.entity.Truck;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
public class TruckDaoImpl implements CrudDAO<Truck> {
    DbConnector connector = DbConnector.getInstance();
    Connection connection = connector.getConnection();

    @Override
    public void save(Truck truck) {
        String sqlQuery = "INSERT INTO trucks (model, model_year) VALUES (?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery)) {
            preparedStatement.setString(1, truck.getModel());
            preparedStatement.setInt(2, truck.getModelYear());
            preparedStatement.execute();
        } catch (SQLException e) {
            System.out.println("Failed db connection");
        }
    }

    @Override
    public void setTruckToDriverById(int driverId, int truckId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setTruckToDriverById'");
    }

    @Override
    public Truck findById(int id) {
        String sqlQuery = "SELECT * " +
                        "FROM trucks " + 
                        "WHERE truck_id = ?";
        Truck truck = new Truck();
        try (PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery)) {
            
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            truck.setId(resultSet.getInt("truck_id"));
            truck.setModel(resultSet.getString("model"));
            truck.setModelYear(resultSet.getInt("model_year"));
            
        } catch (SQLException e) {
            System.out.println("Failed db connection");
        }

    return truck;
    }
    // @Override
    // public void update(Truck truck) {
    //
    // }
    //
    // @Override
    // public void deleteById(int id) {
    //
    // }

    

    // @Override
    // public List<Truck> findAll() {
    // return List.of();
    // }
}
