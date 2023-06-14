package com.example.tailormate.repository;


import com.example.tailormate.model.Colors;
import com.example.tailormate.model.Customers;
import com.example.tailormate.model.Review;
import com.example.tailormate.model.Tailor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface ReviewRepository extends JpaRepository<Review, Integer> {
    List<Review> getReviewsByTailor(Tailor tailor);
}
