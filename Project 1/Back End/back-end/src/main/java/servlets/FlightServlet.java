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
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        List<Flight> list = FlightRepoWHibernateUtil.getAllFlights();
        System.out.println("This this the contents of the list");
        for(int i = 0; i < list.size(); i++){
            System.out.println(list.get(i));
        }
        ObjectMapper mapper = new ObjectMapper();
        resp.getWriter().write(mapper.writeValueAsString(list));



    }

}