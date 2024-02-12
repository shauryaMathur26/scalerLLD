package ParkingLot.strategies;

import ParkingLot.enums.SlotAssignmentStrategyType;
import ParkingLot.repositories.ParkingLotRepository;

public class SlotAssignmentStrategyFactory {

    public static SlotAssignmentStrategy getSlotAssignmentStrategyByType(SlotAssignmentStrategyType slotAssignmentStrategyType,ParkingLotRepository parkingLotRepository){
        if(slotAssignmentStrategyType.equals(SlotAssignmentStrategyType.RANDOM)){
            return new RandomSlotAssignmentStrategy(parkingLotRepository);
        }
        return null;
    }
}
