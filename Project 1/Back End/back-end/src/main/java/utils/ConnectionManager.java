package utils;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLClassLoader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionManager {
    private static Connection conn;

    private ConnectionManager() {

    }


    /*
    This is a static method for returning a connection in the factory singleton design pattern
     */
    public static Connection getConnection() {
        if(conn == null) {
            try {
                Properties props = new Properties();

                ClassLoader cl = Thread.currentThread().getContextClassLoader();
                URL[] urls = ((URLClassLoader)cl).getURLs();
                for (URL url: urls){
                    System.out.println(url.getFile());
                }

                InputStream input = cl.getResourceAsStream("connection.properties");

                props.load(input);
                Class.forName("org.mariadb.jdbc.Driver");
//                Properties props = new Properties();
//                FileReader connectionProperties = new FileReader("src/main/resources/connection.properties");
//                props.load(connectionProperties);

                //"jdbc:mariadb://hostname:port/databaseName?user=username&password=password"
                String connString = "jdbc:mariadb://" +
                        props.getProperty("hostname") + ":" +
                        props.getProperty("port") + "/" +
                        props.getProperty("databaseName") + "?user=" +
                        props.getProperty("user") + "&password=" +
                        props.getProperty("password");


                conn = DriverManager.getConnection(connString);
            } catch(SQLException | IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        return conn;
    }
}
