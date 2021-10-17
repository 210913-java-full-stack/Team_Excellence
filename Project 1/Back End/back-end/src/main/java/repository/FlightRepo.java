package repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import model.Flight;
import utils.HibernateUtil;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;


public class FlightRepo {
    private static HibernateUtil hibernateUtil = new HibernateUtil();
    private static Session session = hibernateUtil.getSession();

    public static Flight getFlightById(int id) {
        return session.get(Flight.class, id);
    }

    public static List<Flight> getAllFlights() {
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Flight> query = builder.createQuery(Flight.class);
        Root<Flight> root = query.from(Flight.class);
        query.select(root);
        return session.createQuery(query).getResultList();
    }

    public static void saveNewFlight(Flight flight) {
        session.save(flight);
    }

    public static void updateTakeOff( Flight flight) {
        Query query = session.createSQLQuery("UPDATE flights " +
                "SET take_off = takeOff WHERE flight_id = flightId");
        query.setParameter("takeOff", flight.getTakeOff());
        query.setParameter("flightId", flight.getFlightId());
    }

    public static void updateAvailable(Flight flight) {
        Query query = session.createSQLQuery("UPDATE flights " +
                "SET available = available WHERE flight_id = flightId");
        query.setParameter("available", flight.getTakeOff());
        query.setParameter("flightId", flight.getFlightId());
    }

    public static void deleteFlight(Flight flight) {
        session.delete(flight);
    }
}