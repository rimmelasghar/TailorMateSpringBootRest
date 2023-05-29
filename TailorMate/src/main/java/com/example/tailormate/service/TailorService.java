package com.example.tailormate.service;

import com.example.tailormate.entity.Customers;
import com.example.tailormate.entity.Tailor;

import java.util.List;

public interface TailorService {
    void addTailor(Tailor user);

    List<Tailor> getTailors();
    Tailor getTailor(Integer id);

    Tailor findTailorByEmailAddress(String email);
}
