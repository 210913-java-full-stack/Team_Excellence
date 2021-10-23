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
        DisplayFlightSchedule displayFlightSchedule = new DisplayFlightSchedule();

        //Debug this method
        List<Flight> customerFlightList = displayFlightSchedule.displayFlightsCustomer();
        for (Flight flight: customerFlightList) {
            System.out.println("Available Flight Id: " + flight.getFlightId());
        }
        Flight flightDetail = displayFlightSchedule.displayFlightDetails(4);
        System.out.println("Arrive: " + flightDetail.getArriveLocation());


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