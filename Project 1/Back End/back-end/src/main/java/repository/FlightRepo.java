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

    private static List<Flight> flightList;

    //Gets a flight using the flight id
    public static Flight getFlightById(int id) {
        return session.get(Flight.class, id);
    }

    //Gets a list of all flights
    public static List<Flight> getAllFlights() {
        if (flightList == null) {
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Flight> query = builder.createQuery(Flight.class);
            Root<Flight> root = query.from(Flight.class);
            query.select(root);
            flightList = session.createQuery(query).getResultList();
        } else {
            //Updates the flight list
            Transaction transaction = session.beginTransaction();
            session.flush();
            transaction.commit();
        }
        return flightList;

    }

    //Adds a flight to the database and the flight list
    public static void saveFlight(Flight flight){
        Transaction transaction = session.beginTransaction();
        session.save(flight);
        transaction.commit();
        flightList = getFlightList();
        flightList.add(flight);
    }

    //Removes a flight from the database and the flight list
    public static void deleteFlight(Flight flight) {
        Transaction transaction = session.beginTransaction();
        session.delete(flight);
        transaction.commit();
        flightList = getFlightList();
        int index = flightList.lastIndexOf(flight);
        flightList.remove(index);
    }

    //Updates the flight list and the database
    public static void updateFlight(Flight newFlight) {
        Transaction transaction = session.beginTransaction();

        flightList = getFlightList();
        for (Flight flight : flightList){
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

    public static List<Flight> getFlightList() {
        return flightList;
    }

    public static void setFlightList(List<Flight> list) {
        FlightRepo.flightList = list;
    }
}