package com.example.demo;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface ICustomerDao extends CrudRepository<Customer,Long> {
    List<Customer> findBySurname(String surname);
    List<Customer> findBySurnameAndName(String surname,String name);
    List<Customer> findBySurnameAndNameOrderByName(String surname,String name);
    List<Customer> findBySurnameIn(List<String> surname);
    @Query("select c from Customer c where c.surname=?1")
    List<Customer> searchSurname(String surname);
    @Query(value = "select * from customer c where c.surname=?1",nativeQuery = true)
    List<Customer> searchSurnameNative(String surname);

    @Query("select c from Customer c where c.surname=:soy")
    List<Customer> searchSurname3(@Param("soy") String surname);


}
