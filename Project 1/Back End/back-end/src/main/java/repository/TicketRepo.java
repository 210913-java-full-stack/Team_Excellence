package repository;

import org.hibernate.Session;
import model.Ticket;
import org.hibernate.Transaction;
import utils.HibernateUtil;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class TicketRepo {
    private static Session session = HibernateUtil.getSession();
    private static Transaction transaction = session.beginTransaction();

    public static void init(){

    }

    public static Ticket getTicketById(int id){
        return session.get(Ticket.class, id);
    }

    public static List<Ticket> getAllTickets(){
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Ticket> query = builder.createQuery(Ticket.class);
        Root<Ticket> root = query.from(Ticket.class);
        query.select(root);
        return session.createQuery(query).getResultList();
    }

    //This method inserts a new row into the ticket
    public static void saveNewTicket(Ticket ticket){
        session.save(ticket);
        transaction.commit();
    }

    public static void updateCheckInStatusUsingCustomerId(int customerId){
        //Retrieving specific ticket from database with the specified customer ID
        Ticket ticket = (Ticket) session.get(Ticket.class, customerId);
        //Update checked in column
        ticket.setCheckedIn(true); //Changes value of the checkedIn object
        transaction.commit();//Has database update the checked in column to match the above change
    }

    public static void updateCheckInStatusUsingTicketId(int ticketId) {
        //Retrieving specific ticket from database with the specified customer ID
        Ticket ticket = (Ticket) session.get(Ticket.class, ticketId);
        //Update checked in column
        ticket.setCheckedIn(true); //Changes value of the checkedIn object
        transaction.commit();//Has database update the checked in column to match the above change
    }

    public static void deleteTicket(Ticket ticket){
        session.delete(ticket);
        transaction.commit();
    }

//    public static SessionFactory getSessionFactory() {
//        return sessionFactory;
//    }
//
//    public static void setSessionFactory(SessionFactory sessionFactory) {
//        TicketRepo.sessionFactory = sessionFactory;
//    }
//
//    public static Session getSession() {
//        return session;
//    }
//
//    public static void setSession(Session session) {
//        TicketRepo.session = session;
//    }
}