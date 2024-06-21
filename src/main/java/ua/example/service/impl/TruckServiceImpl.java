package ua.example.service.impl;

import ua.example.dao.CrudDAO;
import ua.example.dao.impl.TruckDaoImpl;
import ua.example.entity.Truck;
import ua.example.service.CrudService;

import java.util.List;

public class TruckServiceImpl implements CrudService<Truck> {
    CrudDAO<Truck> truckDAO;


    public TruckServiceImpl() {
        this.truckDAO = new TruckDaoImpl();
    }


    @Override
    public void save(Truck truck) {
        truckDAO.save(truck);
    }

//    @Override
//    public void update(Truck truck) {
//        truckDAO.update(truck);
//    }
//
//    @Override
//    public void deleteById(int id) {
//        truckDAO.deleteById(id);
//    }
//
//    @Override
//    public Truck findById(int id) {
//        return truckDAO.findById(id);
//    }
//
//    @Override
//    public List<Truck> findAll() {
//        return truckDAO.findAll();
//    }
}
