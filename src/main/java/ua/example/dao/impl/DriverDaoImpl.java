package ua.example.dao.impl;

import ua.example.dao.CrudDAO;
import ua.example.dao.DbConnector;
import ua.example.entity.Driver;
import ua.example.entity.Qualification;
import ua.example.entity.Truck;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
public class DriverDaoImpl implements CrudDAO<Driver> {
    private DbConnector connector = DbConnector.getInstance();
    private Connection connection = connector.getConnection();

    @Override
    public void save(Driver driver) {
        String sqlQuery = "INSERT INTO drivers (first_name, last_name, age, qualification) " + 
                        "VALUES (?, ?, ?, ?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery)) {
            preparedStatement.setString(1, driver.getFirstName());
            preparedStatement.setString(2, driver.getLastName());
            preparedStatement.setInt(3, driver.getAge());
            preparedStatement.setString(4, String.valueOf(driver.getQualification()));
            preparedStatement.execute();
        } catch (SQLException e) {
            System.out.println("Failed db connection");
        }
    }

    @Override
    public void setTruckToDriverById(int driverId, int truckId) {
        String sqlQuery = "UPDATE trucks " + 
                        "SET fk_driver_id = ? " + 
                        "WHERE truck_id = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery)) {
                    preparedStatement.setInt(1, driverId);
                    preparedStatement.setInt(2, truckId);
                    preparedStatement.execute();

        } catch (SQLException e) {
            System.out.println("Failed db connection");
        }
    }

    @Override
    public Driver findById(int id) {
        String sqlQueryDriver = "SELECT * " + 
                                "FROM drivers " +
                                "WHERE driver_id = ?";
        String sqlQueryTrucks = "SELECT t.truck_id, t.model, t.model_year " + 
                                "FROM drivers d " + 
                                "INNER JOIN trucks t " + 
                                "ON t.fk_driver_id = d.driver_id " + 
                                "WHERE d.driver_id = ?";
        Driver driver = new Driver();
        
        try (PreparedStatement pStatementDriver = connection.prepareStatement(sqlQueryDriver)) {
                pStatementDriver.setInt(1, id);

                ResultSet resultSetDriver = pStatementDriver.executeQuery();
                resultSetDriver.next();
                driver.setId(resultSetDriver.getInt("driver_id"));
                driver.setFirstName(resultSetDriver.getString("first_name"));
                driver.setLastName(resultSetDriver.getString("last_name"));
                driver.setAge(resultSetDriver.getInt("age"));
                driver.setQualification(switch (resultSetDriver.getString("qualification")) {
                                            case "TRAINY" -> Qualification.TRAINY;
                                            case "PRO" -> Qualification.PRO;
                                            case "EXPERT" -> Qualification.EXPERT;
                                            default -> throw new IllegalArgumentException("Unexpected value: " + 
                                                resultSetDriver.getString("qualification"));
                                        
                });
        } catch (SQLException e) {
            System.out.println("Failed db connection");
        }

        try (PreparedStatement pStatementTrucks = connection.prepareStatement(sqlQueryTrucks)) {
            pStatementTrucks.setInt(1, id);

            ResultSet resultSetTrucks = pStatementTrucks.executeQuery();
                List<Truck> trucks = new ArrayList<>();
                while (resultSetTrucks.next()) {
                    Truck truck = new Truck();
                    truck.setId(resultSetTrucks.getInt("truck_id"));
                    truck.setModel(resultSetTrucks.getString("model"));
                    truck.setModelYear(resultSetTrucks.getInt("model_year"));
                    trucks.add(truck);
                }

                driver.setTrucks(trucks);

        } catch (SQLException e) {
            System.out.println("Failed db connection");
        }
    return driver;
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
    // public List<Driver> findAll() {
    // return List.of();
    // }
}
