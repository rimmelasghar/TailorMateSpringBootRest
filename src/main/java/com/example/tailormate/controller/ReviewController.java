package com.example.tailormate.controller;

import com.example.tailormate.entity.Review;
import com.example.tailormate.entity.Tailor;
import com.example.tailormate.service.ReviewService;
import com.example.tailormate.service.TailorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/review")
public class ReviewController {
    @Autowired
    private ReviewService reviewService;

    @PostMapping("/tailor")
    public List<Review> getTailorReview(@RequestBody Tailor tailor){
        return reviewService.getReviewsByTailor(tailor);
    }
    @GetMapping("/get")
    public Review getReview(@RequestParam Integer Id){
        return reviewService.getReviewById(Id);
    }
    @PostMapping("/add")
    public String addReview(@RequestBody Review review){
        reviewService.addReview(review);
        return "success add review";
    }

}
