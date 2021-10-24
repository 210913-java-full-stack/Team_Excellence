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
import services.DisplayFlightSchedule;
import services.Login;
import services.Register;
import utils.HibernateUtil;

import javax.servlet.ServletContextListener;
import javax.servlet.ServletContextEvent;
import java.util.List;

public class DependencyLoaderListener  implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        Session session = HibernateUtil.getSession();
        HibernateUtil.setSession(session);

        //Test service layer below this comment

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