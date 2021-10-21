package services;

import model.Flight;
import model.Pilot;
import repository.FlightRepo;
import repository.FlightRepoWHibernateUtil;
import repository.PilotRepo;

/**
 * This class contains all methods for managing flights including scheduling a flight, updating a flight,
 */
public class ScheduleFlight {

    //Allows the admin to create new flights
    public void createFlight(Flight flight, int pilotId){
        //Create the pilot object
        Pilot pilot = PilotRepo.getPilotById(pilotId);

        //Associate flight row with a pilot
        flight.setPilot(pilot);
        //Save the new flight to the database
        FlightRepoWHibernateUtil.saveNewFlight(flight);
    }
}
