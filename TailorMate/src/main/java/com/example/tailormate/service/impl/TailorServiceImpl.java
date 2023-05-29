package com.example.tailormate.service.impl;

import com.example.tailormate.entity.Customers;
import com.example.tailormate.entity.Tailor;
import com.example.tailormate.repository.TailorRepository;
import com.example.tailormate.service.TailorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

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


}
