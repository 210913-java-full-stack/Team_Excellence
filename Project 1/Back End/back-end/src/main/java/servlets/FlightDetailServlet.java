package servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import model.Flight;
import services.DisplayFlightSchedule;
import services.ManageFlight;
import utils.FileLogger;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class FlightDetailServlet extends MyServlet {
    //Gets the details for a flight using the flight id
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp)  {
        int id = Integer.parseInt(req.getParameter("id"));
        DisplayFlightSchedule displayFlightSchedule = new DisplayFlightSchedule();
        Flight flight = displayFlightSchedule.displayFlightDetails(id);
        ObjectMapper mapper = new ObjectMapper();
        try {
            resp.getWriter().write(mapper.writeValueAsString(flight));
        } catch (IOException e) {
            FileLogger.getFileLogger().writeLog("Exception in the doGet method within the FlightDetailServlet Class.", 2);
        }

    }

    //Updates the flight information
    public void doPatch(HttpServletRequest request, HttpServletResponse response) {
        try {
            InputStream input = request.getInputStream();
            Scanner sc = new Scanner(input, StandardCharsets.UTF_8.name());
            String jsonText = sc.useDelimiter("\\A").next();

            ObjectMapper mapper = new ObjectMapper();
            Flight flight = mapper.readValue(jsonText, Flight.class);
            ManageFlight manageFlight = new ManageFlight();
            manageFlight.updateFlight(flight);

        }catch(Exception e){
            FileLogger.getFileLogger().writeLog("Exception in the doPatch method within the FlightDetailServlet Class.", 2);
        }
    }

    //Adds a new flight
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) {
        try {
            InputStream input = req.getInputStream();
            Scanner sc = new Scanner(input, StandardCharsets.UTF_8.name());
            String jsonText = sc.useDelimiter("\\A").next();
            ObjectMapper mapper = new ObjectMapper();

            Flight flight = mapper.readValue(jsonText, Flight.class);
            ManageFlight manageFlight = new ManageFlight();
            manageFlight.createFlight(flight);

        }catch(Exception e){
            FileLogger.getFileLogger().writeLog("Exception in the doPost method within the FlightDetailServlet Class.", 2);
        }
    }

    //Cancels a flight
    @Override
    public void doDelete(HttpServletRequest request, HttpServletResponse response) {
        try{
            InputStream input = request.getInputStream();
            Scanner sc = new Scanner(input, StandardCharsets.UTF_8.name());
            String jsonText = sc.useDelimiter("\\A").next();

            ObjectMapper mapper = new ObjectMapper();
            Flight flight = mapper.readValue(jsonText, Flight.class);
            ManageFlight manageFlight = new ManageFlight();
            manageFlight.cancelFlight(flight);

        } catch (Exception e) {
            FileLogger.getFileLogger().writeLog("Exception in the doDelete method within the FlightDetailServlet Class.", 2);
        }
    }

}