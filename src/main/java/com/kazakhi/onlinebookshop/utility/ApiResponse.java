package com.kazakhi.onlinebookshop.utility;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ApiResponse<T>{
    private T data;
    private String message;
}
