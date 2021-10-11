package dao;

import java.sql.SQLException;
import java.util.ArrayList;

public interface GenericDAO<T> {
    //we will need a Connection in the class, but interfaces generally don't have fields
    //Connection conn = null;

    //create
    //save object to database method
    public void save(T t) throws SQLException;
    //read
    //query data from database, fill in empty model object
    public T getItemByID(int id) throws SQLException;
    public ArrayList<T> getAllItems() throws SQLException;
    //public ToDoItem getItemByKeyword(String keyword); //SELECT * FROM items WHERE message LIKE "%KEYWORD%"
    //update
    // we will use the save() method for updates
    //delete
    //remove by ID
    public void deleteByID(int id) throws SQLException;
}
