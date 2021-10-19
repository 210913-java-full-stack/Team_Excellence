package servlets;

import model.*;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.engine.spi.CachedNaturalIdValueSource;
import repository.FlightRepo;
import repository.PilotRepo;
import services.CancelFlight;
import services.ScheduleFlight;
import utils.HibernateUtil;

import javax.servlet.ServletContextListener;
import javax.servlet.ServletContextEvent;

public class DependencyLoaderListener  implements ServletContextListener {
    Session session;
    @Override
    public void contextInitialized(ServletContextEvent sce) {
       session = HibernateUtil.getSession();

        try {
            Configuration configuration = HibernateUtil.getConfiguration();

            FlightRepo.setSessionFactory(configuration.buildSessionFactory());
            FlightRepo.setSession(FlightRepo.getSessionFactory().openSession());

        } catch (Exception e) {
            e.printStackTrace();
        }

//        Pilot pilot = new Pilot("Conner", "password", "tyler.conner@revature.net", "Tyler", "Conner");
//
//        PilotRepo pilotRepo = new PilotRepo();
//        pilotRepo.saveNewPilot(pilot);
//
//        Flight flight = new Flight();
//        flight.setPilot(pilot);
//        flight.setAvailable(true);
//        flight.setTakeOff(false);
//        flight.setArriveDate("2021-10-5");
//        flight.setArriveTime("5:00pm");
//        flight.setArriveLocation("LAX");
//        flight.setDepartDate("2021-10-5");
//        flight.setDepartTime("4:00pm");
//        flight.setDepartLocation("DIA");
//        flight.setMaxNumberOfTickets(5);
//
//        ScheduleFlight scheduleFlight = new ScheduleFlight();
//        Transaction tx2 = session.beginTransaction();
//        scheduleFlight.createNewFlight(flight);
//        tx2.commit();


//        CancelFlight cf = new CancelFlight();
//        cf.cancelFlight(846754);

        //Code for testing that Hibernate is able to make changes to the database
//        TestEntity testEntity = new TestEntity("this is a test");
//
//        Transaction tx = session.beginTransaction();
//        session.save(testEntity);
//        tx.commit();
//
//        TestEntity testEntity3 = session.get(TestEntity.class, 1);
//        System.out.println("testEntity = " + testEntity3);
//
//        TestEntity testEntity2 = session.get(TestEntity.class, 2);
//        System.out.println("testEntity = " + testEntity2);





    }


    @Override
    public void contextDestroyed(ServletContextEvent sce) {

        try {
            HibernateUtil.getSession().close();
            FlightRepo.getSession().close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}