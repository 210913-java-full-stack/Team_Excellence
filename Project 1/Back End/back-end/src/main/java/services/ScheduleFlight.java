package services;

import model.Flight;
import repository.FlightRepo;

/**
 * This class contains all methods for managing flights including scheduling a flight, updating a flight,
 */
public class ScheduleFlight {

    //Allows the admin to create new flights
    public void createNewFlight(Flight flight){
        //Associate flight row with a pilot


        //Check if flight id already exists
        int flightId = flight.getFlightId();
        Flight flightDatabase = FlightRepo.getFlightById(flightId);

        //If the flight id exists in the database, update that row else insert a new row
        if(flightDatabase == null){
            FlightRepo.saveNewFlight(flight);
        } else{
            FlightRepo.updateFlight(flight);
        }

        /*
        TODO: first check if the given pilot id matches a pilot in the pilot table
        TODO: save that pilot to flight.setPilot and then
         */
    }


}
