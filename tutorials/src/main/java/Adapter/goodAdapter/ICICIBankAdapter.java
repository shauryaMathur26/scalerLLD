package Adapter.goodAdapter;

import Adapter.thirdPartyBankAPIs.ICICIBankAPI;

public class ICICIBankAdapter implements BankAPI{

    ICICIBankAPI bankAPI = new ICICIBankAPI();
    @Override
    public double getBalance() {

        //3rd party response
        ResponseObj responseObj = bankAPI.balanceCheck();
        //Adapter will work on data received form 3rd party
        // and Convert for needs of the BankAPI interface.
        return responseObj.getAmount();
    }
}
