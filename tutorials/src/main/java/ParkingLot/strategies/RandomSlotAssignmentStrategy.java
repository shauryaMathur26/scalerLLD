package ParkingLot.strategies;

import ParkingLot.enums.ParkingSlotStatus;
import ParkingLot.enums.VehicleType;
import ParkingLot.models.Gate;
import ParkingLot.models.ParkingFloor;
import ParkingLot.models.ParkingLot;
import ParkingLot.models.ParkingSlot;
import ParkingLot.repositories.ParkingLotRepository;

public class RandomSlotAssignmentStrategy implements SlotAssignmentStrategy{

    private ParkingLotRepository parkingLotRepository;

    public RandomSlotAssignmentStrategy(ParkingLotRepository parkingLotRepository){
        this.parkingLotRepository = parkingLotRepository; // DI
    }

    @Override
    public ParkingSlot getSlot(VehicleType vehicleType, Gate gate) {
        ParkingLot parkingLot = parkingLotRepository.getParkingLotByGateId(gate.getId());

        for(ParkingFloor parkingFloor : parkingLot.getParkingFloors()){
            for(ParkingSlot parkingSlot : parkingFloor.getParkingSlots()){
                if(parkingSlot.getAllowedVehicleType().equals(vehicleType)
                        && parkingSlot.getParkingSlotStatus().equals(ParkingSlotStatus.UNOCCUPIED)){
                    return parkingSlot;
                }
            }
        }
        return null;
    }
}
