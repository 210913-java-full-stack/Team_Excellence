package servlets;

import model.*;
import repository.*;

import org.hibernate.cfg.Configuration;

import javax.servlet.ServletContextListener;
import javax.servlet.ServletContextEvent;

public class DependencyLoaderListener  implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {


        try {
            Configuration config = new Configuration();
            config.addAnnotatedClass(Customer.class);
            config.addAnnotatedClass(Pilots.class);
            config.addAnnotatedClass(Admin.class);
            config.addAnnotatedClass(Flight.class);
            config.addAnnotatedClass(Tickets.class);

            CustomerRepo.setSessionFactory(config.buildSessionFactory());
            CustomerRepo.setSession(CustomerRepo.getSessionFactory().openSession());

            PilotRepo.setSessionFactory(config.buildSessionFactory());
            PilotRepo.setSession(PilotRepo.getSessionFactory().openSession());

            AdminRepo.setSessionFactory(config.buildSessionFactory());
            AdminRepo.setSession(AdminRepo.getSessionFactory().openSession());

            FlightRepo.setSessionFactory(config.buildSessionFactory());


            TicketRepo.setSessionFactory(config.buildSessionFactory());
            TicketRepo.setSession(TicketRepo.getSessionFactory().openSession());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

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
