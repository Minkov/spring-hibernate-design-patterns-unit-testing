package com.minkov.onlinestore.web;

import com.minkov.onlinestore.data.base.Data;
import com.minkov.onlinestore.entities.Product;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public class ProductsControllerTests {

    @Test
    public void getAll_returnMany_whenThereAreProducts() {
        List<Product> products = Arrays.asList(
            new Product(1, "Product 1", 3, BigDecimal.valueOf(3)),
            new Product(2, "Product 2", 3, BigDecimal.valueOf(3)),
            new Product(3, "Product 3", 3, BigDecimal.valueOf(3)),
            new Product(4, "Product 4", 3, BigDecimal.valueOf(3))
        );

        Data data = new Data() {
            @Override
            public List<Product> getProducts() {
                return products;
            }

            @Override
            public Product getProductById(int id) {
                return null;
            }
        };

        ProductsController controller = new ProductsController(data);

        List<Product> actual = controller.getProducts();

        Assert.assertArrayEquals(products.toArray(), actual.toArray());
    }
}
