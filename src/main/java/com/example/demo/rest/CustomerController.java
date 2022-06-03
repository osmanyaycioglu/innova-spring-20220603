package com.example.demo.rest;

import com.example.demo.Customer;
import com.example.demo.ICustomerDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private ICustomerDao customerDao;

    @PostMapping("/add")
    public String addCustomer(@RequestBody Customer customer) {
        customerDao.save(customer);
        return "Customer DB ye yazıldı";
    }

    @GetMapping("/delete/{cust}")
    public String deleteCustomer(@PathVariable("cust") Long customerId) {
        customerDao.deleteById(customerId);
        return "Customer : " + customerId + " deleted.";
    }

    @GetMapping("/get/all")
    public List<Customer> getAllCustomer() {
        List<Customer> customers = new ArrayList<>();
        Iterable<Customer> all = customerDao.findAll();
        for (Customer cu : all) {
            customers.add(cu);
        }
        return customers;
    }
}
