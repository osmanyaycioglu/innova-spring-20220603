package com.example.demo.jpa;

import com.example.demo.Customer;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.util.List;

public class CustomerJpa {

    @PersistenceContext
    private EntityManagerFactory managerFactory;
    @PersistenceUnit
    private EntityManager entityManager;

    public void insert(Customer customer){
        EntityManager entityManager = managerFactory.createEntityManager();
        entityManager.joinTransaction();
        entityManager.getTransaction().begin();
        try{
            entityManager.persist(customer);
            entityManager.getTransaction().commit();
        } catch (Exception exception){
            entityManager.getTransaction().rollback();
        } finally {
            entityManager.close();
        }
    }

    @Transactional
    public void insert2(Customer customer) {
        entityManager.persist(customer);
    }

    public List<Customer> getCustomerBySurname(String surname){
        EntityManager entityManager = managerFactory.createEntityManager();
        TypedQuery<Customer> query = entityManager.createQuery("select c from Customer c where c.surname=?1",
                                                               Customer.class);
        query.setParameter(1,surname);
        return query.getResultList();
    }
}
