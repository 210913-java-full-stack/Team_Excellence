package services;

import model.Flight;
import model.Ticket;
import repository.FlightRepo;
import repository.TicketRepo;

import java.util.List;

public class PassengerList {

    public PassengerList() {
    }

    /**
     * Allows admin to view all customers on a specific flight
     * @param flightId Requires the ID of the flight which the admin needs to see the passenger list.
     */
    public List<Ticket> passengersOnFlight(int flightId){
        //Get all tickets


        //Get the list of tickets associated with the flight ID
        Flight flight = FlightRepo.getFlightById(flightId);
        List<Ticket> ticketList = flight.getTicketListByFlightId();
        for (Ticket ticket:ticketList) {
            System.out.println(ticket.getPassengerFirstName());
        }


        return ticketList;
    }
}
