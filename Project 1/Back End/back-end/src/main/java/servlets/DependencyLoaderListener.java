package servlets;

import model.*;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import repository.*;
import services.CancelFlight;
import org.hibernate.engine.spi.CachedNaturalIdValueSource;
import services.CancelFlight;
import services.PurchaseTicket;
import services.ScheduleFlight;
import utils.HibernateUtil;

import javax.servlet.ServletContextListener;
import javax.servlet.ServletContextEvent;
import java.util.List;

public class DependencyLoaderListener  implements ServletContextListener {
    Session session;
    @Override
    public void contextInitialized(ServletContextEvent sce) {
       session = HibernateUtil.getSession();
//
//        try {
//
//            Configuration configuration = HibernateUtil.getConfiguration();
//            FlightRepo.setSessionFactory(configuration.buildSessionFactory());
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }


        //TicketRepo.updateCheckIn(1,false);

    }


    @Override
    public void contextDestroyed(ServletContextEvent sce) {

        try {
            HibernateUtil.getSession().close();
            //FlightRepo.getSession().close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}