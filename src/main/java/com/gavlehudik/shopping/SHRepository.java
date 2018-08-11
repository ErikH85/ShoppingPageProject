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
public class SHRepository {

    @Autowired
    public DataSource dataSource;


    public List<ShoppingCart> getShoppingCart(String userID){
        List<ShoppingCart> shoppingCartInventory = new ArrayList<>();

        try {
            Connection conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement("SELECT productID, productName, quantity, price FROM shoppingCart WHERE userID=?");
            ps.setString(1,userID);
            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                shoppingCartInventory.add(new ShoppingCart( rs.getInt("productID"), rs.getNString("productName"),
                        rs.getInt("price"), rs.getInt("quantity")));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return shoppingCartInventory;
    }

    public void removeProduct(int userID, int productID){
        try{
            Connection conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement("SELECT quantity FROM shoppingCart WHERE userID=? AND productID=?");
            ps.setInt(1, userID);
            ps.setInt(2, productID);
            ResultSet rs = ps.executeQuery();
            rs.next();
            int productQuantity = rs.getInt("quantity");
            if(productQuantity > 1){
                ps = conn.prepareStatement("UPDATE shoppingCart SET quantity=? WHERE userID=? AND productID=?");
                ps.setInt(1,productQuantity-1);
                ps.setInt(2,userID);
                ps.setInt(3,productID);
                ps.executeUpdate();
            }
            else{
                ps = conn.prepareStatement("DELETE shoppingCart WHERE userID=? AND productID=? ");
                ps.setInt(1,userID);
                ps.setInt(2,productID);
                ps.executeUpdate();
            }
        }
        catch (SQLException e) {
        e.printStackTrace();
        }
    }

}