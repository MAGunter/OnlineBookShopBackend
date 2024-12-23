package com.kazakhi.onlinebookshop.controller;

import com.kazakhi.onlinebookshop.dto.LoginRequest;
import com.kazakhi.onlinebookshop.dto.RegisterRequest;
import com.kazakhi.onlinebookshop.dto.UserResponse;
import com.kazakhi.onlinebookshop.service.UserService;
import com.kazakhi.onlinebookshop.utility.ApiResponse;
import com.kazakhi.onlinebookshop.utility.JwtUtil;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
@Tag(name = "User", description = "User operations")
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {

    private final UserService userService;
    private final JwtUtil jwtUtil;
    private final AuthenticationManager authenticationManager;

    @PostMapping("/register")
    @Operation(summary = "Register a user", description = "Register a new user")
    public ResponseEntity<ApiResponse<UserResponse>> register(@RequestBody RegisterRequest request) {
        UserResponse response = userService.registerUser(request);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new ApiResponse<>(response, "User registered successfully"));
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        try {
            // Проверяем email и пароль
            boolean isAuthenticated = userService.authenticateUserPlain(loginRequest);

            if (isAuthenticated) {
                return ResponseEntity.ok("Login successful");
            } else {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid username, email, or password");
            }
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error occurred during login");
        }
    }

    @PostMapping("/logout")
    @Operation(summary = "Logout", description = "Logout")
    public ResponseEntity<Void> logout() {
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/profile")
    @Operation(summary = "Get profile", description = "Retrieve the current user's profile")
    public ResponseEntity<ApiResponse<UserResponse>> getProfile(Principal principal) {
        UserResponse response = userService.getCurrentUser(principal);
        return ResponseEntity.ok(new ApiResponse<>(response, "Profile retrieved successfully"));
    }

    @PutMapping("/profile")
    @Operation(summary = "Update profile", description = "Update the current user's profile")
    public ResponseEntity<ApiResponse<UserResponse>> updateProfile(@RequestBody RegisterRequest request) {
        UserResponse response = userService.updateProfile(request);
        return ResponseEntity.ok(new ApiResponse<>(response, "Profile updated successfully"));
    }

    @PutMapping("/profile/avatar")
    @Operation(summary = "Update avatar", description = "Update the avatar of the current user")
    public ResponseEntity<String> updateAvatar(@RequestBody String avatarUrl, Principal principal) {
        return ResponseEntity.ok(userService.updateAvatar(avatarUrl, principal));
    }
}

