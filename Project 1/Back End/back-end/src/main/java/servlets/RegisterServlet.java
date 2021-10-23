package servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import model.Customer;
import services.Login;
import services.Register;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.stream.Collectors;

public class RegisterServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {

        try {
            ObjectMapper mapper = new ObjectMapper();
            String requestData = req.getReader().lines().collect(Collectors.joining());
            Register register = new Register();
            Customer customer = mapper.readValue(requestData, Customer.class);
            Customer newUser = register.registerForAccount(customer);
            String json = mapper.writeValueAsString(newUser);

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
