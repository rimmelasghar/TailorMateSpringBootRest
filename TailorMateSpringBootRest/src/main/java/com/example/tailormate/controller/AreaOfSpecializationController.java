package com.example.tailormate.controller;

import com.example.tailormate.model.AreaOfSpecialization;
import com.example.tailormate.service.AreaOfSpecializationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/area-of-specializations")
public class AreaOfSpecializationController {

    @Autowired
    private AreaOfSpecializationService areaOfSpecializationService;

    @PostMapping("/")
    public ResponseEntity<AreaOfSpecialization> createAreaOfSpecialization(@RequestBody AreaOfSpecialization areaOfSpecialization) {
        AreaOfSpecialization createdAreaOfSpecialization = areaOfSpecializationService.saveAreaOfSpecialization(areaOfSpecialization);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdAreaOfSpecialization);
    }

    @PutMapping("/{areaOfSpecializationId}")
    public ResponseEntity<AreaOfSpecialization> updateAreaOfSpecialization(@PathVariable int areaOfSpecializationId, @RequestBody AreaOfSpecialization areaOfSpecialization) {
        AreaOfSpecialization existingAreaOfSpecialization = areaOfSpecializationService.getAreaOfSpecializationById(areaOfSpecializationId);
        if (existingAreaOfSpecialization == null) {
            return ResponseEntity.notFound().build();
        }
        areaOfSpecialization.setAreaOfSpecializationId(areaOfSpecializationId);
        AreaOfSpecialization updatedAreaOfSpecialization = areaOfSpecializationService.updateAreaOfSpecialization(areaOfSpecialization);
        return ResponseEntity.ok(updatedAreaOfSpecialization);
    }

    @DeleteMapping("/{areaOfSpecializationId}")
    public ResponseEntity<Void> deleteAreaOfSpecialization(@PathVariable int areaOfSpecializationId) {
        AreaOfSpecialization existingAreaOfSpecialization = areaOfSpecializationService.getAreaOfSpecializationById(areaOfSpecializationId);
        if (existingAreaOfSpecialization == null) {
            return ResponseEntity.notFound().build();
        }
        areaOfSpecializationService.deleteAreaOfSpecialization(areaOfSpecializationId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{areaOfSpecializationId}")
    public ResponseEntity<AreaOfSpecialization> getAreaOfSpecialization(@PathVariable int areaOfSpecializationId) {
        AreaOfSpecialization areaOfSpecialization = areaOfSpecializationService.getAreaOfSpecializationById(areaOfSpecializationId);
        if (areaOfSpecialization == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(areaOfSpecialization);
    }

    @GetMapping("/")
    public ResponseEntity<List<AreaOfSpecialization>> getAllAreaOfSpecializations() {
        List<AreaOfSpecialization> areaOfSpecializations = areaOfSpecializationService.getAllAreaOfSpecializations();
        if (areaOfSpecializations.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(areaOfSpecializations);
    }
}
