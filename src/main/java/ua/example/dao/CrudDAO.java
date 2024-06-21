package ua.example.dao;

import java.util.List;

public interface CrudDAO<T> {
    //TODO
    void save(T t);

    void setTruckToDriverById(int driverId, int truckId);

//    void update(T t);
//
//    void deleteById(int id);
    //TODO
//    T findById(int id);

//    List<T> findAll();
}
