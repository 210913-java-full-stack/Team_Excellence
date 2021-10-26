package services;

import repository.TicketRepo;

public class CheckIn {

    public CheckIn() {
    }

    /**
     * Allows the customer to check in for their flight.
     * @param ticketId This method requires the id associated with the ticket
     */
    public void checkInForFlight(int ticketId){
        TicketRepo.updateCheckIn(ticketId,true);
    }
}
