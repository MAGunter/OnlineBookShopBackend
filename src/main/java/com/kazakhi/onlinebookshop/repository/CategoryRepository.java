package com.kazakhi.onlinebookshop.repository;

import com.kazakhi.onlinebookshop.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
