package repository;

import model.Flight;
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
    private static Transaction transaction;

    public static Ticket getTicketById(int id){
        return session.get(Ticket.class, id);
    }

    public static List<Ticket> getAllTickets(int flightId){
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Ticket> query = builder.createQuery(Ticket.class);
        Root<Ticket> root = query.from(Ticket.class);
        query.select(root);
        return session.createQuery(query).getResultList();
    }

    //This method inserts a new row into the ticket
    public static void saveNewTicket(Ticket ticket){
        transaction = session.beginTransaction();

        session.save(ticket);

        transaction.commit();//Has database update the available column to match the above change
    }

    //This method updates the ticket table
    public static void updateCheckIn(int ticketId, boolean checkIn){
        transaction = session.beginTransaction();

        Ticket ticket = session.get(Ticket.class, ticketId);
        //Update the checkIn column
        ticket.setCheckedIn(checkIn); //Updates just the ticket column
        transaction.commit();//Has database update the take_off column to match the above change
    }

    public static void deleteTicket(Ticket ticket){
        transaction = session.beginTransaction();

        session.delete(ticket);

        transaction.commit();
    }
}