package repository;

import org.hibernate.Session;
import model.Tickets;
import servlets.DependencyLoaderListener;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class TicketRepo {
    private static Session session = DependencyLoaderListener.getSession();

    public static Tickets getTicketById(int id){
        return session.get(Tickets.class, id);

    }

    public static List<Tickets> getAllTickets(){
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Tickets> query = builder.createQuery(Tickets.class);
        Root<Tickets> root = query.from(Tickets.class);
        query.select(root);
        return session.createQuery(query).getResultList();
    }

    public static void saveNewTicket(Tickets ticket){
        session.save(ticket);
    }

    public static void updateCheckInStatusUsingCustomerId(Tickets tickets){
        Query query = session.createSQLQuery("UPDATE tickets " +
                "SET checked_in = checkedIn WHERE customer_id = customerId");
        query.setParameter("checkedIn", tickets.getCheckedIn());
        query.setParameter("customerId", tickets.getCustomerId());
    }

    public static void updateCheckInStatusUsingTicketId(Tickets tickets) {
        Query query = session.createSQLQuery("UPDATE tickets " +
                "SET checked_in = checkedIn WHERE ticket_id = ticketId");
        query.setParameter("checkedIn", tickets.getCheckedIn());
        query.setParameter("ticketId", tickets.getTicketId());
    }

    public static void deleteTicket(Tickets ticket){
        session.delete(ticket);
    }

}
