package com.example.tailormate.service;

import com.example.tailormate.entity.Review;
import com.example.tailormate.entity.Tailor;

import java.util.List;

public interface ReviewService {

    void addReview(Review review);

    Review getReviewById(Integer Id);
    List<Review> getReviewsByTailor(Tailor tailor);

}
