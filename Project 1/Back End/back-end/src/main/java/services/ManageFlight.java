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
     * TODO: Create a method or class that checks if the pilot Id exists.
     */
    public void createFlight(Flight flight){
        //Save the new flight to the database
        FlightRepo.saveFlight(flight);
    }

    /**
     * Allows admin to cancel a flight using the flight ID.
     * @param flight Requires the id associate with the selected flight
     */
    public void cancelFlight(Flight flight){
        FlightRepo.getAllFlights();//Need to call this method for the FlightRepo.deleteFlight method to work
        FlightRepo.deleteFlight(FlightRepo.getFlightById(flight.getFlightId()));

    }

    /**
     * This method allows the admin to update the entire flight
     * @param newFlight This method requires a flight object that contains the changes to be made to the flight
     *               as well as the current flight id
     */
    public void updateFlight(Flight newFlight){
//        FlightRepo.getAllFlights();//Need to call this method for the FlightRepo.deleteFlight method to work
        Flight oldFlight = FlightRepo.getFlightById(newFlight.getFlightId());
        FlightRepo.updateFlight(oldFlight,newFlight);
    }
}
