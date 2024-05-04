package com.app.repo;

import com.app.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UserRepository {
    static Logger logger= Logger.getLogger(UserRepository.class.getName());
    public int saveUser(User user){
        Connection connection=DBConnection.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement("insert into user values(?, ?, ?)");
            statement.setInt(1, user.getId());
            statement.setString(2, user.getName());
            statement.setString(3, user.getEmailAddress());
        } catch (SQLException e) {
            logger.log(Level.SEVERE, null, e);
        }
    }
}
