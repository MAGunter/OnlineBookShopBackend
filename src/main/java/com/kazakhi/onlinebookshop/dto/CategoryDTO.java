package com.kazakhi.onlinebookshop.dto;

import com.kazakhi.onlinebookshop.entity.Category;

public record CategoryDTO(Integer id, String name, Category parentCategory) {
}
