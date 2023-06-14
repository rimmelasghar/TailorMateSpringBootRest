package com.example.tailormate.service.impl;

import com.example.tailormate.model.OrderDetail;
import com.example.tailormate.repository.OrderDetailRepository;
import com.example.tailormate.service.OrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderDetailServiceImpl implements OrderDetailService {

    private final OrderDetailRepository orderDetailRepository;

    @Autowired
    public OrderDetailServiceImpl(OrderDetailRepository orderDetailRepository) {
        this.orderDetailRepository = orderDetailRepository;
    }

    @Override
    public OrderDetail getOrderDetailById(int orderDetailId) {
        return orderDetailRepository.findById(orderDetailId).orElse(null);
    }

    @Override
    public OrderDetail saveOrderDetail(OrderDetail orderDetail) {
        return orderDetailRepository.save(orderDetail);
    }

    @Override
    public void deleteOrderDetail(int orderDetailId) {
        orderDetailRepository.deleteById(orderDetailId);
    }
}
