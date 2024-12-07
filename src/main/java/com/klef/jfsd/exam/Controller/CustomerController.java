package com.klef.jfsd.exam.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.klef.jfsd.exam.Repository.CustomerRepository;
import com.klef.jfsd.exam.Service.CustomerService;
import com.klef.jfsd.exam.model.Customer;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerService customerService;

    @PostMapping("/add")
    public Customer addCustomer(@RequestBody Customer customer) {
        return customerRepository.save(customer);
    }

    @GetMapping("/ageGreaterThan/{age}")
    public List<Customer> getCustomersByAgeGreaterThan(@PathVariable int age) {
        return customerService.findCustomersByAgeGreaterThan(age);
    }

    @GetMapping("/location/{location}")
    public List<Customer> getCustomersByLocation(@PathVariable String location) {
        return customerService.findCustomersByLocationLike(location);
    }
}
