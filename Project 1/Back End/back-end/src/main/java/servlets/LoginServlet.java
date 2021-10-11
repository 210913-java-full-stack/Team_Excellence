package servlets;

import com.google.gson.Gson;
import dao.CustomerDAO;
import model.Customer;
import org.json.HTTP;
import org.json.JSONException;
import org.json.JSONObject;
import utils.ConnectionManager;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;

public class LoginServlet extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        // set variables
        StringBuffer jb = new StringBuffer();
        String line = null;
        String username = null;
        String password = null;
        String customerJsonString = null;

        //pull the username and password from the request
        try {
            BufferedReader reader = req.getReader();
            while((line = reader.readLine()) != null){
                jb.append(line);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            JSONObject jsonObject = HTTP.toJSONObject(jb.toString());

            username = jsonObject.getString("username");
            password = jsonObject.getString("password");
        } catch (JSONException e){
            throw new IOException("Error parsing JSON request string");
        }


        //create a customer obj while logged in.
        try (Connection conn = ConnectionManager.getConnection()){
            CustomerDAO dao = new CustomerDAO(conn);
            Customer c = dao.customerLogin(username,password);
            customerJsonString = new Gson().toJson(c);
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
