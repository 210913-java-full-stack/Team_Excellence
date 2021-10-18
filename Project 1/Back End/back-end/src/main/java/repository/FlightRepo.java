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
//    private static SessionFactory sessionFactory;
//    private static Session session;
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
        flight.setTakeOff(true); //We wouldn't need to set take off to false. Default is false.
        transaction.commit();//Has database update the take_off column to match the above change
    }

    public void updateAvailable(int flightId, boolean ticketsLeft) {
        Session session = HibernateUtil.getSession();
        Transaction transaction = session.beginTransaction();
        Flight flight = (Flight) session.get(Flight.class, flightId);
        //Update the available column
        if(ticketsLeft) {
            flight.setAvailable(true); //If there are tickets left, then the flight is still available.
        } else {
            flight.setAvailable(false);//If there aren't tickets left, then the flight is unavailable.
        }
        transaction.commit();//Has database update the available column to match the above change
    }

    public void deleteFlight(Flight flight) {
        Session session = HibernateUtil.getSession();
        Transaction transaction = session.beginTransaction();
        session.delete(flight);
        transaction.commit();//Has database update the available column to match the above change
    }

    //    public static List<Flight> getAllFlights() {
//        Transaction t = null;
//        Session session = null;
//        List<Flight> list = null;
//        try {
//            FlightRepo.setSession(FlightRepo.getSessionFactory().openSession());
//            session = FlightRepo.getSession();
//            t = session.beginTransaction();
////            CriteriaBuilder builder = session.getCriteriaBuilder();
////            CriteriaQuery<Flight> query = builder.createQuery(Flight.class);
////            Root<Flight> root = query.from(Flight.class);
////            query.select(root);
//            list = session.createQuery("FROM Flight WHERE take_off = false").getResultList();
//            t.commit();
//
//
//        }catch (Exception e){
//            e.printStackTrace();
//            if (t!=null) {
//                t.rollback();
//            }
//        }finally {
//            if (session!= null) {
//                session.close();
//            }
//        }
//        return list;
//    }
//
//    public static void saveNewFlight(Flight flight) {
//        Transaction t = null;
//        Session session = null;
//        try {
//            FlightRepo.setSession(FlightRepo.getSessionFactory().openSession());
//            session = FlightRepo.getSession();
//            t = session.beginTransaction();
//            System.out.println(t.getStatus());
//
//            session.save(flight);
//            t.commit();
//        } catch(Exception e){
//            e.printStackTrace();
//
//            t.rollback();
//        }finally {
//            session.close();
//        }
//
//    }
//
//    public static void deleteFlight(Flight flight) {
//        Transaction t = null;
//        Session session = null;
//        try {
//            FlightRepo.setSession(FlightRepo.getSessionFactory().openSession());
//            session = FlightRepo.getSession();
//            t = session.beginTransaction();
//            System.out.println(t.getStatus());
//
//            session.delete(flight);
//            t.commit();
//        } catch(Exception e){
//            e.printStackTrace();
//            t.rollback();
//        }finally {
//            session.close();
//        }
//    }
//
//    public static void updateFlight(Flight flight) {
//        Transaction t = null;
//        Session session = null;
//        try {
//            FlightRepo.setSession(FlightRepo.getSessionFactory().openSession());
//            session = FlightRepo.getSession();
//            t = session.beginTransaction();
//            System.out.println(t.getStatus());
//
//            session.update(flight);
//            t.commit();
//        } catch(Exception e){
//            e.printStackTrace();
//            t.rollback();
//        }finally {
//            session.close();
//        }
//    }
//    public static SessionFactory getSessionFactory() {
//        return sessionFactory;
//    }
//
//    public static void setSessionFactory(SessionFactory sessionFactory) {
//        AdminRepo.sessionFactory = sessionFactory;
//    }
//
//    public static Session getSession() {
//        return session;
//    }
//
//    public static void setSession(Session session) {
//        AdminRepo.session = session;
//    }


}