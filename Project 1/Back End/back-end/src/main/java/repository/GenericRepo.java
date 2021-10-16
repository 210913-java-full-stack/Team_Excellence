package repository;

import org.hibernate.Session;

public interface GenericRepo {

    static void init(Session s) {
    }

    static List<E> getAll() {
        return null;
    }

    static List<E> getItemById(){
        return null;
    }

}
