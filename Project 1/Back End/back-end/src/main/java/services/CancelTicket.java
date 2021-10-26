package services;

import model.Customer;
import model.Ticket;
import repository.TicketRepo;

import java.util.List;

public class CancelTicket {
    /**
     * Allows the customer to cancel a ticket. Customers can only cancel tickets tha they purchased
     * @param ticketId Requires the id of the ticket to be canceled
     * @param userId Requires the id of the customer that is currently logged in
     */
    public Ticket customerCancelTicket(int ticketId, int userId){
        //Get the ticket from the database using the ticketId
        Ticket ticket = TicketRepo.getTicketById(ticketId);
        //Get the customer associated with that ticket

        Customer customer = ticket.getCustomer();
        int customerId = customer.getId();

        //Prevents customers from deleting tickets that they did not purchase
        if(userId == customerId){
            //Delete the ticket from the database and from the ticket list
            List<Ticket> list = ticket.getFlight().getTicketListByFlightId();
            list.remove(ticket);
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
