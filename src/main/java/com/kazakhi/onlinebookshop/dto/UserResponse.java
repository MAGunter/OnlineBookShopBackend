package com.kazakhi.onlinebookshop.dto;

import lombok.Data;

@Data
public class UserResponse {
    private Long userId;
    private String name;
    private String email;
    private String phone;
    private String role;
    private boolean isActive;
}
