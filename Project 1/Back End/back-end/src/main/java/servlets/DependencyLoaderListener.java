package servlets;

import model.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import repository.*;

import org.hibernate.cfg.Configuration;
import utils.HibernateUtil;

import javax.servlet.ServletContextListener;
import javax.servlet.ServletContextEvent;

public class DependencyLoaderListener  implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {


        try {
            Session session;
            Configuration config = new Configuration().configure("hibernate.cfg.xml");
            config.addAnnotatedClass(Customer.class);
            config.addAnnotatedClass(Pilots.class);
            config.addAnnotatedClass(Admin.class);
            config.addAnnotatedClass(Flight.class);
            config.addAnnotatedClass(Tickets.class);


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

//    public static Session getSession() {
//        Session session;
//        if(session == null) {
//            session = sessionFactory.open
//        }
//    }

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
