package com.example.tailormate.model;

import jakarta.persistence.*;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Table(name = "measurements")
public class Measurement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "measurement_id")
    private int measurementId;

    @ManyToOne
    @JoinColumn(name = "product_type_id")
    private ProductType productType;

    @Column(name = "measurement_title",length = 1000)
    private String measurementTitle;

    public  ProductType getProductType(){
        return productType;
    }
    public void setProductType(ProductType productType){
        this.productType = productType;
    }
    public int getMeasurementId() {
        return measurementId;
    }

    public void setMeasurementId(int measurementId) {
        this.measurementId = measurementId;
    }


    public String getMeasurementTitle() {
        return measurementTitle;
    }

    public void setMeasurementTitle(String measurementTitle) {
        this.measurementTitle = measurementTitle;
    }
}
