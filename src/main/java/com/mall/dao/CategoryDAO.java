package com.mall.dao;

import com.mall.model.Category;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategoryDAO {
    final String jdbcURL = "jdbc:mysql://172.19.185.115:3306/mall_admin?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC&useUnicode=true&characterEncoding=UTF-8";
    final String jdbcUsername = "devplogin";
    final String jdbcPassword = "devplogin";  // Update this

    private static final String INSERT_SQL = "INSERT INTO categories (name, description) VALUES (?, ?);";
    private static final String SELECT_BY_ID = "SELECT id, name, description FROM categories WHERE id =?;";
    private static final String SELECT_ALL = "SELECT * FROM categories;";
    private static final String DELETE_SQL = "DELETE FROM categories WHERE id = ?;";
    private static final String UPDATE_SQL = "UPDATE categories SET name = ?, description = ? WHERE id = ?;";

    protected Connection getConnection() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new SQLException(e);
        }
        return DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
    }

    public void insert(Category category) throws SQLException {
        try (Connection conn = getConnection(); PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
            ps.setString(1, category.getName());
            ps.setString(2, category.getDescription());
            ps.executeUpdate();
        }
    }

    public Category select(int id) throws SQLException {
        Category category = null;
        try (Connection conn = getConnection(); PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                category = new Category(rs.getInt("id"), rs.getString("name"), rs.getString("description"));
            }
        }
        return category;
    }

    public List<Category> selectAll() throws SQLException {
        List<Category> categories = new ArrayList<>();
        try (Connection conn = getConnection(); PreparedStatement ps = conn.prepareStatement(SELECT_ALL)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                categories.add(new Category(rs.getInt("id"), rs.getString("name"), rs.getString("description")));
            }
        }
        return categories;
    }

    public boolean delete(int id) throws SQLException {
        try (Connection conn = getConnection(); PreparedStatement ps = conn.prepareStatement(DELETE_SQL)) {
            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        }
    }

    public boolean update(Category category) throws SQLException {
        try (Connection conn = getConnection(); PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            ps.setString(1, category.getName());
            ps.setString(2, category.getDescription());
            ps.setInt(3, category.getId());
            return ps.executeUpdate() > 0;
        }
    }
}