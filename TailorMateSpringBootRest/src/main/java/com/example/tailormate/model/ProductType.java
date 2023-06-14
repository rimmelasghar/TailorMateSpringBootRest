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
@Table(name = "product_types")
public class ProductType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_type_id")
    private int productTypeId;

    @Column(name = "product_type_title", length = 1000)
    private String productTypeTitle;

    // Constructors, getters, and setters

    // Other constructors

    // Getters and setters for all fields

    public int getProductTypeId() {
        return productTypeId;
    }

    public void setProductTypeId(int productTypeId) {
        this.productTypeId = productTypeId;
    }

    public String getProductTypeTitle() {
        return productTypeTitle;
    }

    public void setProductTypeTitle(String productTypeTitle) {
        this.productTypeTitle = productTypeTitle;
    }
}
