package com.gavlehudik.shopping;

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
public class BuyRepository {

    @Autowired
    public DataSource dataSource;

    public List<String> getAddress(String userID){

        List<String> addresses = new ArrayList<>();

        try {
            Connection conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement("SELECT addresses FROM Addresses WHERE userID=?");
            ps.setString(1,userID);
            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                addresses.add(rs.getNString("addresses"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return addresses;
    }
}
