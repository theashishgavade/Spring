package com.ty.PresentationApp.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ty.PresentationApp.dto.UserRequestDto;
import com.ty.PresentationApp.dto.UserResponseDto;
import com.ty.PresentationApp.enums.Status;
import com.ty.PresentationApp.service.userService;

@RestController
@RequestMapping("/user")
public class UserController {

    private userService uService;

    public UserController(userService uService) {
        this.uService = uService;
    }

	/* For WebPage */
    
    
    
    // Register a new user
    @PostMapping("/register")
    @ResponseBody
    public ResponseEntity<String> registerUser(@RequestBody UserRequestDto request) {
        if (uService.registerUser(request)) {
            return ResponseEntity.ok("User registered successfully");
        } else {
            return ResponseEntity.badRequest().body("Email already exists");
        }
    }

    // Login a user
    @PostMapping("/login")
    @ResponseBody
    public ResponseEntity<String> login(@RequestParam String email, @RequestParam String password) {
        if (uService.login(email, password)) {
            return ResponseEntity.ok("Login successful");
        } else {
            return ResponseEntity.badRequest().body("Invalid email or password");
        }
    }

    // Logout a user (also changes the status to INACTIVE)
    @PostMapping("/logout")
    @ResponseBody
    public ResponseEntity<String> logout(@RequestParam String email) {
        uService.logout(email);
        return ResponseEntity.ok("Logout successful");
    }

    // Get user details by ID
    @GetMapping("/{userId}")
    @ResponseBody
    public ResponseEntity<UserResponseDto> getUserById(@PathVariable Integer userId) {
        UserResponseDto user = uService.getUserById(userId);
        return ResponseEntity.ok(user);
    }

    // Get all users (Admin only)
    @GetMapping("/all")
    @ResponseBody
    public ResponseEntity<List<UserResponseDto>> getAllUsers() {
        List<UserResponseDto> users = uService.getAllUsers();
        return ResponseEntity.ok(users);
    }

    // Update user status (Admin only)
    @PutMapping("/{userId}/status")
    @ResponseBody
    public ResponseEntity<String> updateUserStatus(@PathVariable Integer userId, @RequestParam Status status) {
        uService.updateUserStatus(userId, status);
        return ResponseEntity.ok("User status updated successfully");
    }
}
