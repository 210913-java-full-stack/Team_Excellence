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
     * This method allows the admin to update the entire flight using the flight ID
     * @param flightId
     */
    public void updateFlight(int flightId){
        //TODO: Finish this method
    }

    /**
     * This method allows the admin to update parts of the flight row
     * @param flight This method requires a flight object
     */
    public void updateFlightColumns(Flight flight){
        /*
        just pull the flight from the database. check what information is missing from the data you send me.
        replace the missing data with the data from the database. delete flight and then create new flight.
         */
    }

    /**
     * Closes ticket purchases and cancellations. Does this by changing the takeOff column in the flight table
     * to true.
     */
    public static void initiateTakeOff(){

    }
}
