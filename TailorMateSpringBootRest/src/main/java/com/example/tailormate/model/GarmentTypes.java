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
@Table(name = "garment_types")
public class GarmentTypes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "garment_type_id")
    private int garmentTypeId;

    @Column(name = "garment_type_title", length = 1000)
    private String garmentTypeTitle;

    // Constructors, getters, and setters

    public void GarmentType() {
        // Default constructor
    }

    // Other constructors

    // Getters and setters for all fields

    public int getGarmentTypeId() {
        return garmentTypeId;
    }

    public void setGarmentTypeId(int garmentTypeId) {
        this.garmentTypeId = garmentTypeId;
    }

    public String getGarmentTypeTitle() {
        return garmentTypeTitle;
    }

    public void setGarmentTypeTitle(String garmentTypeTitle) {
        this.garmentTypeTitle = garmentTypeTitle;
    }
}