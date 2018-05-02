package com.minkov.onlinestore.data.repositories.base;

import com.minkov.onlinestore.data.entities.base.EntityModel;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public abstract class JdbcRepository<T extends EntityModel> implements GenericRepository<T> {
    private Connection connection;

    @Autowired
    public JdbcRepository(Connection connection) {
        setConnection(connection);
    }

    @Override
    public void update(T entity) {

    }

    @Override
    public void update(int id, T entity) {

    }

    @Override
    public void delete(T entity) {

    }

    @Override
    public void delete(int id) {

    }

    public List<T> getAll() throws Exception {
        List<T> entities = new ArrayList<>();

        Statement query = getConnection().createStatement();
        ResultSet rs = query.executeQuery(getGetAllQuery());

        while (true) {
            T entity = loadDetailedFromResultSet(rs);
            if (entity == null) {
                break;
            }

            entities.add(entity);
        }

        return entities;
    }

    protected String getGetAllQuery() {
        String columnNamesString = getColumnNames()
            .stream()
            .collect(Collectors.joining(", "));

        return "SELECT " + columnNamesString + "\n" +
            "FROM " + getTableName();
    }

    @Override
    public T getById(int id) {
        return null;
    }

    @Override
    public T create(T entity) {
        return null;
    }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    protected abstract void prepareInsertStatement(PreparedStatement query, T entity) throws SQLException;

    protected abstract T loadBasicFromResultSet(ResultSet resultSet) throws SQLException;

    protected abstract T loadDetailedFromResultSet(ResultSet rs) throws SQLException;

    protected abstract String getTableName();

    protected abstract List<String> getColumnNames();
}
