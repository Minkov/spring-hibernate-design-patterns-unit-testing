package com.minkov.onlinestore.web;

import com.minkov.onlinestore.data.base.Data;
import com.minkov.onlinestore.entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductsController {
    private final Data data;

    @Autowired
    public ProductsController(Data data) {
        this.data = data;
    }

    @CrossOrigin(origins = "http://localhost:8081")
    @RequestMapping
    public List<Product> getProducts() {
        return data.getProducts();
    }

    @RequestMapping("/{id}")
    public Product getProductById(@PathVariable("id") String idString) {
        try {
            int id = Integer.parseInt(idString);
            return data.getProductById(id);
        } catch (NumberFormatException ex) {
            throw ex;
        }
    }
}
