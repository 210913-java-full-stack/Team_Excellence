package services;

import model.Flight;
import repository.FlightRepo;
import repository.FlightRepoWHibernateUtil;

public class CancelFlight {
    Flight flight;

    //Allows admin to cancel a flight using the flight ID.
    public void cancelFlight(int flightID){
        flight = FlightRepoWHibernateUtil.getFlightById(flightID);
        FlightRepoWHibernateUtil.deleteFlight(flight);

    }
}