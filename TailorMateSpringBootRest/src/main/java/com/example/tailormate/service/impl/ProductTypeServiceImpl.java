package com.example.tailormate.service.impl;

import com.example.tailormate.model.ProductType;
import com.example.tailormate.repository.ProductTypeRepository;
import com.example.tailormate.service.ProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductTypeServiceImpl implements ProductTypeService {

    private final ProductTypeRepository productTypeRepository;

    @Autowired
    public ProductTypeServiceImpl(ProductTypeRepository productTypeRepository) {
        this.productTypeRepository = productTypeRepository;
    }

    @Override
    public List<ProductType> getAllProductTypes() {
        return productTypeRepository.findAll();
    }

    @Override
    public ProductType getProductTypeById(int id) {
        Optional<ProductType> optionalProductType = productTypeRepository.findById(id);
        return optionalProductType.orElse(null);
    }

    @Override
    public ProductType addProductType(ProductType productType) {
        return productTypeRepository.save(productType);
    }

    @Override
    public ProductType updateProductType(ProductType productType) {
        return productTypeRepository.save(productType);
    }

    @Override
    public void deleteProductType(int id) {
        productTypeRepository.deleteById(id);
    }
}
