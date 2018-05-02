package com.minkov.onlinestore.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Configuration
public class DiConfig {
    @Bean
    public Connection provideConnection() throws SQLException, ClassNotFoundException {
        // test if jdbc driver is available
        Class.forName("com.mysql.jdbc.Driver");

        Connection con = DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/onlinemarketdb", "root", "");
        return con;
    }
}
