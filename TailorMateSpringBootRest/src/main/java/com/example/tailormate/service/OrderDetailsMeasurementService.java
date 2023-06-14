package com.example.tailormate.service;

import com.example.tailormate.model.Colors;
import com.example.tailormate.model.OrderDetailsMeasurement;

import java.util.List;
public interface OrderDetailsMeasurementService {
    List<OrderDetailsMeasurement> getAllOrderDetailsMeasurements();
    OrderDetailsMeasurement getOrderDetailsMeasurementById(int id);
    OrderDetailsMeasurement saveOrderDetailsMeasurement(OrderDetailsMeasurement orderDetailsMeasurement);
    OrderDetailsMeasurement updateOrderDetailsMeasurement(OrderDetailsMeasurement orderDetailsMeasurement);
    void deleteOrderDetailsMeasurement(int id);
}
