package com.kazakhi.onlinebookshop.controller;

import com.kazakhi.onlinebookshop.dto.LoginRequest;
import com.kazakhi.onlinebookshop.dto.RegisterRequest;
import com.kazakhi.onlinebookshop.dto.UserResponse;
import com.kazakhi.onlinebookshop.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
@Tag(name = "User", description = "User operations")
@CrossOrigin(origins = "http://localhost:3000")

public class UserController {

    private final UserService userService;

    @PostMapping("/register")
    @Operation(summary = "Register a user", description = "Register a user")
    public ResponseEntity<UserResponse> register(@RequestBody RegisterRequest request) {
        return ResponseEntity.ok(userService.registerUser(request));
    }

    @PostMapping("/login")
    @Operation(summary = "Login", description = "Login")
    public ResponseEntity<String> login(@RequestBody LoginRequest request) {
        return ResponseEntity.ok(userService.authenticateUser(request));
    }

    @PostMapping("/logout")
    @Operation(summary = "Logout", description = "Logout")
    public ResponseEntity<Void> logout() {
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/profile")
    @Operation(summary = "Get profile", description = "Get the profile of the current user")
    public ResponseEntity<UserResponse> getProfile(Principal principal) {
        return ResponseEntity.ok(userService.getCurrentUser(principal));
    }

    @PutMapping("/profile")
    @Operation(summary = "Update profile", description = "Update the profile of the current user")
    public ResponseEntity<UserResponse> updateProfile(@RequestBody RegisterRequest request) {
        return ResponseEntity.ok(userService.updateProfile(request));
    }

    @PutMapping("/profile/avatar")
    @Operation(summary = "Update avatar", description = "Update the avatar of the current user")
    public ResponseEntity<String> updateAvatar(@RequestBody String avatarUrl, Principal principal) {
        return ResponseEntity.ok(userService.updateAvatar(avatarUrl, principal));
    }
}

