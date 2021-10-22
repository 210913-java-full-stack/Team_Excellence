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
        FlightRepo.saveNewFlight(flight);
    }

    /**
     * Allows admin to cancel a flight using the flight ID.
     * @param flightId Requires the id associate with the selected flight
     */
    public void cancelFlight(int flightId){
        Flight flight;
        flight = FlightRepo.getFlightById(flightId);
        FlightRepo.deleteFlight(flight);

    }

    /**
     * This method allows the admin to update the entire flight
     * @param flight This method requires a flight object that contains the changes to be made to the flight
     *               as well as the current flight id
     */
    public void updateFlight(Flight flight){
        FlightRepo.updateFlight(flight);
    }

    /**
     * Closes ticket purchases and cancellations. Does this by changing the takeOff column in the flight table
     * to true.
     */
    public static void initiateTakeOff(int flightId){
        //We wouldn't need to set take off to false since it is false by default.
        FlightRepo.updateTakeOff(flightId, true);
    }
}
