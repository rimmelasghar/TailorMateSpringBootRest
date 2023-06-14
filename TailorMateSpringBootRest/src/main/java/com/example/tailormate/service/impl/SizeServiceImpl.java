package com.example.tailormate.service.impl;

import com.example.tailormate.model.AreaOfSpecialization;
import com.example.tailormate.model.Size;
import com.example.tailormate.model.Tailor;
import com.example.tailormate.repository.AreaOfSpecializationRepository;
import com.example.tailormate.repository.SizeRepository;
import com.example.tailormate.repository.TailorRepository;
import com.example.tailormate.service.AreaOfSpecializationService;
import com.example.tailormate.service.SizeService;
import com.example.tailormate.service.TailorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SizeServiceImpl implements SizeService {

    private final SizeRepository sizeRepository;

    @Autowired
    public SizeServiceImpl(SizeRepository sizeRepository) {
        this.sizeRepository = sizeRepository;
    }

    @Override
    public List<Size> getAllSizes() {
        return sizeRepository.findAll();
    }

    @Override
    public Size getSizeById(int id) {
        return sizeRepository.findById(id).orElse(null);
    }

    @Override
    public Size saveSize(Size size) {
        return sizeRepository.save(size);
    }

    @Override
    public Size updateSize(Size size) {
        return sizeRepository.save(size);
    }

    @Override
    public void deleteSize(int id) {
        sizeRepository.deleteById(id);
    }
}
