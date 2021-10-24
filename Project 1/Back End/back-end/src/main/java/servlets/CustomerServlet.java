package servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import model.Customer;
import repository.CustomerRepo;
import services.Register;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Scanner;

public class CustomerServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //As an administrator, I can view a flight manifest (flight details + passenger list)
        List<Customer> customerList = CustomerRepo.getAllCustomers();
        ObjectMapper mapper = new ObjectMapper();
        resp.getWriter().write(mapper.writeValueAsString(customerList));
        resp.setContentType("application/json");
        resp.setStatus(200);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp ) throws ServletException, IOException {
        InputStream requestBody = req.getInputStream();
        Scanner sc = new Scanner(requestBody, StandardCharsets.UTF_8.name());
        String jsonText = sc.useDelimiter("\\A").next();
        ObjectMapper mapper = new ObjectMapper();
        Customer customer = mapper.readValue(jsonText, Customer.class);
        Register register = new Register();
        register.registerForAccount(customer);
    }
}
