package com.example.tailormate.entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "measurements")
public class Measurement {

    @Id
    @Column(name = "measurement_id")
    private Integer measurementId;

    @ManyToOne
    @JoinColumn(name = "product_type_id", nullable = false)
    private ProductType productType;

    @Column(name = "measurement_title", nullable = false)
    private String measurementTitle;

    // Getters and Setters
    public Integer getMeasurementId() {
        return measurementId;
    }

    public void setMeasurementId(Integer measurementId) {
        this.measurementId = measurementId;
    }

    public ProductType getProductType() {
        return productType;
    }

    public void setProductType(ProductType productType) {
        this.productType = productType;
    }

    public String getMeasurementTitle() {
        return measurementTitle;
    }

    public void setMeasurementTitle(String measurementTitle) {
        this.measurementTitle = measurementTitle;
    }
}