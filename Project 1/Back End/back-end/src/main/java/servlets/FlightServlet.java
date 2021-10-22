package servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import model.Flight;
import repository.FlightRepo;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class FlightServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
<<<<<<< HEAD

        List<Flight> list = FlightRepo.getAllFlights();

=======
        List<Flight> list = FlightRepo.getAllAvailableFlights();
>>>>>>> 287c91782fe3208bec0b5b7a3b5fda60604353a2
        ObjectMapper mapper = new ObjectMapper();
        try {
            resp.getWriter().write(mapper.writeValueAsString(list));
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}