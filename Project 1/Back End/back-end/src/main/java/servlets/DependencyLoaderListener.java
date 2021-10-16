package servlets;

import model.*;
import tyler.services.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.servlet.ServletContextListener;
import javax.servlet.ServletContextEvent;

public class DependencyLoaderListener  implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {

        Configuration config = new Configuration();
        config.addAnnotatedClass(Customer.class);
        config.addAnnotatedClass(Pilots.class);
        config.addAnnotatedClass(Admin.class);
        config.addAnnotatedClass(Flight.class);
        config.addAnnotatedClass(Tickets.class);

        CustomerServices.setSessionFactory(config.buildSessionFactory());
        CustomerServices.setSession(CustomerServices.getSessionFactory().openSession());

        PilotServices.setSessionFactory(config.buildSessionFactory());
        PilotServices.setSession(PilotServices.getSessionFactory().openSession());

        AdminServices.setSessionFactory(config.buildSessionFactory());
        AdminServices.setSession(AdminServices.getSessionFactory().openSession());

        FlightServices.setSessionFactory(config.buildSessionFactory());
        FlightServices.setSession(FlightServices.getSessionFactory().openSession());

        TicketServices.setSessionFactory(config.buildSessionFactory());
        TicketServices.setSession(TicketServices.getSessionFactory().openSession());


    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        CustomerServices.getSession().close();
        PilotServices.getSession().close();
        AdminServices.getSession().close();
        FlightServices.getSession().close();
        TicketServices.getSession().close();

    }
}
