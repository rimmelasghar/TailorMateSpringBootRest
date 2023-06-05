package com.example.tailormate.service.impl;

import com.example.tailormate.entity.Review;
import com.example.tailormate.entity.Tailor;
import com.example.tailormate.repository.ReviewRepository;
import com.example.tailormate.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    @Override
    public void addReview(Review review) {
        reviewRepository.save(review);
    }

    @Override
    public Review getReviewById(Integer id) {
        Review review = reviewRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "invalid Review id" + id));
        return review;
    }

    @Override
    public List<Review> getReviewsByTailor(Tailor tailor) {
        return reviewRepository.findAllByTailor(tailor);
    }


}
