package com.example.tailormate.controller;

import com.example.tailormate.dto.ChangePasswordForm;
import com.example.tailormate.dto.LoginForm;
import com.example.tailormate.entity.Tailor;
import com.example.tailormate.dto.SignupForm;
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


    @GetMapping("/")
    public List<Tailor> getTailors(){
        return tailorService.getTailors();
    }

    @GetMapping("/get")
    public Tailor getTailors(@RequestParam Integer id){
        return tailorService.getTailor(id);
    }

    @PostMapping("/add")
    public String addTailor(@RequestBody Tailor tailor){
        tailorService.addTailor(tailor);
        return "success add user";
    }
    @PutMapping("/update")
    public String updateTailor(@RequestBody Tailor tailor){
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
        if (tailor.getPassword().equals(password)){
            return tailor;
        } else {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Login Unsuccessful");
        }
    }

    @PostMapping("/signup")
    public String signup(@RequestBody SignupForm signupForm) {
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
        tailor.setEmailAddress(email);
        tailor.setPassword(password);
        tailor.setUsername(username);
        // Set additional fields as per your requirements

        // Save the tailor
        tailorService.addTailor(tailor);

        return "success";
    }
    @PostMapping("/change-password")
    public String changePassword(@RequestBody ChangePasswordForm changePasswordForm) {
        String email = changePasswordForm.getEmail();
        String currentPassword = changePasswordForm.getCurrentPassword();
        String newPassword = changePasswordForm.getNewPassword();

        // Retrieve the tailor by email
        Tailor tailor = tailorService.findTailorByEmailAddress(email);

        // Check if the current password matches
        if (!tailor.getPassword().equals(currentPassword)) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Current password is incorrect");
        }

        // Update the password
        tailor.setPassword(newPassword);
        tailorService.updateTailor(tailor);

        return "Password changed successfully";
    }
}
