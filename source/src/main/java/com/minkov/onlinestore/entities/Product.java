package com.minkov.onlinestore.entities;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

public class Product {
    private int id;
    private String name;
    private int quantity;
    private BigDecimal price;
    private Set<Category> categories;

    public Product(int id, String name, int quantity, BigDecimal price) {
        setId(id);
        setName(name);
        setQuantity(quantity);
        setPrice(price);
        setCategories(new HashSet<Category>());
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Set<Category> getCategories() {
        return categories;
    }

    public void setCategories(HashSet<Category> categories) {
        this.categories = categories;
    }

    public void addCategory(Category category) {
        this.categories.add(category);
    }
}
