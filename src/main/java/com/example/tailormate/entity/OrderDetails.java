package com.example.tailormate.entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "order_details")
public class OrderDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_detail_id")
    private int orderDetailId;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    @ManyToOne
    @JoinColumn(name = "product_type_id")
    private ProductType productType;

    @Column(name = "design_details_text", length = 100)
    private String designDetailsText;

    @Column(name = "sample_img", length = 1000)
    private String sampleImg;

    @ManyToOne
    @JoinColumn(name = "garment_type_id")
    private GarmentTypes garmentType;

    @ManyToOne
    @JoinColumn(name = "color_id")
    private Colors color;

    @ManyToOne
    @JoinColumn(name = "size_id")
    private Size size;

    @Column(name = "instructions_text", length = 100)
    private String instructionsText;

    // Constructors, getters, and setters

    // Other constructors

    // Getters and setters for all fields

    public int getOrderDetailId() {
        return orderDetailId;
    }

    public void setOrderDetailId(int orderDetailId) {
        this.orderDetailId = orderDetailId;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public ProductType getProductType() {
        return productType;
    }

    public void setProductType(ProductType productType) {
        this.productType = productType;
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
        return color;
    }

    public void setColor(Colors color) {
        this.color = color;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public String getInstructionsText() {
        return instructionsText;
    }

    public void setInstructionsText(String instructionsText) {
        this.instructionsText = instructionsText;
    }
}