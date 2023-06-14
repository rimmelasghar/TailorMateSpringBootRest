package com.example.tailormate.service.impl;

import com.example.tailormate.model.AreaOfSpecialization;
import com.example.tailormate.repository.AreaOfSpecializationRepository;
import com.example.tailormate.service.AreaOfSpecializationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AreaOfSpecializationServiceImpl implements AreaOfSpecializationService {

    @Autowired
    private AreaOfSpecializationRepository areaOfSpecializationRepository;

    @Override
    public AreaOfSpecialization saveAreaOfSpecialization(AreaOfSpecialization areaOfSpecialization) {
        return areaOfSpecializationRepository.save(areaOfSpecialization);
    }

    @Override
    public AreaOfSpecialization updateAreaOfSpecialization(AreaOfSpecialization areaOfSpecialization) {
        return areaOfSpecializationRepository.save(areaOfSpecialization);
    }

    @Override
    public void deleteAreaOfSpecialization(int areaOfSpecializationId) {
        areaOfSpecializationRepository.deleteById(areaOfSpecializationId);
    }

    @Override
    public AreaOfSpecialization getAreaOfSpecializationById(int areaOfSpecializationId) {
        return areaOfSpecializationRepository.findById(areaOfSpecializationId).orElse(null);
    }

    @Override
    public List<AreaOfSpecialization> getAllAreaOfSpecializations() {
        return areaOfSpecializationRepository.findAll();
    }

}
