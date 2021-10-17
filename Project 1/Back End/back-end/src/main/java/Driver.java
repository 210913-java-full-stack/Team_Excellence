import model.*;
import repository.*;
import services.CancelFlight;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import servlets.DependencyLoaderListener;
import utils.HibernateUtil;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class Driver {
    public static void main(String[] args){

        FlightRepo flightRepo = new FlightRepo();
        Flight flight = flightRepo.getFlightById(1);
        //flightRepo.deleteFlight(flight);

        
    }
}
