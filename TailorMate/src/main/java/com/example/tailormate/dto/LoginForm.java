package com.example.tailormate.dto;

public class LoginForm {
    private String email;
    private String password;

    // Constructors, getters, and setters

    public LoginForm() {
        // Default constructor
    }

    public LoginForm(String email, String password) {
        this.email = email;
        this.password = password;
    }

    // Getters and setters for email and password

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
