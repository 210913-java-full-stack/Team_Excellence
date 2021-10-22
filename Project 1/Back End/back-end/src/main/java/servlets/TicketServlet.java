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
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int flightId = Integer.parseInt(req.getParameter("flightId"));
        System.out.println(flightId);
        Flight flight = FlightRepo.getFlightbyId(flightId);
        int userId = Integer.parseInt(req.getParameter("userId"));
        System.out.println(userId);
        Customer customer = CustomerRepo.getCustomerById(userId);

        int numOfTickets = Integer.parseInt(req.getParameter("numOfTicket"));
         if(numOfTickets==1){
             String fnameOne = req.getParameter("1_fname");
             System.out.println(fnameOne);
             String lnameOne = req.getParameter("1_lname");
             System.out.println(lnameOne);
             Integer ageOne = Integer.parseInt(req.getParameter("1_age"));
             System.out.println(ageOne);
             Ticket one = new Ticket(FlightRepo.getFlightbyId(flightId),CustomerRepo.getCustomerById(userId),fnameOne,lnameOne,ageOne, true);
             TicketRepo.saveNewTicket(one);

         }else if(numOfTickets==2){
             String fnameOne = req.getParameter("1_fname");
             System.out.println(fnameOne);
             String lnameOne = req.getParameter("1_lname");
             System.out.println(lnameOne);
             Integer ageOne = Integer.parseInt(req.getParameter("1_age"));
             System.out.println(ageOne);

             String fnameTwo = req.getParameter("2_fname");
             String lnameTwo = req.getParameter("2_lname");


             Integer ageTwo = Integer.parseInt(req.getParameter("2_age"));

             System.out.println(fnameTwo);
             System.out.println(lnameTwo);
             System.out.println(ageTwo);
             Ticket two = new Ticket(flight, customer,fnameTwo,lnameTwo,ageTwo,true);
             TicketRepo.saveNewTicket(two);
             Ticket one = new Ticket(flight,customer,fnameOne,lnameOne,ageOne, true);
             TicketRepo.saveNewTicket(one);

         }else if(numOfTickets==3){

         }else if(numOfTickets==4){
             String fnameOne = req.getParameter("1_fname");
             String lnameOne = req.getParameter("1_lname");
             Integer ageOne = Integer.parseInt(req.getParameter("1_age"));
             Ticket one = new Ticket(flight,customer,fnameOne,lnameOne,ageOne, true);
             TicketRepo.saveNewTicket(one);
             String fnameTwo = req.getParameter("2_fname");
             String lnameTwo = req.getParameter("2_lname");
             Integer ageTwo = Integer.parseInt(req.getParameter("2_age"));
             Ticket two = new Ticket(flight,customer,fnameTwo,lnameTwo,ageTwo, true);
             TicketRepo.saveNewTicket(two);
             String fnameThree = req.getParameter("3_fname");
             String lnameThree = req.getParameter("3_lname");
             Integer ageThree = Integer.parseInt(req.getParameter("3_age"));
             Ticket three = new Ticket(flight,customer,fnameThree,lnameThree,ageThree, true);
             TicketRepo.saveNewTicket(three);
             String fnameFour = req.getParameter("4_fname");
             String lnameFour = req.getParameter("4_lname");
             Integer ageFour = Integer.parseInt(req.getParameter("4_age"));
             Ticket four = new Ticket(flight,customer,fnameFour,lnameFour,ageFour, true);
             TicketRepo.saveNewTicket(four);
         }

        resp.sendRedirect("http://localhost:3000/ticket");


    }
}
