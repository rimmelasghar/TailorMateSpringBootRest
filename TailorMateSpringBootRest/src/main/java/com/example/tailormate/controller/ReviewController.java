package com.example.tailormate.controller;

import com.example.tailormate.model.Review;
import com.example.tailormate.model.Tailor;
import com.example.tailormate.service.ReviewService;
import com.example.tailormate.service.TailorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reviews/")
public class ReviewController {

    private final ReviewService reviewService;
    private final TailorService tailorService;

    @Autowired
    public ReviewController(ReviewService reviewService, TailorService tailorService) {
        this.reviewService = reviewService;
        this.tailorService = tailorService;
    }

    @GetMapping("/")
    public ResponseEntity<List<Review>> getAllReviews() {
        List<Review> reviews = reviewService.getAllReviews();
        return new ResponseEntity<>(reviews, HttpStatus.OK);
    }

    @GetMapping("/tailor/{id}")
    public ResponseEntity<List<Review>> getAllTailorReviews(@PathVariable int id){
        Tailor tailor = tailorService.getTailorById(id);
        List<Review> reviews = reviewService.getReviewsByTailor(tailor);
        return new ResponseEntity<>(reviews,HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Review> getReviewById(@PathVariable("id") int id) {
        Review review = reviewService.getReviewById(id);
        if (review != null) {
            return new ResponseEntity<>(review, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/")
    public ResponseEntity<Review> createReview(@RequestBody Review review) {
        Review savedReview = reviewService.saveReview(review);
        return new ResponseEntity<>(savedReview, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Review> updateReview(@PathVariable("id") int id, @RequestBody Review review) {
        Review existingReview = reviewService.getReviewById(id);
        if (existingReview != null) {
            review.setReviewId(id);
            Review updatedReview = reviewService.updateReview(review);
            return new ResponseEntity<>(updatedReview, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReview(@PathVariable("id") int id) {
        Review existingReview = reviewService.getReviewById(id);
        if (existingReview != null) {
            reviewService.deleteReview(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
