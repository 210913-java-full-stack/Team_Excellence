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
     * This method allows the admin to update parts of the flight row.
     * @param flight This method requires a flight object. The flight object must always contain the flight id
     */
    public void rescheduleFlight(Flight flight){
        /*
        just pull the flight from the database. check what information is missing from the data you send me.
        replace the missing data with the data from the database. delete flight and then create new flight.
         */
        //Get the flight from the database
        Flight currentFlight = FlightRepo.getFlightById(flight.getFlightId());
        //Check each parameter and if null, then that parameter remains the same and does not change
        if(flight.getDepartLocation() == null){
            flight.setDepartLocation(currentFlight.getDepartLocation());
        }
        if(flight.getArriveLocation() == null){
            flight.setArriveLocation(currentFlight.getArriveLocation());
        }
        if(flight.getDepartTime() == null){
            flight.setDepartTime(currentFlight.getDepartTime());
        }
        if(flight.getDepartDate() == null){
            flight.setDepartDate(currentFlight.getDepartDate());
        }
        if(flight.getArriveTime() == null){
            flight.setArriveTime(currentFlight.getArriveTime());
        }
        if(flight.getArriveDate() == null){
            flight.setArriveDate(currentFlight.getArriveDate());
        }
        if(flight.getTakeOff() == null){
            flight.setTakeOff(currentFlight.getTakeOff());
        }
        //Delete the flight currently in the database
        FlightRepo.deleteFlight(currentFlight);
        //Save the updated flight to the database
        FlightRepo.saveNewFlight(flight);
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
