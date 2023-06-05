package com.example.tailormate.service.impl;

import com.example.tailormate.entity.Customers;
import com.example.tailormate.entity.Tailor;
import com.example.tailormate.repository.CustomerRepository;
import com.example.tailormate.repository.TailorRepository;
import com.example.tailormate.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;
    @Override
    public void addCustomer(Customers customers) {
        customerRepository.save(customers);
    }

    @Override
    public List<Customers> getCustomers() {

        return customerRepository.findAll();
    }

    @Override
    public Customers getCustomer(Integer id) {
        Customers customer = customerRepository
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "invalid Customer id" + id));
        return customer;
    }

    @Override
    public Customers findCustomerByEmailAddress(String email) {
        Customers customer = customerRepository
                .findByEmailAddress(email);
        if (customer != null){
            return customer;
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Customer doesn't exist");
        }
}

    @Override
    public boolean existsByEmail(String email) {
        return customerRepository.existsByEmailAddress(email);
    }

    @Override
    public void updateCustomer(Customers customer) {
        Optional<Customers> updatedCustomer = customerRepository.findById(customer.getCustomerId());
        Customers existingCustomer = updatedCustomer.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Customer doesn't exist"));

        // Update the properties of existingTailor with the values from tailor
        existingCustomer.setEmailAddress(customer.getEmailAddress());
        existingCustomer.setUsername(customer.getUsername());
        existingCustomer.setBio(customer.getBio());
        existingCustomer.setLocation(customer.getLocation());
        existingCustomer.setAvatar(customer.getAvatar());
        existingCustomer.setCreatedAt(customer.getCreatedAt());
        existingCustomer.setUpdatedAt(customer.getUpdatedAt());
        existingCustomer.setAreaOfSpecialization(customer.getAreaOfSpecialization());
        existingCustomer.setExperience(customer.getExperience());
        existingCustomer.setPhoneNumber(customer.getPhoneNumber());
    }
}
