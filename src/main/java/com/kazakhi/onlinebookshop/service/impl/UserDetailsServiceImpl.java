package com.kazakhi.onlinebookshop.service.impl;

import com.kazakhi.onlinebookshop.entity.User;
import com.kazakhi.onlinebookshop.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User not found: " + email));

        return new org.springframework.security.core.userdetails.User(
                user.getEmail(), // Используем email в качестве имени пользователя
                user.getPasswordHash(), // Хэш пароля
                user.isActive(), // Активен ли пользователь
                true, // Учитывается ли срок действия
                true, // Заблокирован ли аккаунт
                true, // Доступен ли аккаунт
                List.of(new SimpleGrantedAuthority(user.getRole().name())) // Роли как GrantedAuthority
        );
    }


}
