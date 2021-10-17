package services;

import model.Flight;
import repository.FlightRepo;

public class CancelFlight {
    private static Flight flight;

    //Allows admin to cancel a flight. Requires a flight ID.
    public static void cancelFlight(int flightID){
        flight = FlightRepo.getFlightById(flightID);
        FlightRepo.deleteFlight(flight);
    }
}
