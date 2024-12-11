package com.kazakhi.onlinebookshop.service;

import com.kazakhi.onlinebookshop.dto.LoginRequest;
import com.kazakhi.onlinebookshop.dto.RegisterRequest;
import com.kazakhi.onlinebookshop.dto.UserResponse;
import com.kazakhi.onlinebookshop.entity.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    UserResponse registerUser(RegisterRequest request);
    UserResponse authenticateUser(LoginRequest request);
    UserResponse toUserResponse(User user);
    User getUserById(Long userId);
}
