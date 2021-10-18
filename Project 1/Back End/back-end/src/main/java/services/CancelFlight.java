package services;

import model.Flight;
import repository.FlightRepo;
import repository.FlightRepoBL;

public class CancelFlight {
    Flight flight;

    //Allows admin to cancel a flight. Requires a flight ID.
    public void cancelFlight(int flightID){
        flight = FlightRepoBL.getFlightById(flightID);
        FlightRepo.deleteFlight(flight);
    }
}
