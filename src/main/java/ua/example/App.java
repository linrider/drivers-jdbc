package ua.example;

import ua.example.entity.Driver;
import ua.example.entity.Qualification;
import ua.example.entity.Truck;
import ua.example.service.CrudService;
import ua.example.service.impl.DriverServiceImpl;
import ua.example.service.impl.TruckServiceImpl;

public class App {
    public static void main(String[] args) {
        CrudService<Driver> driverCrudService = new DriverServiceImpl();
        // CrudService<Truck> truckCrudService = new TruckServiceImpl();
        // Driver driver = Driver.builder()
        //         .firstName("Ken")
        //         .lastName("Baker")
        //         .age(21)
        //         .qualification(Qualification.TRAINY)
        //         .build(); 
        // Truck truck = Truck.builder()
        //         .model("CITROEN")
        //         .modelYear(2024)
        //         .build();
        // driverCrudService.save(driver);
        // truckCrudService.save(truck);
        // driverCrudService.setTruckToDriverById(2,3);

        System.out.println(driverCrudService.findById(1));
    }
}
