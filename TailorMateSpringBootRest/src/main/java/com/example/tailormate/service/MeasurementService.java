package com.example.tailormate.service;

import com.example.tailormate.model.Measurement;

import java.util.List;

public interface MeasurementService {
    List<Measurement> getAllMeasurements();
    Measurement getMeasurementById(int id);
    Measurement addMeasurement(Measurement measurement);
    Measurement updateMeasurement(Measurement measurement);
    void deleteMeasurement(int id);
}
