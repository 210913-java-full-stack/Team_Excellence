package repository;

import model.Flight;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateUtil;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class FlightRepo {
    private static Session session = HibernateUtil.getSession();
    private static Transaction transaction;

    public static Flight getFlightById(int id) {
        return session.get(Flight.class, id);
    }

    public static List<Flight> getAllFlights() {
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Flight> query = builder.createQuery(Flight.class);
        Root<Flight> root = query.from(Flight.class);
        query.select(root).where(builder.equal(root.get("takeOff"), false));
        return session.createQuery(query).getResultList();
    }

    public static void saveNewFlight(Flight flight) {

        transaction = session.beginTransaction();

        session.save(flight);
        transaction.commit();
    }

    public static void updateTakeOff(int flightId, boolean takeOff) {
        transaction = session.beginTransaction();
        System.out.println("Debug: I can get here 2");
        Flight flight = session.get(Flight.class, flightId);
        //Update the take_off column
        flight.setTakeOff(takeOff); //We wouldn't need to set take off to false. Default is false.
        transaction.commit();//Has database update the take_off column to match the above change
        System.out.println("Debug: I can get here 5");
    }


    public static void deleteFlight(Flight flight) {
        transaction = session.beginTransaction();
        session.delete(flight);
        transaction.commit();//Has database update the available column to match the above change
    }

    public static void updateFlight(Flight flight) {
        transaction = session.beginTransaction();
        session.update(flight);
        transaction.commit();//Has database update the available column to match the above change

    }
}