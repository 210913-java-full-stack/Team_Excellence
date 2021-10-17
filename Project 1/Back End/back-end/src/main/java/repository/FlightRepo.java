package repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import model.Flight;
import org.hibernate.Transaction;
import utils.HibernateUtil;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;


public class FlightRepo {
        /*
    Create a new session and transaction objects in each method because there is no guarantee that there will
    be an active session or transaction everytime the method is called.
     */

    public Flight getFlightById(int id) {
        Session session = HibernateUtil.getSession();
        return session.get(Flight.class, id);
    }

    public List<Flight> getAllFlights() {
        Session session = HibernateUtil.getSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Flight> query = builder.createQuery(Flight.class);
        Root<Flight> root = query.from(Flight.class);
        query.select(root);
        return session.createQuery(query).getResultList();
    }

    public void saveNewFlight(Flight flight) {
        Session session = HibernateUtil.getSession();
        Transaction transaction = session.beginTransaction();

        session.save(flight);
        transaction.commit();
    }

    public void updateTakeOff(int flightId) {
        Session session = HibernateUtil.getSession();
        Transaction transaction = session.beginTransaction();

        Flight flight = (Flight) session.get(Flight.class, flightId);
        //Update the take_off column
        flight.setTakeOff(true); //
        transaction.commit();//Has database update the take_off column to match the above change
    }

    public void updateAvailable(int flightId) {
        Session session = HibernateUtil.getSession();
        Transaction transaction = session.beginTransaction();

        Flight flight = (Flight) session.get(Flight.class, flightId);
        //Update the available column
        flight.setAvailable(true); //
        transaction.commit();//Has database update the available column to match the above change
    }

    public void deleteFlight(Flight flight) {
        Session session = HibernateUtil.getSession();
        session.delete(flight);
    }
}