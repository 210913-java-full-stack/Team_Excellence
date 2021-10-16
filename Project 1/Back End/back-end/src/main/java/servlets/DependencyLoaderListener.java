package servlets;

import model.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import repository.*;

import org.hibernate.cfg.Configuration;

import javax.servlet.ServletContextListener;
import javax.servlet.ServletContextEvent;

public class DependencyLoaderListener  implements ServletContextListener {
    private static Session session;
    private static SessionFactory sessionFactory;

    @Override
    public void contextInitialized(ServletContextEvent sce) {


        try {
            //Set up the persistence context
            Configuration config = new Configuration().configure("hibernate.cfg.xml");
            config.addAnnotatedClass(Customer.class);
            config.addAnnotatedClass(Pilots.class);
            config.addAnnotatedClass(Admin.class);
            config.addAnnotatedClass(Flight.class);
            config.addAnnotatedClass(Tickets.class);
            setSessionFactory(config.buildSessionFactory());
            setSession(sessionFactory.openSession());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        try {
            getSession().close();

        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Session getSession() {
        return session;
    }

    public static void setSession(Session session) {
        DependencyLoaderListener.session = session;
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static void setSessionFactory(SessionFactory sessionFactory) {
        DependencyLoaderListener.sessionFactory = sessionFactory;
    }
}

