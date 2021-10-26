package repository;

import model.Flight;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateUtil;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.Arrays;
import java.util.List;

public class FlightRepo {

    private static Session session = HibernateUtil.getSession();

    private static List<Flight> list;


    public static Flight getFlightById(int id) {
//        Transaction transaction = session.beginTransaction();
//        session.flush();
//        transaction.commit();
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
            Transaction transaction = session.beginTransaction();
            session.flush();
            transaction.commit();
        }
        return list;

    }

    public static void saveFlight(Flight flight){
        Transaction transaction = session.beginTransaction();
        session.save(flight);
        transaction.commit();
        list = getList();
        list.add(flight);
    }

    public static void deleteFlight(Flight flight) {
        Transaction transaction = session.beginTransaction();
        session.delete(flight);
        transaction.commit();
        list = getList();
        int index = list.lastIndexOf(flight);
        list.remove(index);
    }


    public static void updateFlight(Flight newFlight) {
        Transaction transaction = session.beginTransaction();

        list = getList();
        for (Flight flight : list){
            if(flight.getFlightId().equals(newFlight.getFlightId())){
                flight.setArriveLocation(newFlight.getArriveLocation());
                flight.setArriveDate(newFlight.getArriveDate());
                flight.setArriveTime(newFlight.getArriveTime());
               flight.setDepartLocation(newFlight.getDepartLocation());
               flight.setDepartDate(newFlight.getDepartDate());
                flight.setDepartTime(newFlight.getDepartTime());
                flight.setTakeOff(newFlight.getTakeOff());
                session.merge(flight);
            }
        }
        transaction.commit();
    }

    public static List<Flight> getList() {
        return list;
    }

    public static void setList(List<Flight> list) {
        FlightRepo.list = list;
    }
}