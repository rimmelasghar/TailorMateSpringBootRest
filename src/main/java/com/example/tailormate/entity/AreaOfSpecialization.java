package com.example.tailormate.entity;

import jakarta.persistence.*;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "area_of_specialization")
@NoArgsConstructor
@AllArgsConstructor
public class AreaOfSpecialization {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "area_of_specialization_id")
    private int areaOfSpecializationId;

    @Column(name = "area_of_specialization_title", length = 45)
    private String areaOfSpecializationTitle;

    // Constructors, getters, and setters

    // Other constructors

    // Getters and setters for all fields

    public int getAreaOfSpecializationId() {
        return areaOfSpecializationId;
    }

    public void setAreaOfSpecializationId(int areaOfSpecializationId) {
        this.areaOfSpecializationId = areaOfSpecializationId;
    }

    public String getAreaOfSpecializationTitle() {
        return areaOfSpecializationTitle;
    }

    public void setAreaOfSpecializationTitle(String areaOfSpecializationTitle) {
        this.areaOfSpecializationTitle = areaOfSpecializationTitle;
    }
}
