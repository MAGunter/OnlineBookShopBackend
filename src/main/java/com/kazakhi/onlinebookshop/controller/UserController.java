package com.kazakhi.onlinebookshop.controller;

import com.kazakhi.onlinebookshop.dto.LoginRequest;
import com.kazakhi.onlinebookshop.dto.RegisterRequest;
import com.kazakhi.onlinebookshop.dto.UserResponse;
import com.kazakhi.onlinebookshop.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<UserResponse> register(@RequestBody RegisterRequest request) {
        return ResponseEntity.ok(userService.registerUser(request));
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequest request) {
        return ResponseEntity.ok(userService.authenticateUser(request));
    }

    @PostMapping("/logout")
    public ResponseEntity<Void> logout() {
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/profile")
    public ResponseEntity<UserResponse> getProfile(Principal principal) {
        return ResponseEntity.ok(userService.getCurrentUser(principal));
    }

    @PutMapping("/profile")
    public ResponseEntity<UserResponse> updateProfile(@RequestBody RegisterRequest request) {
        return ResponseEntity.ok(userService.updateProfile(request));
    }

    @PutMapping("/profile/avatar")
    public ResponseEntity<String> updateAvatar(@RequestBody String avatarUrl, Principal principal) {
        return ResponseEntity.ok(userService.updateAvatar(avatarUrl, principal));
    }
}

