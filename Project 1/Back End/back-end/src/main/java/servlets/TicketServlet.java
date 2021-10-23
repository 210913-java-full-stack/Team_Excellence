package servlets;

import model.Customer;
import model.Flight;
import model.Ticket;
import repository.CustomerRepo;
import repository.FlightRepo;
import repository.TicketRepo;

import javax.persistence.criteria.CriteriaBuilder;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

public class TicketServlet extends HttpServlet {
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) {
        int flightId = Integer.parseInt(req.getParameter("flightId"));
        System.out.println(flightId);
        Flight flight = FlightRepo.getFlightById(flightId);
        int userId = Integer.parseInt(req.getParameter("userId"));
        System.out.println(userId);
        Customer customer = CustomerRepo.getCustomerById(userId);


    }

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp){

    }
}
