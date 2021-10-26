package services;

import model.Flight;
import repository.FlightRepo;

/**
 * This class contains all methods for managing flights including scheduling a flight, updating a flight,
 */
public class ManageFlight {

    /**
     * Allows the admin to create new flights
     * @param flight This method requires the flight information (minus the flight id) from the UI
     */
    public void createFlight(Flight flight){
        //Save the new flight to the database
        FlightRepo.setFlightList(FlightRepo.getAllFlights());
        FlightRepo.saveFlight(flight);
    }

    /**
     * Allows admin to cancel a flight using the flight ID. Need to call getAllFlights at least once before
     * using the cancel flight method
     * @param flight Requires the id associate with the selected flight
     */
    public void cancelFlight(Flight flight){
        FlightRepo.setFlightList(FlightRepo.getAllFlights());
        FlightRepo.deleteFlight(FlightRepo.getFlightById(flight.getFlightId()));
    }

    /**
     * This method allows the admin to update a specific flight
     * @param newFlight This method requires the updates to the current flight
     */
    public void updateFlight(Flight newFlight){
        FlightRepo.setFlightList(FlightRepo.getAllFlights());
        FlightRepo.updateFlight(newFlight);
    }
}
