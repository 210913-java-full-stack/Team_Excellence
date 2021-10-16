package tyler.services;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import model.Flight;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.xml.bind.annotation.adapters.HexBinaryAdapter;
import java.sql.SQLException;
import java.util.List;


public class FlightServices {
    private static SessionFactory sessionFactory;
    private static Session session;



    public static Flight getFlightbyId(int id) {
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

    public static void deleteFlight(Flight flight) {
        session.delete(flight);
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static void setSessionFactory(SessionFactory sessionFactory) {
        FlightServices.sessionFactory = sessionFactory;
    }

    public static Session getSession() {
        return session;
    }

    public static void setSession(Session session) {
        FlightServices.session = session;
    }
}
