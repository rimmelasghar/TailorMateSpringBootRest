package com.example.tailormate.service.impl;

import com.example.tailormate.model.AreaOfSpecialization;
import com.example.tailormate.model.Customers;
import com.example.tailormate.model.Order;
import com.example.tailormate.model.Tailor;
import com.example.tailormate.repository.AreaOfSpecializationRepository;
import com.example.tailormate.repository.OrderRepository;
import com.example.tailormate.repository.TailorRepository;
import com.example.tailormate.service.AreaOfSpecializationService;
import com.example.tailormate.service.OrderService;
import com.example.tailormate.service.TailorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public Order getOrderById(int id) {
        return orderRepository.findById(id).orElse(null);
    }

    @Override
    public Order saveOrder(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public Order updateOrder(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public void deleteOrder(int id) {
        orderRepository.deleteById(id);
    }

    @Override
    public List<Order> getOrderByCustomer(Customers customers) {
        return orderRepository.getOrderByCustomer(customers);
    }

    @Override
    public List<Order> getOrderByTailor(Tailor tailor) {
        return orderRepository.getOrderByTailor(tailor);
    }

    @Override
    public List<Order> getOrderByTailorAndStatus(Tailor tailor, Integer status) {
        return orderRepository.getOrderByTailorAndStatus(tailor,status);
    }

    @Override
    public List<Order> getOrderByCustomerAndStatus(Customers customers, Integer status) {
        return orderRepository.getOrderByCustomerAndStatus(customers,status);
    }
}
