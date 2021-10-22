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

    private static List<Flight> list;


    public static Flight getFlightById(int id) {
        Session session = HibernateUtil.getSession();
        return session.get(Flight.class, id);
    }


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



// delete later
    public static void saveNewFlight(Flight flight) {

        list.add(flight);
        session.flush();
    }

    public static void saveFlight(Flight flight){
        list.add(flight);
        Transaction tx = session.beginTransaction();
        session.save(flight);
        tx.commit();
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

    public static void deleteFlight(Flight flight) {
        int index = list.indexOf(flight);
        System.out.println(index);
        list.remove(index);
//        Transaction tx = session.beginTransaction();
//        session.delete(flight);
//        tx.commit();
        session.flush();
    }


    public static void updateFlight(Flight flight, Flight newflight) {
        int oldFlight = list.indexOf(flight);
        list.remove(oldFlight);
        list.add(newflight);
        session.flush();
    }

    public static List<Flight> getList() {
        return list;
    }

    public static void setList(List<Flight> list) {
        FlightRepo.list = list;
    }
}