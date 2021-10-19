package repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import model.Flight;
import org.hibernate.Transaction;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;


public class FlightRepo {
    private static SessionFactory sessionFactory;
    private static Session session;



    public static Flight getFlightbyId(int id) {

        Flight flight = null;
        Transaction t = null;
        Session session = null;
        try{
            FlightRepo.setSession(FlightRepo.getSessionFactory().openSession());
            session = FlightRepo.getSession();
            t = session.beginTransaction();
            flight = session.get(Flight.class, id);
            t.commit();
        }catch (Exception e){
            e.printStackTrace();
            if (t!=null) {
                t.rollback();
            }
        } finally {
            if (session!= null) {
                session.close();
            }
        }


        return flight;
    }

    public static List<Flight> getAllFlights() {
        Transaction t = null;
        Session session = null;
        List<Flight> list = null;
        try {
            FlightRepo.setSession(FlightRepo.getSessionFactory().openSession());
            session = FlightRepo.getSession();
            t = session.beginTransaction();
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Flight> query = builder.createQuery(Flight.class);
            Root<Flight> root = query.from(Flight.class);
            query.select(root).where(builder.equal(root.get("takeOff"), false));
            list = session.createQuery(query).getResultList();
            t.commit();


        }catch (Exception e){
            e.printStackTrace();
            if (t!=null) {
                t.rollback();
            }
        }finally {
            if (session!= null) {
                session.close();
            }
        }
        return list;
    }

    public static void saveNewFlight(Flight flight) {
        Transaction t = null;
        Session session = null;
        try {
            FlightRepo.setSession(FlightRepo.getSessionFactory().openSession());
            session = FlightRepo.getSession();
            t = session.beginTransaction();


            session.save(flight);
            t.commit();
        } catch(Exception e){
            e.printStackTrace();

            t.rollback();
        }finally {
            session.close();
        }

    }

    public static void deleteFlight(Flight flight) {
        Transaction t = null;
        Session session = null;
        try {
            FlightRepo.setSession(FlightRepo.getSessionFactory().openSession());
            session = FlightRepo.getSession();
            t = session.beginTransaction();
            System.out.println(t.getStatus());

            session.delete(flight);
            t.commit();
        } catch(Exception e){
            e.printStackTrace();
            t.rollback();
        }finally {
            session.close();
        }
    }

    public static void updateFlight(Flight flight) {
        Transaction t = null;
        Session session = null;
        try {
            FlightRepo.setSession(FlightRepo.getSessionFactory().openSession());
            session = FlightRepo.getSession();
            t = session.beginTransaction();
            System.out.println(t.getStatus());

            session.update(flight);
            t.commit();
        } catch(Exception e){
            e.printStackTrace();
            t.rollback();
        }finally {
            session.close();
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static void setSessionFactory(SessionFactory sessionFactory) {
        FlightRepo.sessionFactory = sessionFactory;
    }

    public static Session getSession() {
        return session;
    }

    public static void setSession(Session session) {
        FlightRepo.session = session;
    }
}
