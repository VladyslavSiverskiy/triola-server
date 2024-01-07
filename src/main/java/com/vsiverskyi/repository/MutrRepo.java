package com.vsiverskyi.repository;

import com.vsiverskyi.model.Mutr;
import com.vsiverskyi.model.MutrKey;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MutrRepo extends JpaRepository<Mutr, MutrKey> {
}
