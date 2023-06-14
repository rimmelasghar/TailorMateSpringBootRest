package com.example.tailormate.service.impl;

import com.example.tailormate.model.Measurement;
import com.example.tailormate.repository.MeasurementRepository;
import com.example.tailormate.service.MeasurementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MeasurementServiceImpl implements MeasurementService {

    private final MeasurementRepository measurementRepository;

    @Autowired
    public MeasurementServiceImpl(MeasurementRepository measurementRepository) {
        this.measurementRepository = measurementRepository;
    }

    @Override
    public List<Measurement> getAllMeasurements() {
        return measurementRepository.findAll();
    }

    @Override
    public Measurement getMeasurementById(int id) {
        Optional<Measurement> optionalMeasurement = measurementRepository.findById(id);
        return optionalMeasurement.orElse(null);
    }

    @Override
    public Measurement addMeasurement(Measurement measurement) {
        return measurementRepository.save(measurement);
    }

    @Override
    public Measurement updateMeasurement(Measurement measurement) {
        return measurementRepository.save(measurement);
    }

    @Override
    public void deleteMeasurement(int id) {
        measurementRepository.deleteById(id);
    }
}
