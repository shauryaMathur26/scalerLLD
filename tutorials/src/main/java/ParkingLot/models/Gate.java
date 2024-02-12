package ParkingLot.models;

import ParkingLot.enums.GateStatus;
import ParkingLot.enums.GateType;

public class Gate extends BaseModel{

    private int gateNumber;
    private GateStatus gateStatus;
    private GateType gateType;
    private Operator gateOperator;

    public int getGateNumber() {
        return gateNumber;
    }

    public void setGateNumber(int gateNumber) {
        this.gateNumber = gateNumber;
    }

    public GateStatus getGateStatus() {
        return gateStatus;
    }

    public void setGateStatus(GateStatus gateStatus) {
        this.gateStatus = gateStatus;
    }

    public GateType getGateType() {
        return gateType;
    }

    public void setGateType(GateType gateType) {
        this.gateType = gateType;
    }

    public Operator getGateOperator() {
        return gateOperator;
    }

    public void setGateOperator(Operator gateOperator) {
        this.gateOperator = gateOperator;
    }
}
