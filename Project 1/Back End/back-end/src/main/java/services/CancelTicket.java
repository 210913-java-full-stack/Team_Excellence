package services;

import model.Customer;
import model.Flight;
import model.Ticket;
import repository.FlightRepo;
import repository.TicketRepo;

import java.util.List;

public class CancelTicket {
    //TODO: work on tonight

    /**
     * Allows the customer to cancel one or more tickets.
     * @param ticketId Requires the id of the ticket to be canceled
     * @param userId Requires the id of the customer that is currently logged in
     */
    public Ticket customerCancelTicket(int ticketId, int userId){
        System.out.println("I can get here");
        //Get the ticket from the database using the ticketId
        Ticket ticket = TicketRepo.getTicketById(ticketId);
        //Get the customer associated with that ticket
        Customer customer = ticket.getCustomer();
        int customerId = customer.getId();

        if(userId == customerId){
            //Get the flight info associated with that ticket
            Flight flight = ticket.getFlight();
            //Get the ticket list so that the ticket can be removed from it
            List<Ticket> ticketList = flight.getTicketListByFlightId();
            //Delete the ticket from the database
            TicketRepo.deleteTicket(ticket);
            //Remove the ticket from the ticket list
            ticketList.remove(ticket);
            return ticket;
        } else {
            return null;
        }
    }

    /**
     * Allows the admin to cancel the ticket(s) of any customer.
     * @param ticketId Requires the id of the ticket to be canceled
     */
    public void adminCancelTicket(int ticketId){
        //Get the ticket from the database using the ticketId
        Ticket ticket = TicketRepo.getTicketById(ticketId);
        //Get the flight info associated with that ticket
        Flight flight = ticket.getFlight();
        //Get the ticket list so that the ticket can be removed from it
        List<Ticket> ticketList = flight.getTicketListByFlightId();
        //Delete the ticket from the database
        TicketRepo.deleteTicket(ticket);
        //Remove the ticket from the ticket list
        ticketList.remove(ticket);
    }
}
