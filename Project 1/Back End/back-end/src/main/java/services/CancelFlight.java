package services;

import model.Flight;
import repository.FlightRepo;

public class CancelFlight {

    //Allows admin to cancel a flight. Requires a flight ID.
    public void cancelFlight(int flightId){
        Flight flight = FlightRepo.getFlightById(flightId);
        FlightRepo.deleteFlight(flight);
    }
}
