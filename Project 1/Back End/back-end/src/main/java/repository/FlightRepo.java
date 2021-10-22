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
<<<<<<< HEAD
    private static Session session = HibernateUtil.getSession();
    private static Transaction transaction;
    private static List<Flight> list;
=======
>>>>>>> 287c91782fe3208bec0b5b7a3b5fda60604353a2

    public static Flight getFlightById(int id) {
        Session session = HibernateUtil.getSession();
        return session.get(Flight.class, id);
    }

<<<<<<< HEAD
    public static List<Flight> getAllFlights() {
        if (list == null) {
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Flight> query = builder.createQuery(Flight.class);
            Root<Flight> root = query.from(Flight.class);
            query.select(root);
            list = session.createQuery(query).getResultList();
        } else {
         session.flush();
        }
        return list;

    }

    public static List<Flight> getList() {
        return list;
    }

    public static void setList(List<Flight> list) {
        FlightRepo.list = list;
    }
=======
    public static List<Flight> getAllAvailableFlights() {
        Session session = HibernateUtil.getSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Flight> query = builder.createQuery(Flight.class);
        Root<Flight> root = query.from(Flight.class);
        query.select(root).where(builder.equal(root.get("takeOff"), false));
        return session.createQuery(query).getResultList();
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
>>>>>>> 287c91782fe3208bec0b5b7a3b5fda60604353a2

    public static void saveNewFlight(Flight flight) {

        list.add(flight);
        session.flush();
    }


    public static void updateTakeOff(int flightId, boolean takeOff) {
        Session session = HibernateUtil.getSession();
        Transaction transaction = session.beginTransaction();
        System.out.println("Debug: I can get here 2");
        Flight flight = session.get(Flight.class, flightId);
        //Update the take_off column
        flight.setTakeOff(takeOff);
        transaction.commit();//Has database update the take_off column to match the above change
        System.out.println("Debug: I can get here 5");
    }

    public static void updateFlight(Flight flight) {
        Session session = HibernateUtil.getSession();
        Transaction transaction = session.beginTransaction();
        session.merge(flight);
        transaction.commit();
    }

    public static void deleteFlight(Flight flight) {
<<<<<<< HEAD
        list.remove(flight);
        session.flush();
    }

    public static void updateFlight(Flight flight) {
        list.

    }
=======
        Session session = HibernateUtil.getSession();
        Transaction transaction = session.beginTransaction();
        session.delete(flight);
        transaction.commit();//Has database update the available column to match the above change
    }
>>>>>>> 287c91782fe3208bec0b5b7a3b5fda60604353a2
}