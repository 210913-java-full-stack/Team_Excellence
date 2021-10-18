package servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import model.Customer;
import model.Flight;
import model.Pilots;
import repository.FlightRepo;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class FlightServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        List<Flight> list = FlightRepo.getAllFlights();
        ObjectMapper mapper = new ObjectMapper();
        resp.getWriter().write(mapper.writeValueAsString(list));



    }




    @Override
    public void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        InputStream input = request.getInputStream();
        Scanner sc = new Scanner(input, StandardCharsets.UTF_8.name());
        String jsonText = sc.useDelimiter("\\A").next();
        ObjectMapper mapper = new ObjectMapper();
        Flight payload = mapper.readValue(jsonText, Flight.class);
        FlightRepo.updateFlight(payload);
    }
}
