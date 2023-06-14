package com.example.tailormate.repository;


import com.example.tailormate.model.AreaOfSpecialization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface AreaOfSpecializationRepository extends JpaRepository<AreaOfSpecialization, Integer> {
}