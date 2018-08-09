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

    public Boolean verifyLogin(String email, String password) throws SQLException {
        List<User> users = new ArrayList <>();

        try {
            Connection conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement("SELECT [userID], [firstname], [lastname], [address], [email], [password] FROM [users] WHERE [email] = ? AND [password] = ?");
            ps.setString(1, email);
            ps.setString(2, password);
            ResultSet resultSet = ps.executeQuery();

            while (resultSet.next()) {
                User user = new User(resultSet.getInt("userID"), resultSet.getString("firstname"),
                        resultSet.getString("lastname"), resultSet.getString("address"),
                        resultSet.getString("email"), resultSet.getString("password"));

                users.add(user);

            }
            if (users.size() > 0) {
                return true;
            }

        }catch (SQLException e) {
            e.printStackTrace();

        }
        return false;
    }
}

