package com.example.tailormate.controller;

import com.example.tailormate.dto.ChangePasswordForm;
import com.example.tailormate.dto.LoginForm;
import com.example.tailormate.dto.SignupForm;
import com.example.tailormate.model.Customers;
import com.example.tailormate.model.CustomersDTO;
import com.example.tailormate.model.Tailor;
import com.example.tailormate.service.CustomersService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/customers")
public class CustomersController {

    private final CustomersService customerService;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public CustomersController(CustomersService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/")
    public ResponseEntity<List<Customers>> getAllCustomers() {
        List<Customers> customers = customerService.getAllCustomers();
        return ResponseEntity.ok(customers);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Customers> getCustomerById(@PathVariable int id) {
        Optional<Customers> optionalCustomer = customerService.getCustomerById(id);
        if (optionalCustomer.isPresent()) {
            Customers customer = optionalCustomer.get();
            return ResponseEntity.ok(customer);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/add")
    public Customers createCustomer(@RequestBody CustomersDTO customerDTO) {
        if (customerService.existsByEmail(customerDTO.getEmailAddress())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Email already exists");
        }
        customerDTO.setPassword(passwordEncoder.encode(customerDTO.getPassword()));
        ModelMapper modelMapper = new ModelMapper();
        Customers customers = modelMapper.map(customerDTO, Customers.class);
        customerService.addCustomer(customers);
        return customers;
    }

    @PutMapping("/{id}")
    public String updateCustomer(@PathVariable int id, @RequestBody Customers updatedCustomer) {
        Customers customer = customerService.getCustomerById(id).orElseThrow();
        if (customerService.existsByEmail(updatedCustomer.getEmailAddress())) {
            updatedCustomer.setCustomerId(id);
            if (updatedCustomer.getPassword()!= null){
                updatedCustomer.setPassword(passwordEncoder.encode(updatedCustomer.getPassword()));
                customerService.updateCustomer(id,updatedCustomer);
                return "Customer Updated SuccessFully";
            } else {
                updatedCustomer.setPassword(customer.getPassword());
                customerService.updateCustomer(id, updatedCustomer);
                return "Customer Updated SuccessFully";
            }
        } else {
            return  "Customer Updated UnsuccessFul";
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteCustomer(@PathVariable int id) {
        Optional<Customers> optionalCustomer = customerService.getCustomerById(id);
        if (optionalCustomer.isPresent()) {
            customerService.deleteCustomer(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @PostMapping("/login")
    public Customers getCustomersByEmail(@RequestBody LoginForm loginForm){
        String email = loginForm.getEmail();
        String password = loginForm.getPassword();
        Customers customers = customerService.findCustomersByEmailAddress(email);
        if (passwordEncoder.matches(password, customers.getPassword())){
            return customers;
        } else {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Login Unsuccessful");
        }
    }

    @PostMapping("/signup")
    public Customers signup(@RequestBody SignupForm signupForm) {
        String email = signupForm.getEmail();
        String password = signupForm.getPassword();
        String username = signupForm.getUsername();
        // Additional fields as per your requirements

        // Check if email already exists
        if (customerService.existsByEmail(email)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Email already exists");
        }

        // Create a new tailor entity
        Customers customers = new Customers();
        String hashedPassword = passwordEncoder.encode(password);
        customers.setPassword(hashedPassword);
        customers.setEmailAddress(email);
        customers.setUsername(username);
        // Save the tailor
        customerService.addCustomer(customers);
        return customers;
    }
    @PostMapping("/change-password")
    public String changePassword(@RequestBody ChangePasswordForm changePasswordForm) {
        String email = changePasswordForm.getEmail();
        String currentPassword = changePasswordForm.getCurrentPassword();
        String newPassword = changePasswordForm.getNewPassword();

        // Retrieve the tailor by email
        Customers customers = customerService.findCustomersByEmailAddress(email);

        // Check if the current password matches
        if (!passwordEncoder.matches(currentPassword, customers.getPassword())) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Current password is incorrect");
        }

        // Update the password
        String hashedPassword = passwordEncoder.encode(newPassword);
        customers.setPassword(hashedPassword);
        customerService.updateCustomer(customers.getCustomerId(),customers);

        return "Password changed successfully";
    }

    @PutMapping("/forgotPassword")
    public ResponseEntity<String> forgotPassword(@RequestBody LoginForm loginForm){
        String email = loginForm.getEmail();
        String password = loginForm.getPassword();

        Customers customers = customerService.findCustomersByEmailAddress(email);
        String hashedPassword = passwordEncoder.encode(password);
        customers.setPassword(hashedPassword);
        customerService.updateCustomer(customers.getCustomerId(),customers);
        return new ResponseEntity<>("Password Change",HttpStatus.OK);
    }
}
