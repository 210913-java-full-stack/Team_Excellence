package utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    private static SessionFactory sessionFactory;
    private static Session session;
    private static Configuration configuration = new Configuration();

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            sessionFactory = configuration.buildSessionFactory();
        }
        return sessionFactory;
    }

    public static void setSessionFactory(SessionFactory sessionFactory) {
        HibernateUtil.sessionFactory = sessionFactory;
    }

    public static Session getSession() {
        if(session == null){
            session = sessionFactory.openSession();
        }
        return session;
    }

    public static void setSession(Session session) {
        HibernateUtil.session = session;
    }
}
