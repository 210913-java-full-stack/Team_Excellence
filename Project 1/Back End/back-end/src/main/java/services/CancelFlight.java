package services;

import model.Flight;
import repository.FlightRepo;

public class CancelFlight {
    Flight flight;

    //Allows admin to cancel a flight. Requires a flight ID.
    public void cancelFlight(int flightID){
        flight = FlightRepo.getFlightById(flightID);
        FlightRepo.deleteFlight(flight);

    }
}