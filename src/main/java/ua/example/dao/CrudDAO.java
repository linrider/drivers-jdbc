package ua.example.dao;

import java.util.List;

public interface CrudDAO<T> {
    //TODO
    void save(T t);

    void setTruckToDriverById(int driverId, int truckId);
    
    T findById(int id);

//    void update(T t);
//
//    void deleteById(int id);
   

//    List<T> findAll();
}
