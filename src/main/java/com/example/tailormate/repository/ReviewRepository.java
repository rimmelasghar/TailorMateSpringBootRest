package com.example.tailormate.repository;

import com.example.tailormate.entity.Review;

import com.example.tailormate.entity.Tailor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review,Integer> {
    List<Review> findAllByTailor(Tailor tailor);
}
