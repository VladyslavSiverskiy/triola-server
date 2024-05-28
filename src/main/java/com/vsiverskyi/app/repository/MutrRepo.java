package com.vsiverskyi.app.repository;

import com.vsiverskyi.app.model.Mutr;
import com.vsiverskyi.app.model.MutrKey;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MutrRepo extends JpaRepository<Mutr, MutrKey> {
}
