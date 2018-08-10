package com.gavlehudik.shopping;


import com.gavlehudik.shopping.ShoppingCart;
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
public class SHRepository {

    @Autowired
    public DataSource dataSource;


    public List<ShoppingCart> getShoppingCart(String userID){
        List<ShoppingCart> shoppingCartInventory = new ArrayList<>();

        try {
            Connection conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement("SELECT productName, quantity, price FROM shoppingCart WHERE userID=?");
            ps.setString(1,userID);
            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                shoppingCartInventory.add(new ShoppingCart(rs.getNString("productName"),
                        rs.getInt("quantity"), rs.getInt("price")));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return shoppingCartInventory;
    }

}