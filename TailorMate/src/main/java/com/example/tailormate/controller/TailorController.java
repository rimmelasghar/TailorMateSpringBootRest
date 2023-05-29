package com.example.tailormate.controller;

import com.example.tailormate.dto.LoginForm;
import com.example.tailormate.entity.Tailor;
import com.example.tailormate.service.TailorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/tailor")
public class TailorController {

    @Autowired
    private TailorService tailorService;

    @PostMapping("/add")
    public String addUser(@RequestBody Tailor tailor){
        tailorService.addTailor(tailor);
        return "success add user";
    }


    @GetMapping("/")
    public List<Tailor> getTailors(){
        return tailorService.getTailors();
    }

    @GetMapping("/get")
    public Tailor getTailors(@RequestParam Integer id){
        return tailorService.getTailor(id);
    }

    // Login
    @GetMapping("/verify")
    public Tailor getTailorsByEmail(@RequestBody LoginForm loginForm){
        String email = loginForm.getEmail();
        String password = loginForm.getPassword();
        Tailor tailor = tailorService.findTailorByEmailAddress(email);
        if (tailor.getPassword().equals(password)){
            return tailor;
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Login Unsuccessful");
        }
    }
}
