package com.example.tailormate.service;

import com.example.tailormate.model.Colors;
import com.example.tailormate.model.Customers;
import com.example.tailormate.model.Order;
import com.example.tailormate.model.Tailor;

import java.util.List;

public interface OrderService {
    List<Order> getAllOrders();
    Order getOrderById(int id);
    Order saveOrder(Order order);
    Order updateOrder(Order order);
    void deleteOrder(int id);

    List<Order> getOrderByCustomer(Customers customers);

    List<Order> getOrderByTailor(Tailor tailor);

    List<Order> getOrderByTailorAndStatus(Tailor tailor, Integer status);

    List<Order> getOrderByCustomerAndStatus(Customers customers, Integer status);
}
