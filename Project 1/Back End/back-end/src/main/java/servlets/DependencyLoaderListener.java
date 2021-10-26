package servlets;

import org.hibernate.Session;
import utils.FileLogger;
import utils.HibernateUtil;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletContextEvent;

public class DependencyLoaderListener  implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        //Initializes the session and sets the session
        Session session = HibernateUtil.getSession();
        HibernateUtil.setSession(session);
    }


    @Override
    public void contextDestroyed(ServletContextEvent sce) {

        try {
            //Gracefully closes the session
            HibernateUtil.closeSession();
        } catch (Exception e) {
            FileLogger.getFileLogger().writeLog(4);
        }
    }
}