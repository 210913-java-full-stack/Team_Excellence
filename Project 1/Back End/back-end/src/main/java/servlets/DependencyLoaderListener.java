package servlets;

import model.*;

import org.hibernate.cfg.Configuration;
import utils.HibernateUtil;

import javax.servlet.ServletContextListener;
import javax.servlet.ServletContextEvent;

public class DependencyLoaderListener  implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {


        try {
            Configuration config = new Configuration();
            HibernateUtil.setSessionFactory(HibernateUtil.getSessionFactory());
            config.addAnnotatedClass(Customer.class);
            config.addAnnotatedClass(Pilots.class);
            config.addAnnotatedClass(Admin.class);
            config.addAnnotatedClass(Flight.class);
            config.addAnnotatedClass(Ticket.class);


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        HibernateUtil hibernateUtil = new HibernateUtil();

        try {
            hibernateUtil.getSession().close();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
