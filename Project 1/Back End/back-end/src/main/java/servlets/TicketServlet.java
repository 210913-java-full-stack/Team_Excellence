package servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import model.Ticket;
import repository.TicketRepo;
import services.PassengerList;
import services.PurchaseTicket;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Scanner;

public class TicketServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response){
        int flightId = Integer.parseInt(request.getParameter("flightId"));
        PassengerList pl = new PassengerList();
        List<Ticket> list = pl.passengersOnFlight(flightId);
        ObjectMapper mapper = new ObjectMapper();
        try {
            response.getWriter().write(mapper.writeValueAsString(list));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) {
        int flightId = Integer.parseInt(req.getParameter("flightId"));
        int customerId = Integer.parseInt(req.getParameter("userId"));
        Ticket firstTicket = new Ticket();
        Ticket secondTicket = new Ticket();
        Ticket thirdTicket = new Ticket();
        Ticket fourthTicket = new Ticket();
        PurchaseTicket purchaseTicket = new PurchaseTicket();


        int numOfTickets = Integer.parseInt(req.getParameter("numOfTicket"));
        if (numOfTickets == 1) {

            firstTicket.setPassengerFirstName(req.getParameter("1_fname"));
            firstTicket.setPassengerLastName(req.getParameter("1_lname"));
            firstTicket.setPassengerAge(Integer.parseInt(req.getParameter("1_age")));
            purchaseTicket.newTicket(firstTicket,flightId,customerId);

        } else if (numOfTickets == 2) {
            firstTicket.setPassengerFirstName(req.getParameter("1_fname"));
            firstTicket.setPassengerLastName(req.getParameter("1_lname"));
            firstTicket.setPassengerAge(Integer.parseInt(req.getParameter("1_age")));
            purchaseTicket.newTicket(firstTicket,flightId,customerId);

            secondTicket.setPassengerFirstName(req.getParameter("2_fname"));
            secondTicket.setPassengerLastName(req.getParameter("2_lname"));
            secondTicket.setPassengerAge(Integer.parseInt(req.getParameter("2_age")));
            purchaseTicket.newTicket(secondTicket,flightId,customerId);

        } else if (numOfTickets == 3) {
            firstTicket.setPassengerFirstName(req.getParameter("1_fname"));
            firstTicket.setPassengerLastName(req.getParameter("1_lname"));
            firstTicket.setPassengerAge(Integer.parseInt(req.getParameter("1_age")));
            purchaseTicket.newTicket(firstTicket,flightId,customerId);

            secondTicket.setPassengerFirstName(req.getParameter("2_fname"));
            secondTicket.setPassengerLastName(req.getParameter("2_lname"));
            secondTicket.setPassengerAge(Integer.parseInt(req.getParameter("2_age")));
            purchaseTicket.newTicket(secondTicket,flightId,customerId);

            thirdTicket.setPassengerFirstName(req.getParameter("3_fname"));
            thirdTicket.setPassengerLastName(req.getParameter("3_lname"));
            thirdTicket.setPassengerAge(Integer.parseInt(req.getParameter("3_age")));
            purchaseTicket.newTicket(thirdTicket,flightId,customerId);

        } else if (numOfTickets == 4) {
            firstTicket.setPassengerFirstName(req.getParameter("1_fname"));
            firstTicket.setPassengerLastName(req.getParameter("1_lname"));
            firstTicket.setPassengerAge(Integer.parseInt(req.getParameter("1_age")));
            purchaseTicket.newTicket(firstTicket,flightId,customerId);

            secondTicket.setPassengerFirstName(req.getParameter("2_fname"));
            secondTicket.setPassengerLastName(req.getParameter("2_lname"));
            secondTicket.setPassengerAge(Integer.parseInt(req.getParameter("2_age")));
            purchaseTicket.newTicket(secondTicket,flightId,customerId);

            thirdTicket.setPassengerFirstName(req.getParameter("3_fname"));
            thirdTicket.setPassengerLastName(req.getParameter("3_lname"));
            thirdTicket.setPassengerAge(Integer.parseInt(req.getParameter("3_age")));
            purchaseTicket.newTicket(thirdTicket,flightId,customerId);

            fourthTicket.setPassengerFirstName(req.getParameter("4_fname"));
            fourthTicket.setPassengerLastName(req.getParameter("4_lname"));
            fourthTicket.setPassengerAge(Integer.parseInt(req.getParameter("4_age")));
            purchaseTicket.newTicket(fourthTicket,flightId,customerId);
        }

        try {
            resp.sendRedirect("http://localhost:3000/ticket");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void doPut(HttpServletRequest req, HttpServletResponse resp) {
        try {
            InputStream input = req.getInputStream();
            Scanner sc = new Scanner(input, StandardCharsets.UTF_8.name());
            String jsonText = sc.useDelimiter("\\A").next();
            ObjectMapper mapper = new ObjectMapper();
            Ticket ticket = mapper.readValue(jsonText, Ticket.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //Add call to the CheckIn service class

    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) {
        try {
            InputStream input = req.getInputStream();
            Scanner sc = new Scanner(input, StandardCharsets.UTF_8.name());
            String jsonText = sc.useDelimiter("\\A").next();
            ObjectMapper mapper = new ObjectMapper();
            Ticket ticket = mapper.readValue(jsonText, Ticket.class);


        } catch (IOException e) {
            e.printStackTrace();
        }
        //Add call to the cancel ticket service class

    }
}
