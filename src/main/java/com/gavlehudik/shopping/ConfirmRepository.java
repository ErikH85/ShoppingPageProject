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

    /*

    "SELECT products.productName, products.quantity, products.price
    FROM OrderProducts
    INNER JOIN orders ON OrderProducts.orderID = orders.orderID
    INNER JOIN products ON OrderProducts.productID = products.productID
    WHERE orders.userID=?"
     */

    public List<Order> getReceipt(String userID){

        List<Order> products = new ArrayList<>();

        try {
            Connection conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement(
                    "SELECT products.productName, OrderProducts.quantity, products.price FROM OrderProducts INNER JOIN orders ON OrderProducts.orderID = orders.orderID INNER JOIN products ON OrderProducts.productID = products.productID WHERE orders.userID=?");
            ps.setString(1,userID);
            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                Order order = new Order(rs.getNString("productName"),
                        rs.getInt("price"),rs.getInt("quantity"));
                products.add(order);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return products;

    }

}
