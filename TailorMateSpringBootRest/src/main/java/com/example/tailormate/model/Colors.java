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
@Table(name = "colors")
public class Colors {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "color_id")
    private int colorId;

    @Column(name = "color_title", length = 1000)
    private String colorTitle;

    // Constructors, getters, and setters

    // Other constructors

    // Getters and setters for all fields

    public int getColorId() {
        return colorId;
    }

    public void setColorId(int colorId) {
        this.colorId = colorId;
    }

    public String getColorTitle() {
        return colorTitle;
    }

    public void setColorTitle(String colorTitle) {
        this.colorTitle = colorTitle;
    }
}