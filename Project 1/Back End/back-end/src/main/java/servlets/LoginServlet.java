package servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import dao.CustomerDAO;
import jdk.internal.util.xml.impl.Input;
import model.Customer;
import org.json.HTTP;
import org.json.JSONException;
import org.json.JSONObject;
import utils.ConnectionManager;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.UUID;
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
//            customerJsonString = mapper.writeValueAsString(c);
//            customerJsonString = "{ \"token\": \"test123\"}";
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            resp.setStatus(404);
            resp.setContentType("application/json");
            resp.setCharacterEncoding("UTF-8");
            PrintWriter out = resp.getWriter();
            out.print("User name is incorrect.");
            return;

        }

        final String uuid = UUID.randomUUID().toString().replace("-", "");

        PrintWriter out = resp.getWriter();
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        out.print("{ \"token\": \"" + uuid + "\" }");






    }
}
