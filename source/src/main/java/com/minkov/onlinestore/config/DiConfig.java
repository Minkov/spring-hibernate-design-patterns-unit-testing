package com.minkov.onlinestore.config;

import com.minkov.onlinestore.data.entities.Product;
import com.minkov.onlinestore.data.repositories.HibernateRepository;
import com.minkov.onlinestore.data.repositories.base.GenericRepository;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DiConfig {
    @Bean
    public SessionFactory provideSessionFactory() {
        return HibernateUtils.getSessionFactory();
    }

    @Bean
    @Autowired
    public GenericRepository<Product> provideProductsRepository(SessionFactory sessionFactory) {
        HibernateRepository<Product> repository = new HibernateRepository<>(sessionFactory);
        repository.setEntityModelClass(Product.class);
        return repository;
    }
}
