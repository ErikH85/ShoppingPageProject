package com.gavlehudik.shopping;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class RFRepository {

    @Autowired
    public DataSource dataSource;

    public boolean addUser(String email, String password, String firstname, String lastname, String address,
                           String zipcode, String city, String country) {
        boolean newUserStatus = false;

        try {
            Connection conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement("INSERT INTO users VALUES(?,?,?,?,?,?,?,?)", new String[]{"id"});
            ps.setString(1, email);
            ps.setString(2, password);
            ps.setString(3, firstname);
            ps.setString(4, lastname);
            ps.setString(5, address);
            ps.setString(6, zipcode);
            ps.setString(7, city);
            ps.setString(8, country);

            PreparedStatement ps1 = conn.prepareStatement("SELECT email FROM users WHERE email = ?");
            ps1.setString(1, email);
            ResultSet resultSet = ps1.executeQuery();

            if (!resultSet.next()) {
                ps.executeUpdate();
                newUserStatus = true;
                return newUserStatus;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return newUserStatus;
    }

    public void addAddresses(String email, String addresses){

        try {
            Connection conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement("SELECT userID FROM users WHERE email = ?");
            ps.setString(1, email);
            ResultSet resultSet = ps.executeQuery();

            PreparedStatement ps2 = conn.prepareStatement("INSERT INTO Addresses VALUES(?,?)");
            ps2.setString(1, email);
            ps2.setString(2, addresses);

            conn.close();

    } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
