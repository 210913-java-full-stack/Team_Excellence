package services;

import model.Flight;
import repository.FlightRepo;

public class CancelFlight {
    Flight flight;
    FlightRepo flightRepo = new FlightRepo();

    //Allows admin to cancel a flight. Requires a flight ID.
    public void cancelFlight(int flightID){
        flight = flightRepo.getFlightById(flightID);
        flightRepo.deleteFlight(flight);
    }
}
