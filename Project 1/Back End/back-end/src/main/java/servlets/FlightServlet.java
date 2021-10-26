package servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import model.Flight;
import services.DisplayFlightSchedule;
import utils.FileLogger;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class FlightServlet extends HttpServlet {

    //This servlet gets the list of flights that will be displayed on the customer and admin homepages
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        boolean typeOfUser = Boolean.parseBoolean(req.getParameter("allFlights"));
        DisplayFlightSchedule displayFlightSchedule = new DisplayFlightSchedule();
        List<Flight> list;
        if(typeOfUser){
            list = displayFlightSchedule.displayFlightsAdmin();
        } else{
            list = displayFlightSchedule.displayFlightsCustomer();
        }
        ObjectMapper mapper = new ObjectMapper();
        try {
            resp.getWriter().write(mapper.writeValueAsString(list));
        } catch (IOException e) {
            FileLogger.getFileLogger().writeLog(2);
        }


    }

}