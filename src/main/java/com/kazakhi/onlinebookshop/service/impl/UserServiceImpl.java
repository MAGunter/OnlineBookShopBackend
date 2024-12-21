package com.kazakhi.onlinebookshop.service.impl;

import com.kazakhi.onlinebookshop.dto.LoginRequest;
import com.kazakhi.onlinebookshop.dto.RegisterRequest;
import com.kazakhi.onlinebookshop.dto.UserResponse;
import com.kazakhi.onlinebookshop.entity.Role;
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
        // Проверка существования пользователя
        if (userRepository.findByEmail(request.getEmail()).isPresent()) {
            throw new IllegalArgumentException("Email is already in use");
        }

        User user = new User();
        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setPasswordHash(passwordEncoder.encode(request.getPassword()));
        user.setRole(Role.USER);
        user.setPhone(request.getPhone());
        user.setActive(true); // Устанавливаем пользователя как активного
        userRepository.save(user);

        return new UserResponse(user.getUserId(), user.getName(), user.getEmail());
    }

    @Override
    public boolean authenticateUserPlain(LoginRequest request) {
        // Ищем пользователя по email
        User user = userRepository.findByName(request.getName()).orElseThrow(() -> new RuntimeException("User not found"));
        // Проверяем пароль и имя
        user.setPasswordHash(passwordEncoder.encode(request.getPassword()));
        boolean isNameMatch = user.getName().equals(request.getName());
        boolean isPasswordMatch = passwordEncoder.matches(request.getPassword(), user.getPasswordHash());
        return isNameMatch && isPasswordMatch;
    }

    @Override
    public String authenticateUser(LoginRequest request) {
        return null;
    }

    @Override
    public UserResponse getCurrentUser(Principal principal) {
        // Получаем текущего пользователя из базы данных по email из Principal
        User user = userRepository.findByEmail(principal.getName())
                .orElseThrow(() -> new IllegalArgumentException("User not found"));

        // Возвращаем данные пользователя в виде DTO
        return new UserResponse(user.getUserId(), user.getName(), user.getEmail());
    }

    @Override
    public UserResponse updateProfile(RegisterRequest request) {
        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new IllegalArgumentException("User not found"));

        // Обновляем данные пользователя
        user.setName(request.getName());
        user.setPasswordHash(passwordEncoder.encode(request.getPassword()));
        userRepository.save(user);

        return new UserResponse(user.getUserId(), user.getName(), user.getEmail());
    }

    @Override
    public String updateAvatar(String avatarUrl, Principal principal) {
        // Получаем текущего пользователя по Principal
        User user = userRepository.findByEmail(principal.getName())
                .orElseThrow(() -> new IllegalArgumentException("User not found"));

        // Обновляем URL аватара
        user.setAvatarUrl(avatarUrl);
        userRepository.save(user);

        return user.getAvatarUrl();
    }

    @Override
    public User getUserById(Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));
    }
}


