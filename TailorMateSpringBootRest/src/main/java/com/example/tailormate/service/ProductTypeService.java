package com.example.tailormate.service;

import com.example.tailormate.model.ProductType;

import java.util.List;

public interface ProductTypeService {
    List<ProductType> getAllProductTypes();
    ProductType getProductTypeById(int id);
    ProductType addProductType(ProductType productType);
    ProductType updateProductType(ProductType productType);
    void deleteProductType(int id);
}
