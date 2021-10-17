package servlets;

import model.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import repository.*;

import org.hibernate.cfg.Configuration;

import javax.servlet.ServletContextListener;
import javax.servlet.ServletContextEvent;

public class DependencyLoaderListener  implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {


        try {
            Session session;
            Configuration config = new Configuration().configure("hibernate.cfg.xml");
            config.addAnnotatedClass(Customer.class);
            config.addAnnotatedClass(Pilots.class);
            config.addAnnotatedClass(Admin.class);
            config.addAnnotatedClass(Flight.class);
            config.addAnnotatedClass(Tickets.class);

            SessionFactory sessionFactory = config.buildSessionFactory();

            CustomerRepo.setSessionFactory(sessionFactory);
            CustomerRepo.setSession(CustomerRepo.getSession());

            PilotRepo.setSessionFactory(config.buildSessionFactory());
            PilotRepo.setSession(PilotRepo.getSessionFactory().openSession());

            AdminRepo.setSessionFactory(config.buildSessionFactory());
            AdminRepo.setSession(AdminRepo.getSessionFactory().openSession());

            FlightRepo.setSessionFactory(sessionFactory);
            FlightRepo.setSession(FlightRepo.getSession());

            TicketRepo.setSessionFactory(config.buildSessionFactory());
            TicketRepo.setSession(TicketRepo.getSessionFactory().openSession());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

//    public static Session getSession() {
//        Session session;
//        if(session == null) {
//            session = sessionFactory.open
//        }
//    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        try {
            CustomerRepo.getSession().close();
            PilotRepo.getSession().close();
            AdminRepo.getSession().close();
            FlightRepo.getSession().close();
            TicketRepo.getSession().close();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
