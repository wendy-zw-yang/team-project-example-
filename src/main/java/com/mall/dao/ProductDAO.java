package com.mall.dao;

import com.mall.model.Product;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {
    final String jdbcURL = "jdbc:mysql://172.19.185.115:3306/mall_admin?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC&useUnicode=true&characterEncoding=UTF-8";
    final String jdbcUsername = "devplogin";
    final String jdbcPassword = "devplogin";  // Update this

    private static final String INSERT_SQL = "INSERT INTO products (name, price, description, category_id, status) VALUES (?, ?, ?, ?, ?);";
    private static final String SELECT_BY_ID = "SELECT * FROM products WHERE id =?;";
    private static final String SELECT_ALL = "SELECT * FROM products;";
    private static final String DELETE_SQL = "DELETE FROM products WHERE id = ?;";
    private static final String UPDATE_SQL = "UPDATE products SET name = ?, price = ?, description = ?, category_id = ?, status = ? WHERE id = ?;";

    protected Connection getConnection() throws SQLException {
        // Same as CategoryDAO
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new SQLException(e);
        }
        return DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
    }

    public void insert(Product product) throws SQLException {
        try (Connection conn = getConnection(); PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
            ps.setString(1, product.getName());
            ps.setDouble(2, product.getPrice());
            ps.setString(3, product.getDescription());
            ps.setInt(4, product.getCategoryId());
            ps.setString(5, product.getStatus());
            ps.executeUpdate();
        }
    }

    public Product select(int id) throws SQLException {
        Product product = null;
        try (Connection conn = getConnection(); PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                product = new Product(rs.getInt("id"), rs.getString("name"), rs.getDouble("price"),
                        rs.getString("description"), rs.getInt("category_id"), rs.getString("status"));
            }
        }
        return product;
    }

    public List<Product> selectAll() throws SQLException {
        List<Product> products = new ArrayList<>();
        try (Connection conn = getConnection(); PreparedStatement ps = conn.prepareStatement(SELECT_ALL)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                products.add(new Product(rs.getInt("id"), rs.getString("name"), rs.getDouble("price"),
                        rs.getString("description"), rs.getInt("category_id"), rs.getString("status")));
            }
        }
        return products;
    }

    public boolean delete(int id) throws SQLException {
        try (Connection conn = getConnection(); PreparedStatement ps = conn.prepareStatement(DELETE_SQL)) {
            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        }
    }

    public boolean update(Product product) throws SQLException {
        try (Connection conn = getConnection(); PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            ps.setString(1, product.getName());
            ps.setDouble(2, product.getPrice());
            ps.setString(3, product.getDescription());
            ps.setInt(4, product.getCategoryId());
            ps.setString(5, product.getStatus());
            ps.setInt(6, product.getId());
            return ps.executeUpdate() > 0;
        }
    }
}