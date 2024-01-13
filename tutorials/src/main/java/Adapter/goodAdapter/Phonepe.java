package Adapter.goodAdapter;

public class Phonepe {

    //Loose coupling
    //Factory
//    BankAPI bankAPI = new ICICIBankAdapter();

    BankAPI bankAPI;

    //Dependency Injection
    public Phonepe(BankAPI bankAPI){
        this.bankAPI = bankAPI;
    }

    public double findMyBalance(){

        return bankAPI.getBalance();
    }
}
