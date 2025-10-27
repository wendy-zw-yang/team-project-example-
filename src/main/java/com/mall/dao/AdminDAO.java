package com.mall.dao;

import com.mall.model.Admin;
import java.sql.*;

public class AdminDAO {

    protected Connection getConnection() throws SQLException {
        final String jdbcURL = "jdbc:mysql://172.19.185.115:3306/mall_admin?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC&useUnicode=true&characterEncoding=UTF-8";
        final String jdbcUsername = "devplogin";
        final String jdbcPassword = "devplogin";  // Update this

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new SQLException(e);
        }
        return DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
    }

    public Admin validate(String username, String password) {
        Admin admin = null;
        String sql = "SELECT * FROM admins WHERE username = ? AND password = ?";
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                admin = new Admin();
                admin.setId(rs.getInt("id"));
                admin.setUsername(rs.getString("username"));
                admin.setPassword(rs.getString("password"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return admin;
    }
}