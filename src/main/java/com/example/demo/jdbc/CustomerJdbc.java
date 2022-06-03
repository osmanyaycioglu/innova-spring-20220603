package com.example.demo.jdbc;

import com.example.demo.Customer;
import org.springframework.beans.factory.annotation.Autowired;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerJdbc {
    @Autowired
    private DataSource dataSource;

    public void insert(Customer customer) throws SQLException {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement ps = connection.prepareStatement("INSERT INTO customer (name,surname,username,password,height) VALUES (?,?,?,?,?)");) {
            ps.setString(1,
                         customer.getName());
            ps.setString(2,
                         customer.getSurname());
            ps.setString(3,
                         customer.getUsername());
            ps.setString(4,
                         customer.getPassword());
            ps.setInt(5,
                      customer.getHeight());
            ps.execute();
        }
    }

    public List<Customer> getBySurname(String surname) throws SQLException {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement ps = connection.prepareStatement("SELECT NAME,SURNAME,USERNAME,PASSWORD,HEIGHT FROM customer where surname=?");) {
            ps.setString(1,
                         surname);
            ResultSet resultSet = ps.executeQuery();
            List<Customer> customers = new ArrayList<>();
            while (resultSet.next()) {
                Customer customer = new Customer();
                customer.setName(resultSet.getString(1));
                customer.setSurname(resultSet.getString(2));
                customer.setUsername(resultSet.getString(3));
                customer.setPassword(resultSet.getString(4));
                customer.setHeight(resultSet.getInt(5));
                customers.add(customer);
            }
            return customers;
        }
    }

}
