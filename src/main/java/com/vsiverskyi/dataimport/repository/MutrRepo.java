package com.vsiverskyi.dataimport.repository;

import com.vsiverskyi.dataimport.model.Mutr;
import com.vsiverskyi.dataimport.model.MutrKey;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MutrRepo extends JpaRepository<Mutr, MutrKey> {
}
