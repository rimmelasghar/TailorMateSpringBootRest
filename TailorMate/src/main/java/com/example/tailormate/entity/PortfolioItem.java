package com.example.tailormate.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "portfolios")
public class PortfolioItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "portfolio_item_id")
    private int portfolioItemId;

    @ManyToOne
    @JoinColumn(name = "tailor_id")
    private Tailor tailor;

    @Column(name = "title_text", length = 45)
    private String titleText;

    @Column(name = "image", length = 45)
    private String image;

    @Column(name = "description", length = 100)
    private String description;

    @Column(name = "created_at", length = 45)
    private String createdAt;

    // Constructors, getters, and setters

    // Other constructors

    // Getters and setters for all fields

    public int getPortfolioItemId() {
        return portfolioItemId;
    }

    public void setPortfolioItemId(int portfolioItemId) {
        this.portfolioItemId = portfolioItemId;
    }

    public Tailor getTailor() {
        return tailor;
    }

    public void setTailor(Tailor tailor) {
        this.tailor = tailor;
    }

    public String getTitleText() {
        return titleText;
    }

    public void setTitleText(String titleText) {
        this.titleText = titleText;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }
}