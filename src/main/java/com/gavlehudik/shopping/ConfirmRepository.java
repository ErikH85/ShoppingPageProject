package com.gavlehudik.shopping;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


@Component
public class ConfirmRepository {


    @Autowired
    public DataSource dataSource;

    public List<String> getAddress(String email){

        List<String> addresses = new ArrayList<>();

        try {
            Connection conn = dataSource.getConnection();
            PreparedStatement ps =conn.prepareStatement("SELECT address FROM users WHERE email=?");
            ps.setString(1,email);
            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                addresses.add(rs.getNString("address"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return addresses;
    }

}
