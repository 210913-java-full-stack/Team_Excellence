package servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import model.Admin;
import services.Login;
import utils.FileLogger;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.stream.Collectors;

public class AdminLoginServlet extends HttpServlet {
    //Takes the admin login information from the front end, unmarshalls it, and passes it to the login service class
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {

        try {
            ObjectMapper mapper = new ObjectMapper();
            String requestData = req.getReader().lines().collect(Collectors.joining());
            Login login = new Login();
            Admin admin = mapper.readValue(requestData, Admin.class);
            Admin user = login.adminLogin(admin);
            String json = mapper.writeValueAsString(user);

            //Returns the 200 status as well as the user data
            resp.setStatus(200);
            resp.setContentType("application/json");
            resp.setCharacterEncoding("UTF-8");
            System.out.println(json);
            resp.getWriter().write(json);
        } catch (IOException e) {
            FileLogger.getFileLogger().writeLog("Exception in the doPost method within the AdminLoginServlet class.", 2);
        }
    }
}
