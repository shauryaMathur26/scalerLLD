package ParkingLot.controllers;

import ParkingLot.dtos.IssueTicketRequestDTO;
import ParkingLot.dtos.IssueTicketResponseDTO;
import ParkingLot.enums.ResponseStatus;
import ParkingLot.exceptions.GateNotFoundException;
import ParkingLot.models.Ticket;
import ParkingLot.services.TicketService;

public class TicketController {

    private TicketService ticketService; //tight coupling (EXCEPTION)

    public TicketController(TicketService ticketService){
        this.ticketService = ticketService; //Dependency Injection
    }

    public IssueTicketResponseDTO issueTicket(IssueTicketRequestDTO ticketRequestDTO){
        //Business logic to consume the data
        IssueTicketResponseDTO responseDTO = new IssueTicketResponseDTO();
        Ticket ticket;

        try{
            ticket = ticketService.issueTicket(ticketRequestDTO.getGateId(),ticketRequestDTO.getVehicleType(),ticketRequestDTO.getVehicleNumber(),ticketRequestDTO.getOwnerName());
        }catch(GateNotFoundException gnfe){
            responseDTO.setResponseStatus(ResponseStatus.FAILED);
            responseDTO.setFailureMessage("GateID is invalid");// Custom Message
            return responseDTO;
        }
        catch (Exception e){
            responseDTO.setResponseStatus(ResponseStatus.FAILED);
            responseDTO.setFailureMessage(e.getMessage());// Custom Message
            return responseDTO;
        }

        responseDTO.setTicket(ticket);
        responseDTO.setResponseStatus(ResponseStatus.SUCCESS);
        return responseDTO;
    }

}

//Client -> Controller -> Service -> Repository -> Uses Models to interact with DB(Mock DB)


