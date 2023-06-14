package com.example.tailormate.repository;


import com.example.tailormate.model.Colors;
import com.example.tailormate.model.Customers;
import com.example.tailormate.model.OrderDetailsMeasurement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface OrderDetailsMeasurementRepository extends JpaRepository<OrderDetailsMeasurement, Integer> {
}
