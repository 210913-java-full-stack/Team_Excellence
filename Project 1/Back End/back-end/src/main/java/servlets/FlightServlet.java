package servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import model.Flight;
import repository.FlightRepo;
import repository.FlightRepoWHibernateUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class FlightServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        List<Flight> list = FlightRepo.getAllFlights();
        System.out.println("DEBUG: " + list.get(0).getFlightId());
        System.out.println("This this the contents of the list");
        for(int i = 0; i < list.size(); i++){
            System.out.println(list.get(i));
        }
        ObjectMapper mapper = new ObjectMapper();
        try {
            resp.getWriter().write(mapper.writeValueAsString(list));
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}