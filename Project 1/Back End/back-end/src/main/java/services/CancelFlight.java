package services;

import model.Flight;
import repository.FlightRepo;

public class CancelFlight {
    Flight flight;

    public CancelFlight() {
    }

    //Allows admin to cancel a flight. Requires a flight ID.
    public void cancelFlight(int flightID){


        flight = FlightRepo.getFlightbyId(flightID);
        FlightRepo.deleteFlight(flight);

    }
}