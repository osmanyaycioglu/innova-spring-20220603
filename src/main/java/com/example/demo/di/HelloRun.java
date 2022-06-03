package com.example.demo.di;

import com.example.demo.Customer;
import com.example.demo.ICustomerDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.security.SecureRandom;
import java.util.Random;

@Component
public class HelloRun implements CommandLineRunner {

    @Autowired
    private Hello hello;

    @Autowired
    private ICustomerDao customerDao;

    @Override
    public void run(String... args) throws Exception {
        System.out.println(hello.helloWorld("osman"));
        Customer customer = new Customer();
        Random random = new SecureRandom();
        customer.setName("osman" + random.nextInt());
        customer.setSurname("yay" + random.nextInt());
        customer.setUsername("user" + random.nextInt());
        customer.setPassword(""+ random.nextInt());
        customer.setHeight(random.nextInt(220));
        customerDao.save(customer);
        System.out.println("Customer db ye yazıldı");
    }
}
