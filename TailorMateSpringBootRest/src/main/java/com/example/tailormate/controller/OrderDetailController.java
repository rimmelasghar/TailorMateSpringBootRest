package com.example.tailormate.controller;

import com.example.tailormate.model.OrderDetail;
import com.example.tailormate.service.OrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/order-details")
public class OrderDetailController {

    private final OrderDetailService orderDetailService;

    @Autowired
    public OrderDetailController(OrderDetailService orderDetailService) {
        this.orderDetailService = orderDetailService;
    }


    @GetMapping("/{id}")
    public OrderDetail getOrderDetailById(@PathVariable("id") int orderDetailId) {
        return orderDetailService.getOrderDetailById(orderDetailId);
    }

    @PostMapping("/")
    public OrderDetail saveOrderDetail(@RequestBody OrderDetail orderDetail) {
        return orderDetailService.saveOrderDetail(orderDetail);
    }

    @DeleteMapping("/{id}")
    public void deleteOrderDetail(@PathVariable("id") int orderDetailId) {
        orderDetailService.deleteOrderDetail(orderDetailId);
    }
}
