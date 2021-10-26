package services;

import model.Flight;
import model.Ticket;
import repository.FlightRepo;

import java.util.List;

public class PassengerList {

    public PassengerList() {
    }

    /**
     * Allows admin to view all customers on a specific flight
     * @param flightId Requires the ID of the flight which the admin needs to see the passenger list.
     */
    public List<Ticket> passengersOnFlight(int flightId){
        //Get the list of tickets associated with the flight ID
        Flight flight = FlightRepo.getFlightById(flightId);
        return flight.getTicketListByFlightId();
    }
}
