package com.minkov.onlinestore.data;

import com.minkov.onlinestore.data.base.Data;
import com.minkov.onlinestore.entities.Product;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class InMemoryData implements Data {

    private static List<Product> products;

    static {
        products = new ArrayList<>();
        products.add(new Product(1, "Milk", 5, BigDecimal.valueOf(2)));
    }

    @Override
    public List<Product> getProducts() {
        return products;
    }

    @Override
    public Product getProductById(int id) {
        return products.stream()
            .filter(product -> product.getId() == id)
            .findFirst()
            .get();
    }
}
