package com.example.tailormate.service.impl;

import com.example.tailormate.model.AreaOfSpecialization;
import com.example.tailormate.model.Colors;
import com.example.tailormate.repository.AreaOfSpecializationRepository;
import com.example.tailormate.repository.ColorsRepository;
import com.example.tailormate.service.AreaOfSpecializationService;
import com.example.tailormate.service.ColorsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ColorServiceImpl implements ColorsService {

    private final ColorsRepository colorsRepository;

    @Autowired
    public ColorServiceImpl(ColorsRepository colorsRepository) {
        this.colorsRepository = colorsRepository;
    }

    @Override
    public List<Colors> getAllColors() {
        return colorsRepository.findAll();
    }

    @Override
    public Colors getColorById(int colorId) {
        return colorsRepository.findById(colorId).orElse(null);
    }

    @Override
    public Colors saveColor(Colors color) {
        return colorsRepository.save(color);
    }

    @Override
    public Colors updateColor(Colors color) {
        return colorsRepository.save(color);
    }

    @Override
    public void deleteColor(int colorId) {
        colorsRepository.deleteById(colorId);
    }
}
