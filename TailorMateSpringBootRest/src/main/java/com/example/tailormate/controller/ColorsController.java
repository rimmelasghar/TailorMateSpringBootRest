package com.example.tailormate.controller;

import com.example.tailormate.model.AreaOfSpecialization;
import com.example.tailormate.model.Colors;
import com.example.tailormate.service.AreaOfSpecializationService;
import com.example.tailormate.service.ColorsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/colors")
public class ColorsController {

    private final ColorsService colorsService;

    @Autowired
    public ColorsController(ColorsService colorsService) {
        this.colorsService = colorsService;
    }

    @GetMapping("/")
    public ResponseEntity<List<Colors>> getAllColors() {
        List<Colors> colors = colorsService.getAllColors();
        if (colors.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(colors);
    }

    @GetMapping("/{colorId}")
    public ResponseEntity<Colors> getColorById(@PathVariable int colorId) {
        Colors color = colorsService.getColorById(colorId);
        if (color == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(color);
    }

    @PostMapping("/")
    public ResponseEntity<Colors> createColor(@RequestBody Colors color) {
        Colors createdColor = colorsService.saveColor(color);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdColor);
    }

    @PutMapping("/{colorId}")
    public ResponseEntity<Colors> updateColor(@PathVariable int colorId, @RequestBody Colors color) {
        Colors existingColor = colorsService.getColorById(colorId);
        if (existingColor == null) {
            return ResponseEntity.notFound().build();
        }
        color.setColorId(colorId);
        Colors updatedColor = colorsService.updateColor(color);
        return ResponseEntity.ok(updatedColor);
    }

    @DeleteMapping("/{colorId}")
    public ResponseEntity<Void> deleteColor(@PathVariable int colorId) {
        Colors existingColor = colorsService.getColorById(colorId);
        if (existingColor == null) {
            return ResponseEntity.notFound().build();
        }
        colorsService.deleteColor(colorId);
        return ResponseEntity.noContent().build();
    }
}
