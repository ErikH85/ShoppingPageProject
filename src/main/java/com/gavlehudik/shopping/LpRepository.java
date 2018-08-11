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

    public List<Products> getConsoles() {
        List<Products> products = new ArrayList<>();

        try {
            Connection conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement("SELECT productName,price,productID FROM products WHERE category LIKE 'Konsoll'");
            ResultSet result = ps.executeQuery();

            while(result.next()){
                Products product = new Products(result.getString("productName"),result.getInt("price"),result.getInt("productID"));
                products.add(product);
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }

    public List<Products> getGames() {
        List<Products> products = new ArrayList<>();

        try {
            Connection conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement("SELECT productName,price,productID FROM products WHERE category LIKE 'Spel'");
            ResultSet result = ps.executeQuery();

            while(result.next()){
                Products product = new Products(result.getString("productName"),result.getInt("price"),result.getInt("productID"));
                products.add(product);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }

    public List<Products> getAccessories() {
        List<Products> products = new ArrayList<>();

        try {
            Connection conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement("SELECT productName,price,productID FROM products WHERE category LIKE 'Tillbehör'");
            ResultSet result = ps.executeQuery();

            while(result.next()){
                Products product = new Products(result.getString("productName"),result.getInt("price"),result.getInt("productID"));
                products.add(product);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }

    public List<Products> getPhones() {
        List<Products> products = new ArrayList<>();

        try {
            Connection conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement("SELECT productName,price,productID FROM products WHERE category LIKE 'Mobil'");
            ResultSet result = ps.executeQuery();

            while(result.next()){
                Products product = new Products(result.getString("productName"),result.getInt("price"),result.getInt("productID"));
                products.add(product);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }

    public void addProduct(int productID,int userID) {
        try {
            Connection conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement("SELECT productName,price FROM products WHERE productID=?");
            ps.setInt(1, productID);
            ResultSet product = ps.executeQuery();

            product.next();
            PreparedStatement ps1 = conn.prepareStatement("INSERT INTO shoppingCart VALUES(?,?,?,?,?)");
            ps1.setInt(1, userID);
            ps1.setInt(2, productID);
            ps1.setString(3, product.getString("productName"));
            ps1.setInt(4, 1);
            ps1.setInt(5, product.getInt("price"));
            ps1.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
