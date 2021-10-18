
import model.Flight;
import org.hibernate.cfg.Configuration;
import repository.FlightRepo;


public class Driver {
    public static void main(String[] args){


        FlightRepo flightRepo = new FlightRepo();
        Flight flight = flightRepo.getFlightById(1);
        //flightRepo.deleteFlight(flight);


        
    }
}
