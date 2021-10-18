package servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public abstract class MyServlet extends HttpServlet {

    public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getMethod().equalsIgnoreCase("PATCH")){
            doPatch(req, resp);
        } else if (req.getMethod().equalsIgnoreCase("PUT")){
            doPut(req,resp);
        }else {
            super.service(req, resp);
        }

            }

    public abstract void doPatch(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
    public abstract void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
}
