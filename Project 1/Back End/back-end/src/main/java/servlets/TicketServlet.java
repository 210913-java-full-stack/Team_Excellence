package servlets;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Enumeration;

public class TicketServlet extends HttpServlet {
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp){
        Enumeration<String> list = req.getParameterNames();
        while(list.hasMoreElements()){
            System.out.println(list.nextElement());
        }

    }
}
