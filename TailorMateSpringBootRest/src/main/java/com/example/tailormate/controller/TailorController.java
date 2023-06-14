package com.example.tailormate.controller;
import com.example.tailormate.model.TailorDTO;


import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.example.tailormate.dto.ChangePasswordForm;
import com.example.tailormate.dto.LoginForm;
import com.example.tailormate.dto.SignupForm;
import com.example.tailormate.model.AreaOfSpecialization;
import com.example.tailormate.model.Tailor;
import com.example.tailormate.service.AreaOfSpecializationService;
import com.example.tailormate.service.TailorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
@RestController
@RequestMapping("/api/tailor")
public class TailorController {

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;


    @Autowired
    private TailorService tailorService;

    @GetMapping("/")
    public List<Tailor> getTailors(){
        return tailorService.getTailors();
    }

    @GetMapping("/{id}")
    public Tailor getTailors(@PathVariable int id){
        return tailorService.getTailorById(id);
    }

    @PostMapping("/add")
    public Tailor addTailor(@RequestBody TailorDTO tailorDTO) {


        if (tailorService.existsByEmail(tailorDTO.getEmailAddress())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Email already exists");
        }
        tailorDTO.setPassword(passwordEncoder.encode(tailorDTO.getPassword()));
        ModelMapper modelMapper = new ModelMapper();
        Tailor tailor = modelMapper.map(tailorDTO, Tailor.class);
        tailorService.addTailor(tailor);
        Tailor extTailor = tailorService.getTailorById(tailor.getTailorId());
        return extTailor;
    }

    @PutMapping("/{id}")
    public String updateTailor(@PathVariable int id,@RequestBody TailorDTO tailorDTO){
        Tailor existingTailor = tailorService.getTailorById(id);
        ModelMapper modelMapper = new ModelMapper();
        Tailor tailor = modelMapper.map(tailorDTO, Tailor.class);
        tailor.setPassword(existingTailor.getPassword());
        tailor.setTailorId(id);
        tailorService.updateTailor(tailor);
        return "success updated tailor";
    }

    // Login
    // work needed
    @PostMapping("/login")
    public Tailor getTailorsByEmail(@RequestBody LoginForm loginForm){
        String email = loginForm.getEmail();
        String password = loginForm.getPassword();
        Tailor tailor = tailorService.findTailorByEmailAddress(email);
        if (passwordEncoder.matches(password, tailor.getPassword())){
            return tailor;
        } else {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Login Unsuccessful");
        }
    }

    @PostMapping("/signup")
    public Tailor signup(@RequestBody SignupForm signupForm) {
        String email = signupForm.getEmail();
        String password = signupForm.getPassword();
        String username = signupForm.getUsername();
        // Additional fields as per your requirements

        // Check if email already exists
        if (tailorService.existsByEmail(email)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Email already exists");
        }

        // Create a new tailor entity
        Tailor tailor = new Tailor();
        String hashedPassword = passwordEncoder.encode(password);
        tailor.setPassword(hashedPassword);
        tailor.setEmailAddress(email);
        tailor.setUsername(username);
        // Save the tailor
        tailorService.addTailor(tailor);
//        Tailor exTailor = tailorService.findTailorByEmailAddress(tailor.getEmailAddress());
        return tailor;

    }
    @PostMapping("/change-password")
    public String changePassword(@RequestBody ChangePasswordForm changePasswordForm) {
        String email = changePasswordForm.getEmail();
        String currentPassword = changePasswordForm.getCurrentPassword();
        String newPassword = changePasswordForm.getNewPassword();

        // Retrieve the tailor by email
        Tailor tailor = tailorService.findTailorByEmailAddress(email);

        // Check if the current password matches
        if (!passwordEncoder.matches(currentPassword, tailor.getPassword())) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Current password is incorrect");
        }

        // Update the password
        String hashedPassword = passwordEncoder.encode(newPassword);
        tailor.setPassword(hashedPassword);
        tailorService.updateTailor(tailor);

        return "Password changed successfully";
    }

    @PutMapping("/forgotPassword")
    public ResponseEntity<String> forgotPassword(@RequestBody LoginForm loginForm){
        String email = loginForm.getEmail();
        String password = loginForm.getPassword();

        Tailor tailor = tailorService.findTailorByEmailAddress(email);
        String hashedPassword = passwordEncoder.encode(password);
        tailor.setPassword(hashedPassword);
        tailorService.updateTailor(tailor);
        return new ResponseEntity<>("Password Change",HttpStatus.OK);
    }
}
