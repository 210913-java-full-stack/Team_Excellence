package servlets;

import model.Ticket;
import org.hibernate.Session;
import services.PassengerList;
import utils.FileLogger;
import utils.HibernateUtil;

import javax.servlet.ServletContextListener;
import javax.servlet.ServletContextEvent;
import java.util.List;

public class DependencyLoaderListener  implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        Session session = HibernateUtil.getSession();
        HibernateUtil.setSession(session);
    }


    @Override
    public void contextDestroyed(ServletContextEvent sce) {

        try {
            HibernateUtil.closeSession();
        } catch (Exception e) {
            FileLogger.getFileLogger().writeLog(4);
        }
    }
}