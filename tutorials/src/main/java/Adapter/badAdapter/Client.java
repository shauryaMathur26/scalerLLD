package Adapter.badAdapter;

public class Client {
    public static void main(String[] args) {
        PhonePe phonePe = new PhonePe();
        System.out.println("My Balance is " + phonePe.findMyBalance());
    }



}
