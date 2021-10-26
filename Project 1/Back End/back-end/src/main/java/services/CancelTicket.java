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
        //Get the ticket from the database using the ticketId
        Ticket ticket = TicketRepo.getTicketById(ticketId);
        //Get the customer associated with that ticket

        List<Ticket> list = ticket.getFlight().getTicketListByFlightId();
        list.remove(ticket);
        

        Customer customer = ticket.getCustomer();
        int customerId = customer.getId();

        if(userId == customerId){
            //Delete the ticket from the database
            TicketRepo.deleteTicket(ticket);
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

        //Delete the ticket from the database
        TicketRepo.deleteTicket(ticket);
    }
}
