package com.example.tailormate.service.impl;

import com.example.tailormate.model.AreaOfSpecialization;
import com.example.tailormate.model.Review;
import com.example.tailormate.model.Tailor;
import com.example.tailormate.repository.AreaOfSpecializationRepository;
import com.example.tailormate.repository.ReviewRepository;
import com.example.tailormate.repository.TailorRepository;
import com.example.tailormate.service.AreaOfSpecializationService;
import com.example.tailormate.service.ReviewService;
import com.example.tailormate.service.TailorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ReviewServiceImpl implements ReviewService {

    private final ReviewRepository reviewRepository;

    @Autowired
    public ReviewServiceImpl(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    @Override
    public List<Review> getAllReviews() {
        return reviewRepository.findAll();
    }

    @Override
    public Review getReviewById(int id) {
        return reviewRepository.findById(id).orElse(null);
    }

    @Override
    public Review saveReview(Review review) {
        return reviewRepository.save(review);
    }

    @Override
    public Review updateReview(Review review) {
        return reviewRepository.save(review);
    }

    @Override
    public void deleteReview(int id) {
        reviewRepository.deleteById(id);
    }

    @Override
    public List<Review> getReviewsByTailor(Tailor tailor) {
        return reviewRepository.getReviewsByTailor(tailor);
    }
}
