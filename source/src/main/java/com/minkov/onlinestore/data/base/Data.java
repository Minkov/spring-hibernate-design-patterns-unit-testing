package com.minkov.onlinestore.data.base;

import com.minkov.onlinestore.entities.Product;

import java.util.List;

public interface Data {
    List<Product> getProducts();
    Product getProductById(int id);
}
