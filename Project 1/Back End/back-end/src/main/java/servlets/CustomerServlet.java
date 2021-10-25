package servlets;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import model.Customer;
import model.Flight;
import model.Ticket;
import services.DisplayFlightSchedule;
import services.PassengerList;
import services.Register;
import utils.FileLogger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Scanner;

public class CustomerServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        try{
            int id = Integer.parseInt(req.getParameter("id"));
            //Gets the passenger list for the flight manifest
            PassengerList passengerList = new PassengerList();
            List<Ticket> list = passengerList.passengersOnFlight(id);
            ObjectMapper mapper = new ObjectMapper();
            resp.getWriter().write(mapper.writeValueAsString(list));

        } catch (IOException e) {
            FileLogger.getFileLogger().writeLog(2);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp ) {
        try {
            InputStream requestBody = req.getInputStream();
            Scanner sc = new Scanner(requestBody, StandardCharsets.UTF_8.name());
            String jsonText = sc.useDelimiter("\\A").next();
            ObjectMapper mapper = new ObjectMapper();
            Customer customer = mapper.readValue(jsonText, Customer.class);
            Register register = new Register();
            Customer user = register.registerForAccount(customer);

            String json = mapper.writeValueAsString(user);

            resp.setStatus(200);
            resp.setContentType("application/json");
            resp.setCharacterEncoding("UTF-8");
            System.out.println(json);
            resp.getWriter().write(json);
        } catch (IOException e) {
            FileLogger.getFileLogger().writeLog(2);
        }
    }
}
