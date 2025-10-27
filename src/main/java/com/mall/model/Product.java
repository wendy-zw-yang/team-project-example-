package com.mall.model;

public class Product {
    private int id;
    private String name;
    private double price;
    private String description;
    private int categoryId;
    private String status;  // active/inactive

    public Product() {}
    public Product(String name, double price, String description, int categoryId, String status) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.categoryId = categoryId;
        this.status = status;
    }
    public Product(int id, String name, double price, String description, int categoryId, String status) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
        this.categoryId = categoryId;
        this.status = status;
    }

    // Getters and setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public int getCategoryId() { return categoryId; }
    public void setCategoryId(int categoryId) { this.categoryId = categoryId; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}