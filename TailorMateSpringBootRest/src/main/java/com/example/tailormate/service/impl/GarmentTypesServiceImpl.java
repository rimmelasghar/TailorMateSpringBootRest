package com.example.tailormate.service.impl;

import com.example.tailormate.model.AreaOfSpecialization;
import com.example.tailormate.model.GarmentTypes;
import com.example.tailormate.model.Tailor;
import com.example.tailormate.repository.AreaOfSpecializationRepository;
import com.example.tailormate.repository.GarmentTypesRepository;
import com.example.tailormate.repository.TailorRepository;
import com.example.tailormate.service.AreaOfSpecializationService;
import com.example.tailormate.service.GarmentTypesService;
import com.example.tailormate.service.TailorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class GarmentTypesServiceImpl implements GarmentTypesService {

    private final GarmentTypesRepository garmentTypesRepository;

    @Autowired
    public GarmentTypesServiceImpl(GarmentTypesRepository garmentTypesRepository) {
        this.garmentTypesRepository = garmentTypesRepository;
    }

    @Override
    public List<GarmentTypes> getAllGarmentTypes() {
        return garmentTypesRepository.findAll();
    }

    @Override
    public GarmentTypes getGarmentTypeById(int garmentTypeId) {
        return garmentTypesRepository.findById(garmentTypeId).orElse(null);
    }

    @Override
    public GarmentTypes saveGarmentType(GarmentTypes garmentType) {
        return garmentTypesRepository.save(garmentType);
    }

    @Override
    public GarmentTypes updateGarmentType(GarmentTypes garmentType) {
        return garmentTypesRepository.save(garmentType);
    }

    @Override
    public void deleteGarmentType(int garmentTypeId) {
        garmentTypesRepository.deleteById(garmentTypeId);
    }
}
