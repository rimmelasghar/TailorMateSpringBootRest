package com.example.tailormate.repository;

import com.example.tailormate.entity.Customers;
import com.example.tailormate.entity.Tailor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customers,Integer> {
    Customers findByEmailAddress(String email);
}
