package ua.example.service;

import java.util.List;

public interface CrudService<T> {
    public void save(T t);
    
    public void setTruckToDriverById(int driverId, int truckId);

    public T findById(int id);

//    public void update(T t);
//
//    public void deleteById(int id);
//
//    
//
//    public List<T> findAll();
}
