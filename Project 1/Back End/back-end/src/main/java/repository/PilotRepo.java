package repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import model.Pilot;
import org.hibernate.Transaction;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;



public class PilotRepo {
    private static SessionFactory sessionFactory;
    private static Session session;

    public static Pilot getPilotById(int id) {
        Pilot pilot = null;
        Transaction t = null;
        Session session = null;
        try{
            PilotRepo.setSession(PilotRepo.getSessionFactory().openSession());
            session = PilotRepo.getSession();
            t = session.beginTransaction();
            pilot = session.get(Pilot.class, id);
            t.commit();
        }catch (Exception e){
            e.printStackTrace();
            if (t!=null) {
                t.rollback();
            }
        } finally {
            if (session!= null) {
                session.close();
            }
        }


        return pilot;
    }

    public static List<Pilot> getAllPilots() {

        Transaction t = null;
        Session session = null;
        List<Pilot> list = null;

        try{
            PilotRepo.setSession(PilotRepo.getSessionFactory().openSession());
            session = PilotRepo.getSession();
            t = session.beginTransaction();
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Pilot> query = builder.createQuery(Pilot.class);
            Root<Pilot> root = query.from(Pilot.class);
            query.select(root);
            list = session.createQuery(query).getResultList();
            t.commit();
        }catch (Exception e){
            e.printStackTrace();
            if (t!=null) {
                t.rollback();
            }
        }finally {
            if (session!= null) {
                session.close();
            }
        }


        return list;
    }

    public static void saveNewPilot(Pilot pilot) {
        Transaction t = null;
        Session session = null;
        try{
            PilotRepo.setSession(PilotRepo.getSessionFactory().openSession());
            session = PilotRepo.getSession();
            t = session.beginTransaction();
        session.save(pilot);
        t.commit();
        }catch (Exception e){
            e.printStackTrace();
            if (t!=null) {
                t.rollback();
            }
        }finally {
            if (session!= null) {
                session.close();
            }
        }
    }

    public static void deletePilot(Pilot pilot) {
        Transaction t = null;
        Session session = null;
        try{
            PilotRepo.setSession(PilotRepo.getSessionFactory().openSession());
            session = PilotRepo.getSession();
            t = session.beginTransaction();
            session.delete(pilot);
            t.commit();
        }catch (Exception e){
            e.printStackTrace();
            if (t!=null) {
                t.rollback();
            }
        }finally {
            if (session!= null) {
                session.close();
            }
        }

    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static void setSessionFactory(SessionFactory sessionFactory) {
        PilotRepo.sessionFactory = sessionFactory;
    }

    public static Session getSession() {
        return session;
    }

    public static void setSession(Session session) {
        PilotRepo.session = session;
    }
}
