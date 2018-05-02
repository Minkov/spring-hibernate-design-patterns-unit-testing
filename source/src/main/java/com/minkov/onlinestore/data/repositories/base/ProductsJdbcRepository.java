package com.minkov.onlinestore.data.repositories.base;

import com.minkov.onlinestore.data.entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

@Repository
public class ProductsJdbcRepository extends JdbcRepository<Product> {

    private Connection connection;

    @Autowired
    public ProductsJdbcRepository(Connection connection) {
        super(connection);
    }

    @Override
    protected Product loadBasicFromResultSet(ResultSet resultSet) throws SQLException {
        if (!resultSet.next()) {
            return null;
        }

        int id = resultSet.getInt("id");
        String name = resultSet.getString("name");
        int price = resultSet.getInt("price");
        BigDecimal quantity = resultSet.getBigDecimal("quantity");

        return new Product(id, name, price, quantity);
    }


    @Override
    protected Product loadDetailedFromResultSet(ResultSet resultSet) throws SQLException {
        if (!resultSet.next()) {
            return null;
        }

        int id = resultSet.getInt("ProductId");
        String name = resultSet.getString("ProductName");
        BigDecimal price = resultSet.getBigDecimal("Price");
        int quantity = resultSet.getInt("Quantity");
        String category = resultSet.getString("Category");

        Product product = new Product(id, name, quantity, price);
//        product.addCategory(category);

        return product;
    }

    @Override
    protected String getTableName() {
        return "products";
    }

    @Override
    protected List<String> getColumnNames() {
        return Arrays.asList("id", "name", "price", "quantity");
    }

    @Override
    protected void prepareInsertStatement(PreparedStatement query, Product entity) throws SQLException {
        query.setString(1, entity.getName());
        query.setBigDecimal(2, entity.getPrice());
        query.setInt(3, entity.getQuantity());
    }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    @Override
    protected String getGetAllQuery() {
        return "SELECT products.id as ProductId,\n" +
            "products.name as ProductName,\n" +
            "products.price as Price,\n" +
            "products.quantity as Quantity,\n" +
            "categories.name as Category\n" +
            "FROM products\n" +
            "LEFT JOIN products_categories\n" +
            "ON products_categories.product_id = products.id\n" +
            "LEFT JOIN categories\n" +
            "ON products_categories.category_id = categories.id";
    }
}