package ParkingLot.repositories;

import ParkingLot.models.Gate;
import ParkingLot.models.ParkingLot;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class ParkingLotRepository {
    private Map<Long,ParkingLot> parkingLots = new TreeMap<>();
     public ParkingLot getParkingLotByGateId(Long gateId){
         for(ParkingLot parkingLot : parkingLots.values()){
             List<Gate> gates = parkingLot.getGates();
             for(Gate gate : gates){
                 if(gate.getId() == gateId){
                     return parkingLot;
                 }
             }
         }
         return null;
     }
}
