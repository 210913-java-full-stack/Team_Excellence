package servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import repository.CustomerDAO;
import model.Customer;
import services.Login;
import utils.ConnectionManager;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.stream.Collectors;

public class LoginServlet extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {



        ObjectMapper mapper = new ObjectMapper();
        String requestData = req.getReader().lines().collect(Collectors.joining());
        Customer customer = mapper.readValue(requestData,Customer.class);
        Login login = new Login();
        Customer user = login.customerLogin(customer);
        String json = mapper.writeValueAsString(user);
        resp.setStatus(200);
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        System.out.println(json);
        resp.getWriter().write(json);


    }
}