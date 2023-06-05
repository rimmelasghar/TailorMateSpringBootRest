package com.example.tailormate.repository;

import com.example.tailormate.entity.Customers;
import com.example.tailormate.entity.Tailor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TailorRepository extends JpaRepository<Tailor,Integer> {
    Tailor findByEmailAddress(String email);

    Boolean existsByEmailAddress(String email);
}

