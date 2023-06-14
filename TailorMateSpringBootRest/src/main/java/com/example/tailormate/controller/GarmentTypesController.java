package com.example.tailormate.controller;

import com.example.tailormate.model.AreaOfSpecialization;
import com.example.tailormate.model.GarmentTypes;
import com.example.tailormate.service.AreaOfSpecializationService;
import com.example.tailormate.service.GarmentTypesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/garmentTypes")
public class GarmentTypesController {

    @Autowired
    private GarmentTypesService garmentTypesService;

    @Autowired
    public GarmentTypesController(GarmentTypesService garmentTypesService) {
        this.garmentTypesService = garmentTypesService;
    }

    @GetMapping("/")
    public ResponseEntity<List<GarmentTypes>> getAllGarmentTypes() {
        List<GarmentTypes> garmentTypes = garmentTypesService.getAllGarmentTypes();
        return new ResponseEntity<>(garmentTypes, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GarmentTypes> getGarmentTypeById(@PathVariable("id") int id) {
        GarmentTypes garmentType = garmentTypesService.getGarmentTypeById(id);
        if (garmentType != null) {
            return new ResponseEntity<>(garmentType, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/")
    public ResponseEntity<GarmentTypes> saveGarmentType(@RequestBody GarmentTypes garmentType) {
        GarmentTypes savedGarmentType = garmentTypesService.saveGarmentType(garmentType);
        return new ResponseEntity<>(savedGarmentType, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<GarmentTypes> updateGarmentType(@PathVariable("id") int id, @RequestBody GarmentTypes garmentType) {
        GarmentTypes existingGarmentType = garmentTypesService.getGarmentTypeById(id);
        if (existingGarmentType != null) {
            garmentType.setGarmentTypeId(id);
            GarmentTypes updatedGarmentType = garmentTypesService.updateGarmentType(garmentType);
            return new ResponseEntity<>(updatedGarmentType, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGarmentType(@PathVariable("id") int id) {
        GarmentTypes existingGarmentType = garmentTypesService.getGarmentTypeById(id);
        if (existingGarmentType != null) {
            garmentTypesService.deleteGarmentType(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
