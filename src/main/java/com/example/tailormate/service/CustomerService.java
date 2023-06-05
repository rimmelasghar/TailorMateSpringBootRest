package com.example.tailormate.service;

import com.example.tailormate.entity.Customers;
import com.example.tailormate.entity.Tailor;

import java.util.List;

public interface CustomerService {
    void addCustomer(Customers customers);

    List<Customers> getCustomers();

    Customers getCustomer(Integer id);

    Customers findCustomerByEmailAddress(String email);
    boolean existsByEmail(String email);

    void updateCustomer(Customers customer);

}
