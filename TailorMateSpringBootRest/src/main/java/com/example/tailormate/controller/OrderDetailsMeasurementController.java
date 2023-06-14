package com.example.tailormate.controller;

import com.example.tailormate.model.AreaOfSpecialization;
import com.example.tailormate.model.OrderDetailsMeasurement;
import com.example.tailormate.service.AreaOfSpecializationService;
import com.example.tailormate.service.OrderDetailsMeasurementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/order-details-measurements")
public class OrderDetailsMeasurementController {

    private final OrderDetailsMeasurementService orderDetailsMeasurementService;

    @Autowired
    public OrderDetailsMeasurementController(OrderDetailsMeasurementService orderDetailsMeasurementService) {
        this.orderDetailsMeasurementService = orderDetailsMeasurementService;
    }

    @GetMapping("/")
    public ResponseEntity<List<OrderDetailsMeasurement>> getAllOrderDetailsMeasurements() {
        List<OrderDetailsMeasurement> orderDetailsMeasurements = orderDetailsMeasurementService.getAllOrderDetailsMeasurements();
        return new ResponseEntity<>(orderDetailsMeasurements, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderDetailsMeasurement> getOrderDetailsMeasurementById(@PathVariable("id") int id) {
        OrderDetailsMeasurement orderDetailsMeasurement = orderDetailsMeasurementService.getOrderDetailsMeasurementById(id);
        if (orderDetailsMeasurement != null) {
            return new ResponseEntity<>(orderDetailsMeasurement, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/")
    public ResponseEntity<OrderDetailsMeasurement> createOrderDetailsMeasurement(@RequestBody OrderDetailsMeasurement orderDetailsMeasurement) {
        OrderDetailsMeasurement savedOrderDetailsMeasurement = orderDetailsMeasurementService.saveOrderDetailsMeasurement(orderDetailsMeasurement);
        return new ResponseEntity<>(savedOrderDetailsMeasurement, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<OrderDetailsMeasurement> updateOrderDetailsMeasurement(@PathVariable("id") int id, @RequestBody OrderDetailsMeasurement orderDetailsMeasurement) {
        OrderDetailsMeasurement existingOrderDetailsMeasurement = orderDetailsMeasurementService.getOrderDetailsMeasurementById(id);
        if (existingOrderDetailsMeasurement != null) {
            orderDetailsMeasurement.setOrderDetailsMeasurementsId(id);
            OrderDetailsMeasurement updatedOrderDetailsMeasurement = orderDetailsMeasurementService.updateOrderDetailsMeasurement(orderDetailsMeasurement);
            return new ResponseEntity<>(updatedOrderDetailsMeasurement, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrderDetailsMeasurement(@PathVariable("id") int id) {
        OrderDetailsMeasurement existingOrderDetailsMeasurement = orderDetailsMeasurementService.getOrderDetailsMeasurementById(id);
        if (existingOrderDetailsMeasurement != null) {
            orderDetailsMeasurementService.deleteOrderDetailsMeasurement(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
