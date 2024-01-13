package Adapter.badAdapter;

import Adapter.thirdPartyBankAPIs.ICICIBankAPI;
import Adapter.thirdPartyBankAPIs.YesBankAPI;

public class PhonePe {
    //Tight coupling
    YesBankAPI bankAPI = new YesBankAPI();

//    ICICIBankAPI bankAPI = new ICICIBankAPI();

    public int findMyBalance(){
        //Works well with YesBankAPI
        return bankAPI.checkBalance();

        //Will have to make many changes if ICICIBankAPI is to be used

    }
}
