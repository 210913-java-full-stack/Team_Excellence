package utils;

import model.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    private static SessionFactory sessionFactory;
    private static Session session;
    private static Configuration configuration = new Configuration();

    public static void configureClasses(){
        configuration.addAnnotatedClass(Customer.class);
        configuration.addAnnotatedClass(Pilot.class);
        configuration.addAnnotatedClass(Admin.class);
        configuration.addAnnotatedClass(Flight.class);
        configuration.addAnnotatedClass(Ticket.class);

        //this is a test entity for test purposes
        configuration.addAnnotatedClass(TestEntity.class);
    }

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            configureClasses();
            sessionFactory = configuration.buildSessionFactory();
        }
        return sessionFactory;
    }

    public static void setSessionFactory(SessionFactory sessionFactory) {
        HibernateUtil.sessionFactory = sessionFactory;
    }

    public static Session getSession() {
        if(session == null){
            session = getSessionFactory().openSession();
        }
        return session;
    }

    public static void setSession(Session session) {
        HibernateUtil.session = session;
    }

    public static Configuration getConfiguration() {
        return configuration;
    }

    public static void setConfiguration(Configuration configuration) {
        HibernateUtil.configuration = configuration;
    }
}
