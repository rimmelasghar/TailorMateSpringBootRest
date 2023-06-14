package com.example.tailormate.controller;

import com.example.tailormate.model.AreaOfSpecialization;
import com.example.tailormate.model.Size;
import com.example.tailormate.service.AreaOfSpecializationService;
import com.example.tailormate.service.SizeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sizes")
public class SizeController {

    private final SizeService sizeService;

    @Autowired
    public SizeController(SizeService sizeService) {
        this.sizeService = sizeService;
    }

    @GetMapping("/")
    public ResponseEntity<List<Size>> getAllSizes() {
        List<Size> sizes = sizeService.getAllSizes();
        return new ResponseEntity<>(sizes, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Size> getSizeById(@PathVariable("id") int id) {
        Size size = sizeService.getSizeById(id);
        if (size != null) {
            return new ResponseEntity<>(size, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/")
    public ResponseEntity<Size> createSize(@RequestBody Size size) {
        Size savedSize = sizeService.saveSize(size);
        return new ResponseEntity<>(savedSize, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Size> updateSize(@PathVariable("id") int id, @RequestBody Size size) {
        Size existingSize = sizeService.getSizeById(id);
        if (existingSize != null) {
            size.setSizeId(id);
            Size updatedSize = sizeService.updateSize(size);
            return new ResponseEntity<>(updatedSize, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSize(@PathVariable("id") int id) {
        Size existingSize = sizeService.getSizeById(id);
        if (existingSize != null) {
            sizeService.deleteSize(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
