package com.example.tailormate.repository;


import com.example.tailormate.model.Colors;
import com.example.tailormate.model.Customers;
import com.example.tailormate.model.Order;
import com.example.tailormate.model.Tailor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order,Integer> {

    List<Order> getOrderByCustomer(Customers customers);

    List<Order> getOrderByTailor(Tailor tailor);

    List<Order> getOrderByTailorAndStatus(Tailor tailor, Integer status);

    List<Order> getOrderByCustomerAndStatus(Customers customers, Integer status);
}
