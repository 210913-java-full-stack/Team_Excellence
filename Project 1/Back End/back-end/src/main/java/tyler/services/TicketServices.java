package tyler.services;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import model.Tickets;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.xml.bind.annotation.adapters.HexBinaryAdapter;
import java.sql.SQLException;
import java.util.List;

public class TicketServices {
    private static SessionFactory sessionFactory;
    private static Session session;

    public static void init(){

    }

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

    public static void deleteTicket(Tickets ticket){
        session.delete(ticket);
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static void setSessionFactory(SessionFactory sessionFactory) {
        TicketServices.sessionFactory = sessionFactory;
    }

    public static Session getSession() {
        return session;
    }

    public static void setSession(Session session) {
        TicketServices.session = session;
    }
}
