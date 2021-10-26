package servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import model.Customer;
import services.Login;
import utils.FileLogger;
import javax.servlet.http.*;
import java.io.*;
import java.util.stream.Collectors;

public class LoginServlet extends HttpServlet {


    //Takes the customer login information from the front end, unmarshalls it, and passes it to the login service class
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {

        try {
            ObjectMapper mapper = new ObjectMapper();
            String requestData = req.getReader().lines().collect(Collectors.joining());
            Login login = new Login();
            Customer customer = mapper.readValue(requestData, Customer.class);
            Customer user = login.customerLogin(customer);
            String json = mapper.writeValueAsString(user);

            resp.setStatus(200);
            resp.setContentType("application/json");
            resp.setCharacterEncoding("UTF-8");
            System.out.println(json);
            resp.getWriter().write(json);
        } catch (IOException e) {
            FileLogger.getFileLogger().writeLog("Exception in the doPost method within the LoginServlet class.", 2);
        }
    }
}