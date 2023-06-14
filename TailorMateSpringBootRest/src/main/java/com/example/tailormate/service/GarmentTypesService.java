package com.example.tailormate.service;

import com.example.tailormate.model.Colors;
import com.example.tailormate.model.GarmentTypes;

import java.util.List;
public interface GarmentTypesService {
    List<GarmentTypes> getAllGarmentTypes();

    GarmentTypes getGarmentTypeById(int garmentTypeId);

    GarmentTypes saveGarmentType(GarmentTypes garmentType);

    GarmentTypes updateGarmentType(GarmentTypes garmentType);

    void deleteGarmentType(int garmentTypeId);
}
