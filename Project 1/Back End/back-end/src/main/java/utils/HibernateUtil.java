package utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import repository.FlightRepo;

public class HibernateUtil {
    private SessionFactory sessionFactory;
    private Session session;

    public HibernateUtil() {
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public Session getSession() {
        if(session == null){
            session = sessionFactory.openSession();
        }
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }
}
