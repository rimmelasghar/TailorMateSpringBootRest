package com.example.tailormate.model;

import jakarta.persistence.*;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "reviews")
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "review_id")
    private int reviewId;

    @ManyToOne
    @JoinColumn(name = "tailor_id")
    private Tailor tailor;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customers customer;

    @Column(name = "rating", length = 45)
    private String rating;

    @Column(name = "review_text", length = 1000)
    private String reviewText;

    @Column(name = "created_at", length = 1000)
    private String createdAt;

    // Constructors, getters, and setters

    // Other constructors

    // Getters and setters for all fields

    public int getReviewId() {
        return reviewId;
    }

    public void setReviewId(int reviewId) {
        this.reviewId = reviewId;
    }

    public Tailor getTailor() {
        return tailor;
    }

    public void setTailor(Tailor tailor) {
        this.tailor = tailor;
    }

    public Customers getCustomer() {
        return customer;
    }

    public void setCustomer(Customers customer) {
        this.customer = customer;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getReviewText() {
        return reviewText;
    }

    public void setReviewText(String reviewText) {
        this.reviewText = reviewText;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }
}
