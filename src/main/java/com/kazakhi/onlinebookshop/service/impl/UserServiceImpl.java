package com.kazakhi.onlinebookshop.service.impl;

import com.kazakhi.onlinebookshop.dto.LoginRequest;
import com.kazakhi.onlinebookshop.dto.RegisterRequest;
import com.kazakhi.onlinebookshop.dto.UserResponse;
import com.kazakhi.onlinebookshop.entity.User;
import com.kazakhi.onlinebookshop.repository.UserRepository;
import com.kazakhi.onlinebookshop.security.JwtTokenProvider;
import com.kazakhi.onlinebookshop.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.security.Principal;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;

    @Override
    public UserResponse registerUser(RegisterRequest request) {
        User user = new User();
        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setPasswordHash(passwordEncoder.encode(request.getPassword()));
        userRepository.save(user);

        return new UserResponse(user.getUserId(), user.getName(), user.getEmail());
    }

    @Override
    public String authenticateUser(LoginRequest request) {
        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (!passwordEncoder.matches(request.getPassword(), user.getPasswordHash())) {
            throw new RuntimeException("Invalid credentials");
        }

        return jwtTokenProvider.generateToken(user.getEmail());
    }

    @Override
    public UserResponse getCurrentUser(Principal principal) {
        // Получаем текущего пользователя из базы данных по email из Principal
        User user = userRepository.findByEmail(principal.getName())
                .orElseThrow(() -> new RuntimeException("User not found"));

        // Возвращаем данные пользователя в виде DTO
        return new UserResponse(user.getUserId(), user.getName(), user.getEmail());
    }


    @Override
    public UserResponse updateProfile(RegisterRequest request) {
        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException("User not found"));

        user.setName(request.getName());
        user.setPasswordHash(passwordEncoder.encode(request.getPassword()));
        userRepository.save(user);

        return new UserResponse(user.getUserId(), user.getName(), user.getEmail());
    }

    @Override
    public String updateAvatar(String avatarUrl, Principal principal) {
        // Получаем текущего пользователя по Principal
        User user = userRepository.findByEmail(principal.getName())
                .orElseThrow(() -> new RuntimeException("User not found"));

        // Обновляем URL аватара
        user.setAvatarUrl(avatarUrl);
        userRepository.save(user);

        // Возвращаем обновленный URL
        return user.getAvatarUrl();
    }


    @Override
    public User getUserById(Long userId) {
        return null;
    }
}

