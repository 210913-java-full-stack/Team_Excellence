package repository;

import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;

public interface GenericRepo<E> {

    static void init(Session s) {
    }
 //Implementing CRUD functions
    //Create


    //Read
    ArrayList<E> getAll();
    ArrayList<E> getItemById(int id);
    //Update

    //Delete
}
