package ua.example.service.impl;

import ua.example.dao.CrudDAO;
import ua.example.dao.impl.DriverDaoImpl;
import ua.example.entity.Driver;
import ua.example.service.CrudService;

import java.util.List;

public class DriverServiceImpl implements CrudService<Driver> {
    CrudDAO<Driver> driverDAO;


    public DriverServiceImpl() {
        this.driverDAO = new DriverDaoImpl();
    }



    @Override
    public void save(Driver driver) {
        driverDAO.save(driver);
    }

    public void setTruckToDriverById(int driverId, int truckId) {
        driverDAO.setTruckToDriverById(driverId, truckId);
    }

//    @Override
//    public void update(Driver driver) {
//        driverDAO.update(driver);
//    }
//
//    @Override
//    public void deleteById(int id) {
//        driverDAO.deleteById(id);
//    }
//
//    @Override
//    public Driver findById(int id) {
//        return driverDAO.findById(id);
//    }
//
//    @Override
//    public List<Driver> findAll() {
//        return driverDAO.findAll();
//    }
}
