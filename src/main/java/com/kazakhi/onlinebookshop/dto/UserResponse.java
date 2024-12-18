package com.kazakhi.onlinebookshop.dto;

import lombok.Data;

@Data
public class UserResponse {
    private Integer userId;
    private String name;
    private String email;
    private String phone;
    private String role;
    private boolean isActive;

    public UserResponse(Integer userId, String name, String email){
        this.userId = userId;
        this.name = name;
        this.email = email;
    }
}
