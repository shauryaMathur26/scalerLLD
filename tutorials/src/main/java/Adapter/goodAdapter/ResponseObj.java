package Adapter.goodAdapter;

public class ResponseObj {
    String status;
    double amount;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public ResponseObj(String status, double amount){
        this.status = status;
        this.amount = amount;
    }
}
