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
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private int orderId;

    @ManyToOne
    @JoinColumn(name = "tailor_id")
    private Tailor tailor;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customers customer;

    @Column(name = "created_at", length = 1000)
    private String createdAt;

    @Column(name = "expected_delivery_at", length = 1000)
    private String expectedDeliveryAt;

    @Column(name = "status")
    private Integer status;

    @Column(name = "price", length = 1000)
    private Double price;

    @Column(name = "delivery_address", length = 1000)
    private String deliveryAddress;

    @Column(name = "accepted_at", length = 1000)
    private String acceptedAt;

    @Column(name = "sent_for_delivery_at", length = 1000)
    private String sentForDeliveryAt;

    @Column(name = "completed_at", length = 1000)
    private String completedAt;

    @Column(name = "cancelled_at", length = 1000)
    private String cancelledAt;

    // Constructors, getters, and setters

    // Other constructors

    // Getters and setters for all fields

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
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

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getExpectedDeliveryAt() {
        return expectedDeliveryAt;
    }

    public void setExpectedDeliveryAt(String expectedDeliveryAt) {
        this.expectedDeliveryAt = expectedDeliveryAt;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public String getAcceptedAt() {
        return acceptedAt;
    }

    public void setAcceptedAt(String acceptedAt) {
        this.acceptedAt = acceptedAt;
    }

    public String getSentForDeliveryAt() {
        return sentForDeliveryAt;
    }

    public void setSentForDeliveryAt(String sentForDeliveryAt) {
        this.sentForDeliveryAt = sentForDeliveryAt;
    }

    public String getCompletedAt() {
        return completedAt;
    }

    public void setCompletedAt(String completedAt) {
        this.completedAt = completedAt;
    }

    public String getCancelledAt() {
        return cancelledAt;
    }

    public void setCancelledAt(String cancelledAt) {
        this.cancelledAt = cancelledAt;
    }
}