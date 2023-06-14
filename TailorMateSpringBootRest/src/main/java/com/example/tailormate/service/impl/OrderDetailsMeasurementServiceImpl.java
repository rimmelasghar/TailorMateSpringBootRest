package com.example.tailormate.service.impl;

import com.example.tailormate.model.AreaOfSpecialization;
import com.example.tailormate.model.OrderDetailsMeasurement;
import com.example.tailormate.model.Tailor;
import com.example.tailormate.repository.AreaOfSpecializationRepository;
import com.example.tailormate.repository.OrderDetailsMeasurementRepository;
import com.example.tailormate.repository.TailorRepository;
import com.example.tailormate.service.AreaOfSpecializationService;
import com.example.tailormate.service.OrderDetailsMeasurementService;
import com.example.tailormate.service.TailorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class OrderDetailsMeasurementServiceImpl implements OrderDetailsMeasurementService {

    private final OrderDetailsMeasurementRepository orderDetailsMeasurementRepository;

    @Autowired
    public OrderDetailsMeasurementServiceImpl(OrderDetailsMeasurementRepository orderDetailsMeasurementRepository) {
        this.orderDetailsMeasurementRepository = orderDetailsMeasurementRepository;
    }

    @Override
    public List<OrderDetailsMeasurement> getAllOrderDetailsMeasurements() {
        return orderDetailsMeasurementRepository.findAll();
    }

    @Override
    public OrderDetailsMeasurement getOrderDetailsMeasurementById(int id) {
        return orderDetailsMeasurementRepository.findById(id).orElse(null);
    }

    @Override
    public OrderDetailsMeasurement saveOrderDetailsMeasurement(OrderDetailsMeasurement orderDetailsMeasurement) {
        return orderDetailsMeasurementRepository.save(orderDetailsMeasurement);
    }

    @Override
    public OrderDetailsMeasurement updateOrderDetailsMeasurement(OrderDetailsMeasurement orderDetailsMeasurement) {
        return orderDetailsMeasurementRepository.save(orderDetailsMeasurement);
    }

    @Override
    public void deleteOrderDetailsMeasurement(int id) {
        orderDetailsMeasurementRepository.deleteById(id);
    }
}
