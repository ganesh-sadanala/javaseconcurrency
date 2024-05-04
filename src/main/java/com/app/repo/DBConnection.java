package com.app.repo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBConnection {
    static Logger logger= Logger.getLogger(DBConnection.class.getName());
    public static Connection getConnection(){
        Connection connection=null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/test", user, password);
        } catch (ClassNotFoundException | SQLException e) {
            logger.log(Level.SEVERE, null, e);
        }
        return connection;
    }
}
