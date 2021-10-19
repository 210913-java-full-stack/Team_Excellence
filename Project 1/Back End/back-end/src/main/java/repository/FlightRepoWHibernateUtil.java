package repository;

import model.Flight;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateUtil;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class FlightRepoWHibernateUtil {
            /*
    Create a new session and transaction objects in each method because there is no guarantee that there will
    be an active session or transaction everytime the method is called.
     */

    public static Flight getFlightById(int id) {
        Session session = HibernateUtil.getSession();
        return session.get(Flight.class, id);
    }

    public static List<Flight> getAllFlights() {
        Session session = HibernateUtil.getSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Flight> query = builder.createQuery(Flight.class);
        Root<Flight> root = query.from(Flight.class);
        query.select(root);
        return session.createQuery(query).getResultList();
    }

    public static void saveNewFlight(Flight flight) {
        Session session = HibernateUtil.getSession();
        Transaction transaction = session.beginTransaction();

        session.save(flight);
        transaction.commit();
    }

    public static void updateTakeOff(int flightId) {
        Session session = HibernateUtil.getSession();
        Transaction transaction = session.beginTransaction();

        Flight flight = (Flight) session.get(Flight.class, flightId);
        //Update the take_off column
        flight.setTakeOff(true); //We wouldn't need to set take off to false. Default is false.
        transaction.commit();//Has database update the take_off column to match the above change
    }

    public static void updateAvailable(int flightId, boolean ticketsLeft) {
        Session session = HibernateUtil.getSession();
        Transaction transaction = session.beginTransaction();
        Flight flight = (Flight) session.get(Flight.class, flightId);
        //Update the available column
        if (ticketsLeft) {
            flight.setAvailable(true); //If there are tickets left, then the flight is still available.
        } else {
            flight.setAvailable(false);//If there aren't tickets left, then the flight is unavailable.
        }
        transaction.commit();//Has database update the available column to match the above change
    }


    public static void deleteFlight(Flight flight) {
        Session session = HibernateUtil.getSession();
        Transaction transaction = session.beginTransaction();
        session.delete(flight);
        transaction.commit();//Has database update the available column to match the above change
    }

    public static void updateFlight(Flight flight) {
        Session session = HibernateUtil.getSession();
        Transaction transaction = session.beginTransaction();
        session.update(flight);
    }
}
