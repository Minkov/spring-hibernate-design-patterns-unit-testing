package com.minkov.onlinestore.data.repositories.base;

import com.minkov.onlinestore.data.entities.base.EntityModel;

import java.util.List;

public interface GenericRepository<T extends EntityModel> {
    List<T> getAll() throws Exception;

    T getById(int id) throws Exception;

    T create(T entity) throws Exception;

    void update(T entity);

    void update(int id, T entity);

    void delete(T entity);

    void delete(int id);
}
