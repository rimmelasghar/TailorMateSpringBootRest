package com.example.tailormate.controller;

import com.example.tailormate.model.Customers;
import com.example.tailormate.model.Tailor;
import com.example.tailormate.model.Order;
import com.example.tailormate.service.CustomersService;
import com.example.tailormate.service.OrderService;
import com.example.tailormate.service.TailorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private final OrderService orderService;
    private final TailorService tailorService;

    private final CustomersService customersService;
    @Autowired
    public OrderController(OrderService orderService, TailorService tailorService, CustomersService customersService) {
        this.orderService = orderService;
        this.tailorService = tailorService;
        this.customersService = customersService;
    }

    @GetMapping("/")
    public ResponseEntity<List<Order>> getAllOrders() {
        List<Order> orders = orderService.getAllOrders();
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Order> getOrderById(@PathVariable("id") int id) {
        Order order = orderService.getOrderById(id);
        if (order != null) {
            return new ResponseEntity<>(order, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/")
    public ResponseEntity<Order> createOrder(@RequestBody Order order) {
        Order savedOrder = orderService.saveOrder(order);
        return new ResponseEntity<>(savedOrder, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Order> updateOrder(@PathVariable("id") int id, @RequestBody Order order) {
        Order existingOrder = orderService.getOrderById(id);
        if (existingOrder != null) {
            order.setOrderId(id);
            Order updatedOrder = orderService.updateOrder(order);
            return new ResponseEntity<>(updatedOrder, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrder(@PathVariable("id") int id) {
        Order existingOrder = orderService.getOrderById(id);
        if (existingOrder != null) {
            orderService.deleteOrder(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/tailors/{id}")
    public  ResponseEntity<List<Order>> getTailorOrders(@PathVariable int id,@RequestParam(required = false) Integer status){
        Tailor tailor = tailorService.getTailorById(id);
        if (status == null) {
            List<Order> orders = orderService.getOrderByTailor(tailor);
            return new ResponseEntity(orders, HttpStatus.OK);
        } else {
            List<Order> orders = orderService.getOrderByTailorAndStatus(tailor,status);
            return  new ResponseEntity<>(orders,HttpStatus.OK);
        }
    }

    @GetMapping("/customers/{id}")
    public ResponseEntity<List<Order>> getCustomerOrders(@PathVariable int id,@RequestParam(required = false) Integer status){
        Customers customers = customersService.getCustomerById(id).orElseThrow(() -> new IllegalArgumentException("Customer not found"));
        if (status == null){
        List<Order> orders = orderService.getOrderByCustomer(customers);
        return  new ResponseEntity<>(orders,HttpStatus.OK);
        } else {
            List<Order> orders = orderService.getOrderByCustomerAndStatus(customers,status);
            return  new ResponseEntity<>(orders,HttpStatus.OK);
        }
    }
}
