package com.example.tailormate.service;

import com.example.tailormate.model.Colors;
import com.example.tailormate.model.Size;

import java.util.List;
public interface SizeService {
    List<Size> getAllSizes();
    Size getSizeById(int id);
    Size saveSize(Size size);
    Size updateSize(Size size);
    void deleteSize(int id);
}
