package ParkingLot.models;

import ParkingLot.enums.ParkingSlotStatus;
import ParkingLot.enums.VehicleType;

import java.util.List;

public class ParkingSlot extends BaseModel{
    private VehicleType allowedVehicleType;
    private ParkingSlotStatus parkingSlotStatus;
    private ParkingFloor floor;
    private int slotNumber;

    public VehicleType getAllowedVehicleType() {
        return allowedVehicleType;
    }

    public void setAllowedVehicleType(VehicleType allowedVehicleType) {
        this.allowedVehicleType = allowedVehicleType;
    }

    public ParkingSlotStatus getParkingSlotStatus() {
        return parkingSlotStatus;
    }

    public void setParkingSlotStatus(ParkingSlotStatus parkingSlotStatus) {
        this.parkingSlotStatus = parkingSlotStatus;
    }

    public ParkingFloor getFloor() {
        return floor;
    }

    public void setFloor(ParkingFloor floor) {
        this.floor = floor;
    }

    public int getSlotNumber() {
        return slotNumber;
    }

    public void setSlotNumber(int slotNumber) {
        this.slotNumber = slotNumber;
    }
}
