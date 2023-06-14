package com.example.tailormate.service;

import com.example.tailormate.model.OrderDetail;

public interface OrderDetailService {
    OrderDetail getOrderDetailById(int orderDetailId);
    OrderDetail saveOrderDetail(OrderDetail orderDetail);
    void deleteOrderDetail(int orderDetailId);
}
