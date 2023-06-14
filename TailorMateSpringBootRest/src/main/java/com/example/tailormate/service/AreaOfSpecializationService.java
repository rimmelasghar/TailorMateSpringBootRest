package com.example.tailormate.service;

import com.example.tailormate.model.AreaOfSpecialization;

import java.util.List;

public interface AreaOfSpecializationService {
    AreaOfSpecialization saveAreaOfSpecialization(AreaOfSpecialization areaOfSpecialization);
    AreaOfSpecialization updateAreaOfSpecialization(AreaOfSpecialization areaOfSpecialization);
    void deleteAreaOfSpecialization(int areaOfSpecializationId);
    AreaOfSpecialization getAreaOfSpecializationById(int areaOfSpecializationId);
    List<AreaOfSpecialization> getAllAreaOfSpecializations();
}
