package com.kazakhi.onlinebookshop.service;

import com.kazakhi.onlinebookshop.dto.LoginRequest;
import com.kazakhi.onlinebookshop.dto.RegisterRequest;
import com.kazakhi.onlinebookshop.dto.UserResponse;
import com.kazakhi.onlinebookshop.entity.User;

import java.security.Principal;

public interface UserService {
    UserResponse registerUser(RegisterRequest request);
    String authenticateUser(LoginRequest request);
    UserResponse getCurrentUser(Principal principal);
    UserResponse updateProfile(RegisterRequest request);
    String updateAvatar(String avatarUrl, Principal principal);
    User getUserById(Long userId);
    boolean authenticateUserPlain(LoginRequest loginRequest);

}

