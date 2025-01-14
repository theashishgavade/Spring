package com.ty.PresentationApp.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.ty.PresentationApp.dto.UserRequestDto;
import com.ty.PresentationApp.dto.UserResponseDto;
import com.ty.PresentationApp.entity.User;
import com.ty.PresentationApp.enums.Status;
import com.ty.PresentationApp.exception.UserNotFoundException;
import com.ty.PresentationApp.repository.UserRepository;

@Service
public class userService {

    private UserRepository uRepo;

    public userService(UserRepository uRepo) {
        this.uRepo = uRepo;
    }

    /**
     * Registers a new user if the email is not already registered.
     */
    public boolean registerUser(UserRequestDto request) {
        Optional<User> opt = uRepo.findByEmail(request.getEmail());

        if (opt.isPresent()) {
            return false; // 
        } else {
            User user = new User();
            BeanUtils.copyProperties(request, user);
            user.setStatus(Status.INACTIVE); 
            uRepo.save(user);
            return true;
        }
    }

    /**
     * Logs in the user by email and password. Sets the user status to ACTIVE on success.
     */
    public boolean login(String email, String password) {
        User user = uRepo.findByEmail(email).orElseThrow(() -> new UserNotFoundException("User is not registered"));

        if (user.getPass() != null && user.getPass().equals(password)) {
            user.setStatus(Status.ACTIVE);
            uRepo.save(user); 
            return true;
        } else {
            return false; 
        }
    }

    /**
     * Logs out the user by setting their status to INACTIVE.
     */
    public void logout(String email) {
        User user = uRepo.findByEmail(email).orElseThrow(() -> new UserNotFoundException("User is not registered"));
        user.setStatus(Status.INACTIVE);
        uRepo.save(user); 
    }

    /**
     * Retrieves user details by ID (only for ACTIVE users).
     */
    public UserResponseDto getUserById(Integer userId) {
        User user = uRepo.findById(userId).orElseThrow(() -> new UserNotFoundException("User not found"));

        if (user.getStatus() != Status.ACTIVE) {
            throw new UserNotFoundException("Inactive user cannot perform this action");
        }

        UserResponseDto response = new UserResponseDto();
        BeanUtils.copyProperties(user, response);
        return response;
    }

    
    // --------------------------------- ADMIN -----------------------------------------
    
    
    /**
     * Retrieves all users (Admin only).
     */
    public List<UserResponseDto> getAllUsers() {
        List<User> users = uRepo.findAll();
        return users.stream().map(user -> {
            UserResponseDto response = new UserResponseDto();
            BeanUtils.copyProperties(user, response);
            return response;
        }).collect(Collectors.toList());
    }

    /**
     * Updates the status of a user (Admin only).
     */
    public void updateUserStatus(Integer userId, Status status) {
        User user = uRepo.findById(userId).orElseThrow(() -> new UserNotFoundException("User not found"));
        user.setStatus(status);
        uRepo.save(user); 
    }
}
