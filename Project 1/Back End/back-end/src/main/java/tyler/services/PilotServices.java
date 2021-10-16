package tyler.services;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import model.Pilots;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.xml.bind.annotation.adapters.HexBinaryAdapter;
import java.sql.SQLException;
import java.util.List;



public class PilotServices {
    private static SessionFactory sessionFactory;
    private static Session session;

    public static Pilots getPilotById(int id) {
        return session.get(Pilots.class, id);
    }

    public static List<Pilots> getAllPilots() {
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Pilots> query = builder.createQuery(Pilots.class);
        Root<Pilots> root = query.from(Pilots.class);
        query.select(root);
        return session.createQuery(query).getResultList();
    }

    public static void saveNewPilot(Pilots pilot) {
        session.save(pilot);
    }

    public static void deletePilot(Pilots pilot) {
        session.delete(pilot);
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static void setSessionFactory(SessionFactory sessionFactory) {
        PilotServices.sessionFactory = sessionFactory;
    }

    public static Session getSession() {
        return session;
    }

    public static void setSession(Session session) {
        PilotServices.session = session;
    }
}
