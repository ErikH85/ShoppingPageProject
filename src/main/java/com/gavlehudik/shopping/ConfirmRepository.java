package com.gavlehudik.shopping;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class ConfirmRepository {

    public DataSource dataSource;

    public String getAddress(String email){

        String address = "";

        try {
            Connection conn = dataSource.getConnection();
            PreparedStatement ps =conn.prepareStatement("SELECT address FROM users WHERE email=?");
            ps.setString(1,email);
            ResultSet rs = ps.executeQuery();
            rs.next();
            address = rs.getNString("address");
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return address;
    }

}
