package com.example.tailormate.service.impl;

import com.example.tailormate.entity.Tailor;
import com.example.tailormate.repository.TailorRepository;
import com.example.tailormate.service.TailorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class TailorServiceImpl implements TailorService {

    @Autowired
    private TailorRepository tailorRepository;

    @Override
    public void addTailor(Tailor user) {
        tailorRepository.save(user);
    }

    @Override
    public List<Tailor> getTailors() {
        List<Tailor> tailors = tailorRepository.findAll();
        // Remove password field from each Tailor object
        return tailors;
    }

    @Override
    public Tailor getTailor(Integer id) {
        Tailor tailor = tailorRepository
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "invalid Tailor id" + id));
        return tailor;
    }

    @Override
    public Tailor findTailorByEmailAddress(String email) {
        Tailor tailor = tailorRepository
                .findByEmailAddress(email);
        if (tailor != null){
            return tailor;
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "tailor doesn't exist");
        }
    }

    @Override
    public Tailor updateTailor(Tailor tailor) {
        Optional<Tailor> optionalTailor = tailorRepository.findById(tailor.getTailorId());
        Tailor existingTailor = optionalTailor.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Tailor doesn't exist"));

        // Update the properties of existingTailor with the values from tailor
        existingTailor.setEmailAddress(tailor.getEmailAddress());
        existingTailor.setUsername(tailor.getUsername());
        existingTailor.setBio(tailor.getBio());
        existingTailor.setLocation(tailor.getLocation());
        existingTailor.setAvatar(tailor.getAvatar());
        existingTailor.setCreatedAt(tailor.getCreatedAt());
        existingTailor.setUpdatedAt(tailor.getUpdatedAt());
        existingTailor.setAreaOfSpecialization(tailor.getAreaOfSpecialization());
        existingTailor.setExperience(tailor.getExperience());
        existingTailor.setPhoneNumber(tailor.getPhoneNumber());

        return tailorRepository.save(existingTailor);
    }

    @Override
    public boolean existsByEmail(String email) {
        return tailorRepository.existsByEmailAddress(email);
    }
}
