package Adapter.goodAdapter;

public class Client {
    public static void main(String[] args) {
        //Inject Dependency
        // A Simple/Practical factory can be used here to get correct object of adapter
        Phonepe phonepe = new Phonepe(new ICICIBankAdapter());
        System.out.println("Balance is - " + phonepe.findMyBalance());
    }
}
