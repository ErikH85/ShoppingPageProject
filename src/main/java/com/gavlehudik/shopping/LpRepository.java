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
public class LpRepository {

    @Autowired
    public DataSource dataSource;

    public List<String> getProducts() {
        List<String> products = new ArrayList<>();

        try {
            Connection conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement("SELECT productName,price FROM products WHERE category LIKE 'Konsoll'");
            ResultSet result = ps.executeQuery();

            while(result.next()){
                products.add(result.getString("productname"));
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }
}
