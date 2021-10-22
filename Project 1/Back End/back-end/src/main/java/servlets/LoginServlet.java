package servlets;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import model.Customer;
import services.Login;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.*;
import java.util.stream.Collectors;

public class LoginServlet extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {

        try {
            ObjectMapper mapper = new ObjectMapper();
            String requestData = req.getReader().lines().collect(Collectors.joining());
            Login login = new Login();
            //Figure out how to separate out request info after Tyler tells me what he is sending
            //Create if else loop where I would collect the int or boolean that indicates whether a customer
            //or admin is logging in.
            Customer customer = mapper.readValue(requestData, Customer.class);
            Customer user = login.customerLogin(customer);
            String json = mapper.writeValueAsString(user);

            resp.setStatus(200);
            resp.setContentType("application/json");
            resp.setCharacterEncoding("UTF-8");
            System.out.println(json);
            resp.getWriter().write(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}