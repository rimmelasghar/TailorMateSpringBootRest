package com.example.tailormate.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


public class TailorDTO {



    private String emailAddress;


    private String username;


    private String password;


    private String bio;

    private String location;

    private String avatar;


    private String createdAt;

    private String updatedAt;


    private AreaOfSpecialization areaOfSpecialization;


    private String experience;

    private String phoneNumber;

    // Constructors, getters, and setters
    // Other constructors
    // Getters and setters for all fields


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
