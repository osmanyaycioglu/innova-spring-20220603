package com.example.demo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

public interface ICustomerDao extends CrudRepository<Customer,Long> {
}
