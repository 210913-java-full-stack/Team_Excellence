package servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import model.Flight;
import repository.FlightRepo;
<<<<<<< HEAD
import repository.FlightRepoWHibernateUtil;
=======
import services.ManageFlight;
>>>>>>> 287c91782fe3208bec0b5b7a3b5fda60604353a2

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class FlightDetailServlet extends MyServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp)  {
        int id = Integer.parseInt(req.getParameter("id"));
        Flight flight = FlightRepoWHibernateUtil.getFlightById(id);
        ObjectMapper mapper = new ObjectMapper();

        try {
            resp.getWriter().write(mapper.writeValueAsString(flight));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void doPatch(HttpServletRequest request, HttpServletResponse response) {
        try {
            InputStream input = request.getInputStream();
            Scanner sc = new Scanner(input, StandardCharsets.UTF_8.name());
            String jsonText = sc.useDelimiter("\\A").next();
            ObjectMapper mapper = new ObjectMapper();
<<<<<<< HEAD
            Flight payload = mapper.readValue(jsonText, Flight.class);

            int flightId = payload.getFlightId();
            System.out.println("Debug: I can get here 1");
            FlightRepo.updateTakeOff(flightId, true);
            //FlightRepoWHibernateUtil.updateFlight(payload);

=======
            Flight flight = mapper.readValue(jsonText, Flight.class);
            int flightId = flight.getFlightId();
            //Keep this line until we can verify that the bug in the patch method is fixed
            FlightRepo.updateFlight(flight);
>>>>>>> 287c91782fe3208bec0b5b7a3b5fda60604353a2
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) {
        try {
            InputStream input = req.getInputStream();
            Scanner sc = new Scanner(input, StandardCharsets.UTF_8.name());
            String jsonText = sc.useDelimiter("\\A").next();
            ObjectMapper mapper = new ObjectMapper();

            Flight flight = mapper.readValue(jsonText, Flight.class);
            FlightRepo.saveNewFlight(flight);

        }catch(Exception e){
            e.printStackTrace();
        }
    }

}