package ParkingLot.repositories;

import ParkingLot.models.Vehicle;

import java.util.Optional;

public class VehicleRepository { //CRUD behaviours for Vehicle

    // 1. It is a new vehicle -> store and return
    // 2. If it exists -> simply get and return

    public Optional<Vehicle> findVehicleByNumber(String vehicleNumber){
        return Optional.empty();
    }

    public Vehicle insertVehicle(Vehicle vehicle){
        return null;
    }
}
