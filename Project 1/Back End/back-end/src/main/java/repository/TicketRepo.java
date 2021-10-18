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
    /*
    Create a new session and transaction objects in each method because there is no guarantee that there will
    be an active session or transaction everytime the method is called.
     */

    public static void init(){

    }

    public static Ticket getTicketById(int id){
        Session session = HibernateUtil.getSession();
        return session.get(Ticket.class, id);
    }

    public static List<Ticket> getAllTickets(){
        Session session = HibernateUtil.getSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Ticket> query = builder.createQuery(Ticket.class);
        Root<Ticket> root = query.from(Ticket.class);
        query.select(root);
        return session.createQuery(query).getResultList();
    }

    //This method inserts a new row into the ticket
    public static void saveNewTicket(Ticket ticket){
        Session session = HibernateUtil.getSession();
        Transaction transaction = session.beginTransaction();

        session.save(ticket);
        transaction.commit();
    }

    public static void updateCheckInStatusUsingCustomerId(int customerId){
        Session session = HibernateUtil.getSession();
        Transaction transaction = session.beginTransaction();
        //Retrieving specific ticket from database with the specified customer ID
        Ticket ticket = (Ticket) session.get(Ticket.class, customerId);
        //Update checked in column
        ticket.setCheckedIn(true); //Sets checkIn to true indicating that the customer has checked in.
        transaction.commit();//Has database update the checked in column to match the above change
    }

    public static void updateCheckInStatusUsingTicketId(int ticketId) {
        Session session = HibernateUtil.getSession();
        Transaction transaction = session.beginTransaction();
        //Retrieving specific ticket from database with the specified customer ID
        Ticket ticket = (Ticket) session.get(Ticket.class, ticketId);
        //Update checked in column
        ticket.setCheckedIn(true); //Changes value of the checkedIn object
        transaction.commit();//Has database update the checked in column to match the above change
    }

    public static void deleteTicket(Ticket ticket){
        Session session = HibernateUtil.getSession();
        Transaction transaction = session.beginTransaction();
        session.delete(ticket);
        transaction.commit();
    }

}