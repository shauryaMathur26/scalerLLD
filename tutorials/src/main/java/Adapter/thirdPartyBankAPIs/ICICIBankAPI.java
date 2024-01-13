package Adapter.thirdPartyBankAPIs;

import Adapter.goodAdapter.ResponseObj;

public class ICICIBankAPI {
    public ResponseObj balanceCheck(){
        return new ResponseObj("COMPLETED",135.3);
    }
}
