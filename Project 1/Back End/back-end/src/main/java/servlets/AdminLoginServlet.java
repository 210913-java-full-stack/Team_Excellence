package servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import model.Admin;
import services.Login;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.stream.Collectors;

public class AdminLoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {

        try {
            ObjectMapper mapper = new ObjectMapper();
            String requestData = req.getReader().lines().collect(Collectors.joining());
            Login login = new Login();
            Admin admin = mapper.readValue(requestData, Admin.class);
            Admin user = login.adminLogin(admin);
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
