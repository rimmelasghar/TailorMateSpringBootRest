package com.example.tailormate.repository;


import com.example.tailormate.model.Colors;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface ColorsRepository extends JpaRepository<Colors, Integer> {
}
