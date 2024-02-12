package ParkingLot.models;

import ParkingLot.enums.PaymentMode;
import ParkingLot.enums.PaymentStatus;

import java.util.Date;

public class Payment extends BaseModel{

    private String referenceNumber;
    private int amount;
    private Date time;
    private PaymentMode mode;
    private PaymentStatus status;

    public String getReferenceNumber() {
        return referenceNumber;
    }

    public void setReferenceNumber(String referenceNumber) {
        this.referenceNumber = referenceNumber;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public PaymentMode getMode() {
        return mode;
    }

    public void setMode(PaymentMode mode) {
        this.mode = mode;
    }

    public PaymentStatus getStatus() {
        return status;
    }

    public void setStatus(PaymentStatus status) {
        this.status = status;
    }
}
