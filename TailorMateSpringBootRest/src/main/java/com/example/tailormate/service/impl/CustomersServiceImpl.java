package com.example.tailormate.service.impl;

import com.example.tailormate.model.Customers;
import com.example.tailormate.repository.CustomersRepository;
import com.example.tailormate.service.CustomersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomersServiceImpl implements CustomersService {

    private final CustomersRepository customersRepository;

    @Autowired
    public CustomersServiceImpl(CustomersRepository customersRepository) {
        this.customersRepository = customersRepository;
    }

    @Override
    public List<Customers> getAllCustomers() {
        return customersRepository.findAll();
    }

    @Override
    public Optional<Customers> getCustomerById(int id) {
        return customersRepository.findById(id);
    }

    @Override
    public Customers createCustomer(Customers customer) {
        return customersRepository.save(customer);
    }

    @Override
    public Optional<Customers> updateCustomer(int id, Customers updatedCustomer) {
        Optional<Customers> optionalCustomer = customersRepository.findById(id);
        if (optionalCustomer.isPresent()) {
            updatedCustomer.setCustomerId(id);
            return Optional.of(customersRepository.save(updatedCustomer));
        } else {
            return Optional.empty();
        }
    }

    @Override
    public void addCustomer(Customers customers) {
        customersRepository.save(customers);
    }

    @Override
    public boolean deleteCustomer(int id) {
        Optional<Customers> optionalCustomer = customersRepository.findById(id);
        if (optionalCustomer.isPresent()) {
            customersRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean existsByEmail(String emailAddress) {
        return customersRepository.existsByEmailAddress(emailAddress);
    }

    @Override
    public Customers findCustomersByEmailAddress(String email) {
        return customersRepository.findByEmailAddress(email);
    }
}
