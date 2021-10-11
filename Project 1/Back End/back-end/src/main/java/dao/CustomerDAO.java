package dao;

import model.Customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CustomerDAO implements GenericDAO<Customer>{

    private Connection conn;

    public CustomerDAO(Connection conn) throws SQLException {
        this.conn = conn;
    }



    @Override
    public void save(Customer customer) throws SQLException {

    }

    @Override
    public Customer getItemByID(int id) throws SQLException {
        return null;
    }

    @Override
    public ArrayList<Customer> getAllItems() throws SQLException {
        return null;
    }

    @Override
    public void deleteByID(int id) throws SQLException {

    }



    public Customer customerLogin(String username, String password) throws SQLException {
        String sql = "SELECT * FROM customers WHERE username = ? AND password = ?";
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1, username);
        pstm.setString(2,password);

        ResultSet rs = pstm.executeQuery();

        if(rs.next()){
            return new Customer(rs.getInt(1), rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6));
        } else {
            return null;
        }
    }
}
