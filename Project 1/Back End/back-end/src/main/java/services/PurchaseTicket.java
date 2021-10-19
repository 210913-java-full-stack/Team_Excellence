package services;

import model.Flight;
import repository.FlightRepo;

public class PurchaseTicket {
    //TODO: Work on tonight
    //Allows the customer to purchase tickets.
    public static void purchaseTicket(Flight flight){
        //TODO: Write code after implementing Hibernate

        FlightRepo.updateFlight(flight);
    }
}
