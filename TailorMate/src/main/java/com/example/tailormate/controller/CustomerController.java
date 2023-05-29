package com.example.tailormate.controller;

import com.example.tailormate.entity.Customers;
import com.example.tailormate.entity.Tailor;
import com.example.tailormate.service.CustomerService;
import com.example.tailormate.service.TailorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping("/add")
    public String addUser(@RequestBody Customers customers){
        customerService.addCustomer(customers);
        return "success add user";
    }


    @GetMapping("/")
    public List<Customers> getTailors(){
        return customerService.getCustomers();
    }

    @GetMapping("/get")
    public Customers getCustomer(@RequestParam Integer id){
        return customerService.getCustomer(id);
    }

    // Login

}