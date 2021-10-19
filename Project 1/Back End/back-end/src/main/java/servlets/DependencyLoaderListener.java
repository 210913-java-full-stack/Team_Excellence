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
            config.addAnnotatedClass(Pilot.class);
            config.addAnnotatedClass(Admin.class);
            config.addAnnotatedClass(Flight.class);
            config.addAnnotatedClass(Ticket.class);

            CustomerRepo.setSessionFactory(config.buildSessionFactory());


            PilotRepo.setSessionFactory(config.buildSessionFactory());


            AdminRepo.setSessionFactory(config.buildSessionFactory());


            FlightRepo.setSessionFactory(config.buildSessionFactory());


            TicketRepo.setSessionFactory(config.buildSessionFactory());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}
