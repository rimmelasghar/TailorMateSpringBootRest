package com.example.tailormate.repository;


import com.example.tailormate.model.Colors;
import com.example.tailormate.model.Customers;
import com.example.tailormate.model.Size;
import com.example.tailormate.model.Tailor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface TailorRepository extends JpaRepository<Tailor,Integer> {
    Tailor findByEmailAddress(String email);
    Boolean existsByEmailAddress(String email);
}

