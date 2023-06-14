package com.example.tailormate.controller;

import com.example.tailormate.model.ProductType;
import com.example.tailormate.service.ProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/productTypes")
public class ProductTypeController {

    private final ProductTypeService productTypeService;

    @Autowired
    public ProductTypeController(ProductTypeService productTypeService) {
        this.productTypeService = productTypeService;
    }

    @GetMapping("/")
    public ResponseEntity<List<ProductType>> getAllProductTypes() {
        List<ProductType> productTypes = productTypeService.getAllProductTypes();
        return ResponseEntity.ok(productTypes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductType> getProductTypeById(@PathVariable int id) {
        ProductType productType = productTypeService.getProductTypeById(id);
        if (productType != null) {
            return ResponseEntity.ok(productType);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/")
    public ResponseEntity<ProductType> addProductType(@RequestBody ProductType productType) {
        ProductType createdProductType = productTypeService.addProductType(productType);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdProductType);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductType> updateProductType(@PathVariable int id, @RequestBody ProductType updatedProductType) {
        ProductType productType = productTypeService.getProductTypeById(id);
        if (productType != null) {
            updatedProductType.setProductTypeId(id);
            ProductType savedProductType = productTypeService.updateProductType(updatedProductType);
            return ResponseEntity.ok(savedProductType);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProductType(@PathVariable int id) {
        ProductType productType = productTypeService.getProductTypeById(id);
        if (productType != null) {
            productTypeService.deleteProductType(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
