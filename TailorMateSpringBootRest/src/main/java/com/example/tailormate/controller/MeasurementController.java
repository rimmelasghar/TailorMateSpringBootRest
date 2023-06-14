package com.example.tailormate.controller;

import com.example.tailormate.model.Measurement;
import com.example.tailormate.service.MeasurementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/measurements")
public class MeasurementController {

    private final MeasurementService measurementService;

    @Autowired
    public MeasurementController(MeasurementService measurementService) {
        this.measurementService = measurementService;
    }

    @GetMapping("/")
    public ResponseEntity<List<Measurement>> getAllMeasurements() {
        List<Measurement> measurements = measurementService.getAllMeasurements();
        return ResponseEntity.ok(measurements);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Measurement> getMeasurementById(@PathVariable int id) {
        Measurement measurement = measurementService.getMeasurementById(id);
        if (measurement != null) {
            return ResponseEntity.ok(measurement);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/")
    public ResponseEntity<Measurement> addMeasurement(@RequestBody Measurement measurement) {
        Measurement createdMeasurement = measurementService.addMeasurement(measurement);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdMeasurement);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Measurement> updateMeasurement(@PathVariable int id, @RequestBody Measurement updatedMeasurement) {
        Measurement measurement = measurementService.getMeasurementById(id);
        if (measurement != null) {
            updatedMeasurement.setMeasurementId(id);
            Measurement savedMeasurement = measurementService.updateMeasurement(updatedMeasurement);
            return ResponseEntity.ok(savedMeasurement);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMeasurement(@PathVariable int id) {
        Measurement measurement = measurementService.getMeasurementById(id);
        if (measurement != null) {
            measurementService.deleteMeasurement(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
