package ParkingLot.repositories;

import ParkingLot.models.Gate;

import java.util.Optional;

public class GateRepository {
    public Optional<Gate> getGateById(Long gateId){
        // select * from gate where id = :gateId
        return null;
    }
}
