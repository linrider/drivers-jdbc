package ua.example;

import ua.example.entity.Driver;
import ua.example.entity.Qualification;
import ua.example.entity.Truck;
import ua.example.service.CrudService;
import ua.example.service.impl.DriverServiceImpl;
import ua.example.service.impl.TruckServiceImpl;

public class App {
    public static void main(String[] args) {
        // CrudService<Driver> driverCrudService = new DriverServiceImpl();
        CrudService<Truck> truckCrudService = new TruckServiceImpl();
        /* Driver driver = Driver.builder()
                .firstName("John")
                .lastName("Doe")
                .age(28)
                .qualification(Qualification.PRO)
                .build();  */
        Truck truck = Truck.builder()
                .model("DAF")
                .modelYear(2018)
                .build();
        truckCrudService.save(truck);

    }
}
