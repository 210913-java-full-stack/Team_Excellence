import model.Flight;
import org.hibernate.cfg.Configuration;
import repository.FlightRepo;
import servlets.DependencyLoaderListener;

public class Driver {
    public static void main(String[] args){

        Configuration config = new Configuration();
        config.addAnnotatedClass(Flight.class);
        FlightRepo.setSessionFactory(config.buildSessionFactory());
        FlightRepo.setSession(FlightRepo.getSessionFactory().openSession());

        FlightRepo.getAllFlights();

        
    }
}
