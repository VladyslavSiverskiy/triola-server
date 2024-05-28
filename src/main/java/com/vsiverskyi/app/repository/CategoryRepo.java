package com.vsiverskyi.app.repository;

import com.vsiverskyi.app.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepo extends JpaRepository<Category, String> {
}
