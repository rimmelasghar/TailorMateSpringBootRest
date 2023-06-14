package com.example.tailormate.model;

import jakarta.persistence.*;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "order_details_measurements")
public class OrderDetailsMeasurement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_details_measurements_id")
    private int orderDetailsMeasurementsId;

    @ManyToOne
    @JoinColumn(name = "order_detail_id")
    private OrderDetail orderDetail;

    @ManyToOne
    @JoinColumn(name = "measurement_id")
    private Measurement measurement;

    @Column(name = "measurement_value")
    private float measurementValue;

    public int getOrderDetailsMeasurementsId() {
        return orderDetailsMeasurementsId;
    }

    public void setOrderDetailsMeasurementsId(int orderDetailsMeasurementsId) {
        this.orderDetailsMeasurementsId = orderDetailsMeasurementsId;
    }

    public OrderDetail getOrderDetail() {
        return orderDetail;
    }

    public void setOrderDetail(OrderDetail orderDetail) {
        this.orderDetail = orderDetail;
    }

    public Measurement getMeasurement() {
        return measurement;
    }

    public void setMeasurement(Measurement measurement) {
        this.measurement = measurement;
    }

    public float getMeasurementValue() {
        return measurementValue;
    }

    public void setMeasurementValue(float measurementValue) {
        this.measurementValue = measurementValue;
    }
}
