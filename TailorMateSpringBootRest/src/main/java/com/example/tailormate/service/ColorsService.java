package com.example.tailormate.service;

import com.example.tailormate.model.Colors;

import java.util.List;

public interface ColorsService {
    List<Colors> getAllColors();

    Colors getColorById(int colorId);

    Colors saveColor(Colors color);

    Colors updateColor(Colors color);

    void deleteColor(int colorId);
}
