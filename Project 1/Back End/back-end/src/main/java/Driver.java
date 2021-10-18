
import model.Flight;
import org.hibernate.cfg.Configuration;
import repository.FlightRepo;

import java.util.ArrayList;
import java.util.List;


public class Driver {
    public static void main(String[] args){


        FlightRepo flightRepo = new FlightRepo();
        List<Flight> flightList = new ArrayList<>();
        flightList = flightRepo.getAllFlights();
        //Flight flight = flightRepo.getFlightById(1);
        //flightRepo.deleteFlight(flight);


        
    }
}
