package com.example.tailormate.service;

import com.example.tailormate.entity.Tailor;

import java.util.List;

public interface TailorService {
    void addTailor(Tailor user);

    List<Tailor> getTailors();
    Tailor getTailor(Integer id);

    Tailor findTailorByEmailAddress(String email);

    Tailor updateTailor(Tailor user);

    boolean existsByEmail(String email);
}
