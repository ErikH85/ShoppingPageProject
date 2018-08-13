package com.gavlehudik.shopping;

import com.gavlehudik.shopping.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
public class ILRepository {

    @Autowired
    public DataSource dataSource;

    public String verifyLogin(String email) throws SQLException {

        String pw = "";

        try {
            Connection conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement("SELECT [password] FROM [users] WHERE [email] = ?");
            ps.setString(1, email);
            ResultSet resultSet = ps.executeQuery();
            resultSet.next();
            pw = resultSet.getString("password");
        }catch (SQLException e) {
            e.printStackTrace();

        }
        return pw;
    }

    public int getUserID(String email){

        int id = 0;

        try {
            Connection conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement("SELECT [userID] FROM [users] WHERE [email] = ?");
            ps.setString(1, email);
            ResultSet resultSet = ps.executeQuery();
            resultSet.next();
            id = resultSet.getInt("userID");
        }catch (SQLException e) {
            e.printStackTrace();

        }
        return id;
    }
}

