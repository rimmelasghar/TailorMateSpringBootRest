package com.example.tailormate.controller;

import com.example.tailormate.dto.ChangePasswordForm;
import com.example.tailormate.dto.LoginForm;
import com.example.tailormate.dto.SignupForm;
import com.example.tailormate.entity.Customers;
import com.example.tailormate.entity.Tailor;
import com.example.tailormate.service.CustomerService;
import com.example.tailormate.service.TailorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping("/add")
    public String addUser(@RequestBody Customers customers){
        customerService.addCustomer(customers);
        return "success add user";
    }


    @GetMapping("/")
    public List<Customers> getTailors(){
        return customerService.getCustomers();
    }

    @GetMapping("/get")
    public Customers getCustomer(@RequestParam Integer id){
        return customerService.getCustomer(id);
    }

    // Login
    @PostMapping("/login")
    public Customers getCustomerByEmail(@RequestBody LoginForm loginForm){
        String email = loginForm.getEmail();
        String password = loginForm.getPassword();
        Customers customer = customerService.findCustomerByEmailAddress(email);
        if (customer.getPassword().equals(password)){
            return customer;
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
        if (customerService.existsByEmail(email)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Email already exists");
        }

        // Create a new tailor entity
        Customers customer = new Customers();
        customer.setEmailAddress(email);
        customer.setPassword(password);
        customer.setUsername(username);
        // Set additional fields as per your requirements

        // Save the tailor
        customerService.addCustomer(customer);

        return "success";
    }
    @PostMapping("/change-password")
    public String changePassword(@RequestBody ChangePasswordForm changePasswordForm) {
        String email = changePasswordForm.getEmail();
        String currentPassword = changePasswordForm.getCurrentPassword();
        String newPassword = changePasswordForm.getNewPassword();

        // Retrieve the tailor by email
        Customers customer = customerService.findCustomerByEmailAddress(email);

        // Check if the current password matches
        if (!customer.getPassword().equals(currentPassword)) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Current password is incorrect");
        }

        // Update the password
        customer.setPassword(newPassword);
        customerService.updateCustomer(customer);

        return "Password changed successfully";
    }
}