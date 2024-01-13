package Adapter.goodAdapter;

import Adapter.thirdPartyBankAPIs.YesBankAPI;

public class YesBankAdapter implements BankAPI {

    private YesBankAPI bankAPI = new YesBankAPI();

    @Override
    public double getBalance() {
        //3rd party response
        int balance = bankAPI.checkBalance();
        //Adapter will work on data received form 3rd party
        // and Convert for needs of the BankAPI interface.
        return Double.valueOf(balance);

    }
}
