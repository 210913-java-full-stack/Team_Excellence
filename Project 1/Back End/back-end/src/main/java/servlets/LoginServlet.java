package servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import repository.CustomerDAO;
import model.Customer;
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
        System.out.println(requestData);

        String customerJsonString = null;


        //create a customer obj while logged in.
        try {
            Connection conn = ConnectionManager.getConnection();
            CustomerDAO dao = new CustomerDAO(conn);
            Customer c = dao.customerLogin(customer.getUsername(),customer.getPassword());
            customerJsonString = "{ \"token\": test123}";
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        PrintWriter out = resp.getWriter();
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        out.print(customerJsonString);
        out.flush();




    }
}
