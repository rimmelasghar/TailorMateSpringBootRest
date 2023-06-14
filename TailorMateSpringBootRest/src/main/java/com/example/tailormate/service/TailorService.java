package com.example.tailormate.service;

import com.example.tailormate.model.Colors;
import com.example.tailormate.model.Tailor;

import java.util.List;

public interface TailorService {
    Tailor saveTailor(Tailor tailor);
    Tailor updateTailor(Tailor tailor);
    void deleteTailor(int tailorId);
    Tailor getTailorById(int tailorId);


    List<Tailor> getTailors();

    void addTailor(Tailor tailor);

    Tailor findTailorByEmailAddress(String email);

    boolean existsByEmail(String email);

}
