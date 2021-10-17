package servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import model.Flight;
import model.Pilots;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FlightServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        Flight one = new Flight(1,new Pilots(1,"u", "p","p@email.com","Bob","Dylan"),"ATL","MOB", "10/15/2021", 7, "10/15/2021", 8, false, 50);


        List<Flight> list = new ArrayList<>();
        list.add(one);

        ObjectMapper mapper = new ObjectMapper();

        String json = mapper.writeValueAsString(list);
        resp.getWriter().write(json);



    }
}
