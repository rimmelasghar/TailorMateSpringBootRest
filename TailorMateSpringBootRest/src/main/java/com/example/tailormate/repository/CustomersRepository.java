package com.example.tailormate.repository;


import com.example.tailormate.model.Customers;
import com.example.tailormate.model.Tailor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomersRepository extends JpaRepository<Customers,Integer> {
    Customers findByEmailAddress(String email);
    Boolean existsByEmailAddress(String email);
}
