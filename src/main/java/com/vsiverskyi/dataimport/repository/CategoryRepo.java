package com.vsiverskyi.dataimport.repository;

import com.vsiverskyi.dataimport.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepo extends JpaRepository<Category, String> {
}
