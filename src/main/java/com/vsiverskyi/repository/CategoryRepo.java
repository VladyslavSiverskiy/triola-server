package com.vsiverskyi.repository;

import com.vsiverskyi.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepo extends JpaRepository<Category, String> {
}
