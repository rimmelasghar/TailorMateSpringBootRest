package com.example.tailormate.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "tailors")
@NoArgsConstructor
@AllArgsConstructor
public class Tailor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tailor_id")
    private int tailorId;

    @Column(name = "email_address", length = 100)
    private String emailAddress;

    @Column(name = "username", length = 1000)
    private String username;

    @JsonIgnore
    @Column(name = "password", length = 1000)
    private String password;


    @Column(name = "bio", length = 1000)
    private String bio;

    @Column(name = "location", length = 1000)
    private String location;

    @Column(name = "avatar", length = 1000)
    private String avatar;


    @Column(name = "created_at", length = 1000)
    private String createdAt;

    @Column(name = "updated_at", length = 1000)
    private String updatedAt;

    @ManyToOne
    @JoinColumn(name = "area_of_specialization_id")
    private AreaOfSpecialization areaOfSpecialization;

    @Column(name = "experience", length = 1000)
    private String experience;

    @Column(name = "phone_number",length = 1000)
    private String phoneNumber;

    // Constructors, getters, and setters
    // Other constructors
    // Getters and setters for all fields


    public int getTailorId() {
        return tailorId;
    }

    public void setTailorId(int tailorId) {
        this.tailorId = tailorId;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public AreaOfSpecialization getAreaOfSpecialization() {
        return areaOfSpecialization;
    }

    public void setAreaOfSpecialization(AreaOfSpecialization areaOfSpecialization) {
        this.areaOfSpecialization = areaOfSpecialization;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
