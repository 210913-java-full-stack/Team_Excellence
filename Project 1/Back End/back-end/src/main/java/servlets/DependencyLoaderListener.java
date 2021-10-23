package servlets;

import model.Admin;
import model.Customer;
import model.Flight;
import model.Ticket;
import org.hibernate.Session;
import org.hibernate.Transaction;
import repository.AdminRepo;
import repository.CustomerRepo;
import repository.FlightRepo;
import repository.TicketRepo;
import utils.HibernateUtil;

import javax.servlet.ServletContextListener;
import javax.servlet.ServletContextEvent;

public class DependencyLoaderListener  implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        Session session = HibernateUtil.getSession();
        HibernateUtil.setSession(session);

    }


    @Override
    public void contextDestroyed(ServletContextEvent sce) {

        try {
            HibernateUtil.closeSession();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}