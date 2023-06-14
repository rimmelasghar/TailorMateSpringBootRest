package com.example.tailormate.model;

import jakarta.persistence.*;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.awt.*;

@Entity
@Table(name = "order_details")
public class OrderDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_detail_id")
    private int orderDetailId;

    @OneToOne
    @JoinColumn(name = "order_id")
    private Order order;
    @ManyToOne
    @JoinColumn(name = "product_type_id")
    private ProductType productType;

    @Column(name = "design_details_text",length = 1000)
    private String designDetailsText;


    @Column(name = "sample_img",length = 1000)
    private String sampleImg;

    @OneToOne
    @JoinColumn(name = "garment_type_id")
    private GarmentTypes garmentType;

    @OneToOne
    @JoinColumn(name = "color_id")
    private Colors colors;

    @OneToOne
    @JoinColumn(name = "size_id")
    private Size size;

    @Column(name = "instructions_text",length = 1000)
    private String instructionsText;

    public int getOrderDetailId() {
        return orderDetailId;
    }

    public void setOrderDetailId(int orderDetailId) {
        this.orderDetailId = orderDetailId;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrderId(Order order) {
        this.order = order;
    }

    public ProductType getProductType() {
        return productType;
    }

    public void setProductType(ProductType productTypeId) {
        this.productType = productTypeId;
    }

    public String getDesignDetailsText() {
        return designDetailsText;
    }

    public void setDesignDetailsText(String designDetailsText) {
        this.designDetailsText = designDetailsText;
    }

    public String getSampleImg() {
        return sampleImg;
    }

    public void setSampleImg(String sampleImg) {
        this.sampleImg = sampleImg;
    }

    public GarmentTypes getGarmentType() {
        return garmentType;
    }

    public void setGarmentType(GarmentTypes garmentType) {
        this.garmentType = garmentType;
    }

    public Colors getColor() {
        return colors;
    }

    public void setColor(Colors color) {
        this.colors = color;
    }

    public Size getSizeId() {
        return size;
    }

    public void setSizeId(Size size) {
        this.size = size;
    }

    public String getInstructionsText() {
        return instructionsText;
    }

    public void setInstructionsText(String instructionsText) {
        this.instructionsText = instructionsText;
    }
}

