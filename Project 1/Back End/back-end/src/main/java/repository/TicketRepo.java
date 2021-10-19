package repository;

import model.Flight;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import model.Ticket;
import org.hibernate.Transaction;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class TicketRepo {
    private static SessionFactory sessionFactory;
    private static Session session;

    public static void init(){

    }

    public static Ticket getTicketById(int id){
        Ticket ticket = null;
        Transaction t = null;
        Session session = null;
        try{
            TicketRepo.setSession(TicketRepo.getSessionFactory().openSession());
            session = TicketRepo.getSession();
            t = session.beginTransaction();
            ticket = session.get(Ticket.class, id);
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


        return ticket;

    }

    public static List<Ticket> getAllTickets(){
        Transaction t = null;
        Session session = null;
        List<Ticket> list = null;

        try{
            TicketRepo.setSession(TicketRepo.getSessionFactory().openSession());
            session = TicketRepo.getSession();
            t = session.beginTransaction();
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Ticket> query = builder.createQuery(Ticket.class);
            Root<Ticket> root = query.from(Ticket.class);
            query.select(root);
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

    public static void saveNewTicket(Ticket ticket){
        Transaction t = null;
        Session session = null;
        try{
            TicketRepo.setSession(TicketRepo.getSessionFactory().openSession());
            session = TicketRepo.getSession();
            t = session.beginTransaction();
        session.save(ticket);
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
    }



    public static void updateTicket(Ticket ticket) {
        Transaction t = null;
        Session session = null;
        try{
            TicketRepo.setSession(TicketRepo.getSessionFactory().openSession());
            session = TicketRepo.getSession();
            t = session.beginTransaction();
            session.update(ticket);
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
    }

    public static void deleteTicket(Ticket ticket){
        Transaction t = null;
        Session session = null;
        try{
            TicketRepo.setSession(TicketRepo.getSessionFactory().openSession());
            session = TicketRepo.getSession();
            t = session.beginTransaction();
            session.delete(ticket);
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

    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static void setSessionFactory(SessionFactory sessionFactory) {
        TicketRepo.sessionFactory = sessionFactory;
    }

    public static Session getSession() {
        return session;
    }

    public static void setSession(Session session) {
        TicketRepo.session = session;
    }
}
