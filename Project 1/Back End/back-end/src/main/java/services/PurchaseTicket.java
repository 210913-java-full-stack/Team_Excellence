package services;

import model.Customer;
import model.Flight;
import model.Ticket;
import repository.*;

import java.util.ArrayList;
import java.util.List;

public class PurchaseTicket {

    public PurchaseTicket() {
    }

    /**
     * This method allows the customer to purchase tickets.
     * @param customerId Requires the id of the customer purchasing the ticket
     * @param ticket Requires the passenger's first name, last name, and age.
     * @param flightId Requires the flight id for the desired flight
     */
    public void newTicket(Ticket ticket, int flightId, int customerId){
        //Create the flight and customer objects and associate the flight to the ticket
        Flight currentFlight = FlightRepo.getFlightById(flightId);
        List<Ticket> ticketList = currentFlight.getTicketListByFlightId();
        if(ticketList == null){
            currentFlight.setTicketListByFlightId(ticketList = new ArrayList<>());
        }
        Customer customer = CustomerRepo.getCustomerById(customerId);
        //Associate ticket with the flight and customer
        ticket.setFlight(currentFlight);
        ticket.setCustomer(customer);
        ticket.setCheckedIn(false);
        //Save the new ticket to the database
        TicketRepo.saveNewTicket(ticket);
        ticketList.add(ticket);
        System.out.println(ticketList.get(ticketList.indexOf(ticket)).getTicketId());
    }

}
