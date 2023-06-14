package com.example.tailormate.service.impl;

import com.example.tailormate.model.AreaOfSpecialization;
import com.example.tailormate.model.Tailor;
import com.example.tailormate.repository.AreaOfSpecializationRepository;
import com.example.tailormate.repository.TailorRepository;
import com.example.tailormate.service.AreaOfSpecializationService;
import com.example.tailormate.service.TailorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TailorServiceImpl implements TailorService {

    @Autowired
    private TailorRepository tailorRepository;

    @Override
    public Tailor saveTailor(Tailor tailor) {
        return tailorRepository.save(tailor);
    }

    @Override
    public Tailor updateTailor(Tailor tailor) {
        return tailorRepository.save(tailor);
    }

    @Override
    public void deleteTailor(int tailorId) {
        tailorRepository.deleteById(tailorId);
    }

    @Override
    public Tailor getTailorById(int tailorId) {
        return tailorRepository.findById(tailorId).orElse(null);
    }

    @Override
    public List<Tailor> getTailors() {
        List<Tailor> tailors = tailorRepository.findAll();
        return tailors;
    }

    @Override
    public void addTailor(Tailor tailor) {
        tailorRepository.save(tailor);
    }

    @Override
    public Tailor findTailorByEmailAddress(String email) {
        return tailorRepository.findByEmailAddress(email);
    }

    @Override
    public boolean existsByEmail(String email) {
        return tailorRepository.existsByEmailAddress(email);
    }

}