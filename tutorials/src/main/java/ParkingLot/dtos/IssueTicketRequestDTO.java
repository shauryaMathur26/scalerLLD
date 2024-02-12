package ParkingLot.dtos;

import ParkingLot.enums.VehicleType;
import ParkingLot.models.Gate;
import ParkingLot.models.ParkingSlot;
import ParkingLot.models.Vehicle;

public class IssueTicketRequestDTO {

    private Long gateId;
    private VehicleType vehicleType;
    private String vehicleNumber;
    private String ownerName;

    public Long getGateId() {
        return gateId;
    }

    public void setGateId(Long gateId) {
        this.gateId = gateId;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }
}
