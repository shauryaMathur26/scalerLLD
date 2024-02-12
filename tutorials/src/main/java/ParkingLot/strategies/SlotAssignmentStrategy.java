package ParkingLot.strategies;

import ParkingLot.enums.VehicleType;
import ParkingLot.models.Gate;
import ParkingLot.models.ParkingSlot;

public interface SlotAssignmentStrategy {
    ParkingSlot getSlot(VehicleType vehicleType, Gate gate);

    //gate Table
    // RLN b/w Gate and ParkingLot is M : 1
    // Gate Table ->
    // 1. 12 3
}
