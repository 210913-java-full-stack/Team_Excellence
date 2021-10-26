package utils;

import model.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    private static SessionFactory sessionFactory;
    private static Session session;
    private static Configuration configuration = new Configuration();

    //Sets up the configurations for each of the models
    public static void configureClasses(){
        configuration.addAnnotatedClass(Customer.class);
        configuration.addAnnotatedClass(Admin.class);
        configuration.addAnnotatedClass(Flight.class);
        configuration.addAnnotatedClass(Ticket.class);
    }

    //Gets the sessionFactory if it exists and creates it if it is null
    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            configureClasses();
            sessionFactory = configuration.buildSessionFactory();
        }
        return sessionFactory;
    }

    //Gets the session if it exists and creates it if it is null
    public static Session getSession() {
        if(session == null){
            session = getSessionFactory().openSession();
        }
        return session;
    }

    //Sets the session
    public static void setSession(Session session) {
        HibernateUtil.session = session;
    }

    //Closes the session
    public static void closeSession(){
        session.close();
        session = null;
    }

}