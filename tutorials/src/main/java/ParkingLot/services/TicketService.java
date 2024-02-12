package ParkingLot.services;

import ParkingLot.enums.ParkingSlotStatus;
import ParkingLot.enums.SlotAssignmentStrategyType;
import ParkingLot.enums.VehicleType;
import ParkingLot.exceptions.GateNotFoundException;
import ParkingLot.models.Gate;
import ParkingLot.models.ParkingSlot;
import ParkingLot.models.Ticket;
import ParkingLot.models.Vehicle;
import ParkingLot.repositories.GateRepository;
import ParkingLot.repositories.ParkingLotRepository;
import ParkingLot.repositories.TicketRepository;
import ParkingLot.repositories.VehicleRepository;
import ParkingLot.strategies.SlotAssignmentStrategyFactory;

import java.util.Date;
import java.util.Optional;

public class TicketService {

    private GateRepository gateRepository;
    private VehicleRepository vehicleRepository;
    private ParkingLotRepository parkingLotRepository;
    private TicketRepository ticketRepository;

    public TicketService(GateRepository gateRepository,VehicleRepository vehicleRepository,ParkingLotRepository parkingLotRepository,TicketRepository ticketRepository){
        this.gateRepository = gateRepository; //DI
        this.vehicleRepository = vehicleRepository;
        this.parkingLotRepository = parkingLotRepository;
        this.ticketRepository = ticketRepository;
    }
    public Ticket issueTicket(Long gateId, VehicleType vehicleType,String vehicleNumber, String ownerName) throws GateNotFoundException{
        //1. Create the ticket object
        //2. Assign the slot to the vehicle(if any)
        //3 Return the Ticket

        Ticket ticket = new Ticket();
        ticket.setEntryTime(new Date());

        //Which will accept a gateID and give me the details of the gate from DB
        Optional<Gate> gateOptional = gateRepository.getGateById(gateId);
        // gate.getGateNumber() NPE
        //Old way to avoid NPE
//        if(gate != null){
//            ticket.setGateGeneratedAt(gate);
//            ticket.setGeneratedBy(gate.getGateOperator());
//        }
        //OPTIONALS to avoid NPE
        if(!gateOptional.isPresent()){
            throw new GateNotFoundException();
        }
        Gate gate = gateOptional.get();
        ticket.setGateGeneratedAt(gate);
        ticket.setGeneratedBy(gate.getGateOperator());
        Vehicle savedVehicle;
        Optional<Vehicle> optionalVehicle = vehicleRepository.findVehicleByNumber(vehicleNumber);
        if(!optionalVehicle.isPresent()){
            Vehicle vehicle = new Vehicle();
            vehicle.setVehicleType(vehicleType);
            vehicle.setNumber(vehicleNumber);
            vehicle.setOwnerName(ownerName);
            savedVehicle = vehicleRepository.insertVehicle(vehicle);
        }else{
            savedVehicle = optionalVehicle.get();
        }
        ticket.setVehicle(savedVehicle);

        // Find and assign the slot
        SlotAssignmentStrategyType slotAssignmentStrategyType = parkingLotRepository.getParkingLotByGateId(gateId).getSlotAssignmentStrategyType();
        ParkingSlot parkingSlot = SlotAssignmentStrategyFactory.getSlotAssignmentStrategyByType(slotAssignmentStrategyType,parkingLotRepository).getSlot(vehicleType,gate);
        parkingSlot.setParkingSlotStatus(ParkingSlotStatus.OCCUPIED);
        ticket.setParkingSlot(parkingSlot);
        //persist the ticket in DB
        Ticket savedTicket = ticketRepository.saveTicket(ticket); // comes with the ID from DB
        savedTicket.setTicketNumber("TICKET - " + savedTicket.getId());
        return savedTicket;
    }
}

//StudentJoinClassRequestDTO{authToken, studentId,classId}
// authenticationService(authToken)
// joinClassService(studentId,classId)
