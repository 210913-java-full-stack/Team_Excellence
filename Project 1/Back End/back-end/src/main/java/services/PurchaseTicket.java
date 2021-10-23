package services;

import model.Customer;
import model.Flight;
import model.Ticket;
import repository.*;

import java.util.List;

public class PurchaseTicket {

    public PurchaseTicket() {
    }

    public void ticketPackage(List<Ticket> ticketPackage, int flightId, int customerId){

    }

    //Allows the customer to purchase tickets.
    public void ticketEach(Ticket ticket, int flightId, int customerId){
        //Create the flight and customer objects and associate the flight to the ticket
        Flight flight = FlightRepo.getFlightById(flightId);
        Customer customer = CustomerRepo.getCustomerById(customerId);
        //Associate ticket with the flight and customer
        ticket.setFlight(flight);
        ticket.setCustomer(customer);
        //Save the new ticket to the database
        TicketRepo.saveNewTicket(ticket);
    }

}
