package com.minkov.onlinestore.web;

import com.minkov.onlinestore.data.entities.Product;
import com.minkov.onlinestore.data.repositories.base.GenericRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductsController {

    private final GenericRepository<Product> productRepository;

    @Autowired
    public ProductsController(GenericRepository<Product> productRepository) {
        this.productRepository = productRepository;
    }

    @CrossOrigin(origins = "http://localhost:8081")
    @RequestMapping
    public List<Product> getProducts() throws Exception {
        return productRepository.getAll();
    }

    @RequestMapping("/{id}")
    public Product getProductById(@PathVariable("id") String idString) throws Exception {
        int id = Integer.parseInt(idString);
        return productRepository.getById(id);
    }
}
