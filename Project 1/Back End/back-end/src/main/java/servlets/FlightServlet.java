package servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import model.Flight;

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
        Flight one = new Flight(1,1,"ATL","MOB", "10/15/2021", 7, "10/15/2021", 8);
        Flight two = new Flight(2,1,"MOB","ATL", "10/15/2021", 7, "10/15/2021", 8);
        Flight three = new Flight(3,1,"ATL","MOB", "10/15/2021", 7, "10/15/2021", 8);
        Flight four = new Flight(4,1,"MOB","ATL", "10/15/2021", 7, "10/15/2021", 8);
        Flight five = new Flight(5,1,"ATL","MOB", "10/15/2021", 7, "10/15/2021", 8);
        Flight six = new Flight(6,1,"MOB","ATL", "10/15/2021", 7, "10/15/2021", 8);
        Flight seven = new Flight(7,1,"ATL","MOB", "10/15/2021", 7, "10/15/2021", 8);
        Flight eight = new Flight(8,1,"MOB","ATL", "10/15/2021", 7, "10/15/2021", 8);

        List<Flight> list = new ArrayList<>();
        list.add(one);
        list.add(two);
        list.add(three);
        list.add(four);
        list.add(five);
        list.add(six);
        list.add(seven);
        list.add(eight);
        list.add(one);
        list.add(two);
        list.add(three);
        list.add(four);
        list.add(five);
        list.add(six);
        list.add(seven);
        list.add(eight);
        list.add(one);
        list.add(two);
        list.add(three);
        list.add(four);
        list.add(five);
        list.add(six);
        list.add(seven);
        list.add(eight);
        list.add(one);
        list.add(two);
        list.add(three);
        list.add(four);
        list.add(five);
        list.add(six);
        list.add(seven);
        list.add(eight);

        ObjectMapper mapper = new ObjectMapper();

        String json = mapper.writeValueAsString(list);
        resp.getWriter().write(json);



    }
}
