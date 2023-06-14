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
@Table(name = "sizes")
public class Size {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "size_id")
    private int sizeId;

    @ManyToOne
    @JoinColumn(name = "product_type_id")
    private ProductType productType;

    @Column(name = "size_title", length = 1000)
    private String sizeTitle;

    // Constructors, getters, and setters

    // Other constructors

    // Getters and setters for all fields

    public int getSizeId() {
        return sizeId;
    }

    public void setSizeId(int sizeId) {
        this.sizeId = sizeId;
    }

    public ProductType getProductType() {
        return productType;
    }

    public void setProductType(ProductType productType) {
        this.productType = productType;
    }

    public String getSizeTitle() {
        return sizeTitle;
    }

    public void setSizeTitle(String sizeTitle) {
        this.sizeTitle = sizeTitle;
    }
}