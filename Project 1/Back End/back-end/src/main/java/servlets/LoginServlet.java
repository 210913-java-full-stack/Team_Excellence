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

//
//
//        ObjectMapper mapper = new ObjectMapper();
//        String requestData = req.getReader().lines().collect(Collectors.joining());
//        Customer customer = mapper.readValue(requestData,Customer.class);
//        System.out.println(requestData);
//
//        String customerJsonString;
//
//        System.out.println("You are logged in!");
//
//        //create a customer obj while logged in.
//        try {
//            Connection conn = ConnectionManager.getConnection();
//            CustomerDAO dao = new CustomerDAO(conn);
//            Customer c = dao.customerLogin(customer.getUsername(),customer.getPassword());
//            customerJsonString = mapper.writeValueAsString(c);
//
//            if (c != null) {
//
//
//                resp.setContentType("application/json");
//                resp.setCharacterEncoding("UTF-8");
//                System.out.println(customerJsonString);
//                resp.getWriter().write(customerJsonString);
//
//            }else {
//
//                resp.setStatus(404);
//                resp.setContentType("application/json");
//                resp.setCharacterEncoding("UTF-8");
//                PrintWriter out = resp.getWriter();
//                out.print("User name is incorrect.");
//                System.out.println("Invalid login.");
//            }
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//            resp.setStatus(404);
//            resp.setContentType("application/json");
//            resp.setCharacterEncoding("UTF-8");
//            PrintWriter out = resp.getWriter();
//            out.print("User name is incorrect.");
//
//
//        }
//







    }
}