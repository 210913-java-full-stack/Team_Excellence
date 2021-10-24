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

    static int n = 0;

    public static void saveFlight(Flight flight){
        Transaction transaction = session.beginTransaction();
        session.save(flight);
        transaction.commit();
        if(list == null){
            getAllFlights();
        } else{
            list.add(flight);
        }
        n++;
    }

    public static void deleteFlight(Flight flight) {
        Transaction transaction = session.beginTransaction();
        session.delete(flight);
        transaction.commit();
        int index = list.lastIndexOf(flight);
        list.remove(index);
        session.flush();
    }


    public static void updateFlight(Flight newFlight) {
        Transaction transaction = session.beginTransaction();
        session.merge(newFlight);



            for (Flight flight : list){
                if(flight.getFlightId().equals(newFlight.getFlightId())){
                    flight.setArriveLocation(newFlight.getArriveLocation());
                    flight.setArriveDate(newFlight.getArriveDate());
                    flight.setArriveTime(newFlight.getArriveTime());
                   flight.setDepartLocation(newFlight.getDepartLocation());
                   flight.setDepartDate(newFlight.getDepartDate());
                    flight.setDepartTime(newFlight.getDepartTime());
                    flight.setTakeOff(newFlight.getTakeOff());
                }

        }
        transaction.commit();
        session.flush();

    }

    public static List<Flight> getList() {
        return list;
    }

    public static void setList(List<Flight> list) {
        FlightRepo.list = list;
    }
}